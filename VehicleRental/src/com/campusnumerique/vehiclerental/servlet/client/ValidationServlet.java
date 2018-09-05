package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.MotorbikeDAO;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.dao.UtilitaryDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Motorbike;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.entity.Utilitary;
import com.mysql.cj.Session;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/pages/validation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Reservation resa = new Reservation();
		HttpSession session = request.getSession();
		resa = (Reservation) session.getAttribute("reservation");
		String choice = (String) session.getAttribute("type");
		int carId = Integer.parseInt(request.getParameter("carId"));
		resa.setCarId(carId);

		if (choice.equals("car")) {
			CarDAO carDAO = new CarDAO();
			Car car = new Car();
			try {
				car = (Car) carDAO.find(resa.getCarId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resa.setPrice(car.getEstimatedPrice(resa.getEstimatedKm()));

		} else if (choice.equals("utilitary")) {
			UtilitaryDAO utilitaryDAO = new UtilitaryDAO();
			Utilitary utilitary = new Utilitary();
			try {
				utilitary = utilitaryDAO.find(resa.getCarId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resa.setPrice(utilitary.getEstimatedPrice(resa.getEstimatedKm()));
		} else {
			MotorbikeDAO motorbikeDAO = new MotorbikeDAO();
			Motorbike motorbike = new Motorbike();
			try {
				motorbike = motorbikeDAO.find(resa.getCarId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resa.setPrice(motorbike.getEstimatedPrice(resa.getEstimatedKm()));
		}

		ReservationDAO resaDAO = new ReservationDAO();
		try {
			resaDAO.create(resa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("ResaListServlet");
		rd.forward(request, response);
	}

}
