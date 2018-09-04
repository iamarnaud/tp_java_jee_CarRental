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
import com.campusnumerique.vehiclerental.dao.UtilitaryDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.entity.Utilitary;
import com.sun.org.apache.xerces.internal.impl.dv.dtd.NOTATIONDatatypeValidator;

/**
 * Servlet implementation class UtilitaryAvailableServlet
 */
@WebServlet("/UtilitaryAvailableServlet")
public class UtilitaryAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilitaryAvailableServlet() {
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
//		HttpSession session = request.getSession();
//		session.setAttribute("reservation", resa);

		// creation l'attribut "liste d'utilitaires"
		// TODO nouvelle methode pour filter les voitures par age
		ArrayList<Utilitary> utilitarieslist = new ArrayList<Utilitary>();
		UtilitaryDAO utilitaryDAO = new UtilitaryDAO();
		try {
			utilitarieslist = (ArrayList<Utilitary>) utilitaryDAO.findAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (!utilitarieslist.isEmpty()) {
			ArrayList<Utilitary> availableUtilitaryList = new ArrayList<Utilitary>();
			for (Utilitary utilitary : utilitarieslist) {
				ReservationDAO reservationDAO = new ReservationDAO();
				ArrayList<Reservation> resacar = new ArrayList<Reservation>();
				try {
					resacar = (ArrayList<Reservation>) reservationDAO.findByCarId(utilitary.getId());
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
						availableUtilitaryList.add(utilitary);
					}
					
				} else {
					availableUtilitaryList.add(utilitary);
				}
			}

			// on set l'attribut qu'on envoie à la vue
			request.setAttribute("utilitarieslist", availableUtilitaryList);
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
