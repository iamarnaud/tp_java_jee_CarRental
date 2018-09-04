package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Motorbike;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.entity.Utilitary;
import com.sun.org.apache.xerces.internal.impl.dv.dtd.NOTATIONDatatypeValidator;

/**
 * Servlet implementation class MotorBikeAvailableServlet
 */
@WebServlet("/MotorBikeAvailableServlet")
public class MotorBikeAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MotorBikeAvailableServlet() {
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
		HttpSession session = request.getSession();
		session.setAttribute("reservation", resa);

		// creation l'attribut "liste d'utilitaires"
		// TODO nouvelle methode pour filter les voitures par age
		ArrayList<Motorbike> motoslist = new ArrayList<Motorbike>();
		MotorbikeDAO motorBikeDAO = new MotorbikeDAO();
		motoslist = motorBikeDAO.findAll();

		if (!motoslist.isEmpty()) {
			ArrayList<Motorbike> availableMotoList = new ArrayList<Motorbike>();
			for (Motorbike motoBike : motoslist) {
				ReservationDAO reservationDAO = new ReservationDAO();
				ArrayList<Reservation> resacar = new ArrayList<Reservation>();
				try {
					resacar = (ArrayList<Reservation>) reservationDAO.findByCarId(motoBike.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				if (!resacar.isEmpty()) {
					boolean available = true;
					
					for (Reservation carReservation : resacar) {

						if (resa.getStartDate().getTime() <= carReservation.getEndDate().getTime()
							&& resa.getEndDate().getTime() >= carReservation.getStartDate().getTime()) {
							available = false;
							break;
						}
					} if (available) {
						availableMotoList.add(motoBike);
					}
					
				} else {
					availableMotoList.add(motoBike);
				}
			}

			// on set l'attribut qu'on envoie à la vue
			request.setAttribute("utilitarieslist", availableMotoList);
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
		
		doGet(request, response);
	}

}
