package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.sun.org.apache.xerces.internal.impl.dv.dtd.NOTATIONDatatypeValidator;

/**
 * Servlet implementation class CarAvailableServlet
 */
@WebServlet("/CarAvailableServlet")
public class CarAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarAvailableServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Reservation resa = (Reservation) request.getAttribute("resa");
		Client client = new Client();
		ClientDAO clientDAO = new ClientDAO();
		try {
			client = clientDAO.find(resa.getClientId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// creation l'attribut "liste de voitures"
		// TODO nouvelle methode pour filter les voitures par age
		ArrayList<Car> carslist = new ArrayList<Car>();
		CarDAO carDAO = new CarDAO();

		if (client.getAge() < 21) {
			try {
				carslist = (ArrayList<Car>) carDAO.findByHorsePower(8);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (client.getAge() <= 25) {
			try {
				carslist = (ArrayList<Car>) carDAO.findByHorsePower(14);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			try {
				carslist = (ArrayList<Car>) carDAO.findAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!carslist.isEmpty()) {
			ArrayList<Car> availableCarList = new ArrayList<Car>();
			for (Car car : carslist) {
				ReservationDAO reservationDAO = new ReservationDAO();
				ArrayList<Reservation> resacar = new ArrayList<Reservation>();
				try {
					resacar = (ArrayList<Reservation>) reservationDAO.findByCarId(car.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				if (!resacar.isEmpty()) {
					boolean available = true;
					
					for (Reservation carReservation : resacar) {
						if (resa.getStartDate().getTime() >= carReservation.getStartDate().getTime()
								&& resa.getStartDate().getTime() <= carReservation.getEndDate().getTime()) {
							available = false;
							break;	

						} else if (resa.getEndDate().getTime() >= carReservation.getStartDate().getTime()
								&& resa.getEndDate().getTime() <= carReservation.getEndDate().getTime()) {
							available = false;
							break;
						
						} else if (resa.getStartDate().getTime() <= carReservation.getStartDate().getTime()
								&& resa.getEndDate().getTime() >= carReservation.getEndDate().getTime()) {
							available = false;
							break;	

						}
					} if (available) {
						availableCarList.add(car);
					}
					
				} else {
					availableCarList.add(car);
				}
			}

			// on set l'attribut qu'on envoie à la vue
			request.setAttribute("carslist", availableCarList);
			this.getServletContext().getRequestDispatcher("/pages/carsAvailable.jsp").forward(request, response);
			return; // return vide pour finir la méthode et permettre de passer
					// à la suite.
		}
		String noAvailableCar = "Pas de véhicule disponible aux dates demandées !";
		request.setAttribute("noAvailableCar", noAvailableCar);
		this.getServletContext().getRequestDispatcher("/pages/carsAvailable.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
