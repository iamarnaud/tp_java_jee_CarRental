package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Reservation;

/**
 * Servlet implementation class reservation
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/pages/reservation.jsp" ).forward( request, response );
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Reservation resa = new Reservation();
		
		int nb= 0;
		try{
			nb = Integer.parseInt(request.getParameter("clientId").trim());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		resa.setClientId(nb);
		
		try{
			nb = Integer.parseInt(request.getParameter("kmestime"));
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}		resa.setEstimatedKm(nb);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(request.getParameter("datedebut"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resa.setStartDate(d);
		
		try {
			d = sdf.parse(request.getParameter("datefin"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resa.setEndDate(d);
		
		ReservationDAO resaDAO = new ReservationDAO();
//		try {
//			resaDAO.create(resa);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ArrayList<Reservation> resaList = new ArrayList<Reservation>();
		try {
			resaList = (ArrayList<Reservation>) resaDAO.findByClientId(resa.getClientId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (resaList.isEmpty()) {
			request.setAttribute("resa", resa);
			RequestDispatcher rd = request.getRequestDispatcher("CarAvailableServlet");
			rd.forward(request,response);
		} else {
			for (Reservation reservation : resaList) {
				if (resa.getStartDate().getTime() >= reservation.getStartDate().getTime() && resa.getStartDate().getTime() <= reservation.getEndDate().getTime()) {
					String error = "Vous avez deja une reservation en cours dans cette periode.";
					request.setAttribute("error", error);
					doGet(request, response);
				} else {
					if (resa.getEndDate().getTime() >= reservation.getStartDate().getTime() && resa.getEndDate().getTime() <= reservation.getEndDate().getTime()) {
						String error = "Vous avez deja une reservation en cours dans cette periode.";
						request.setAttribute("error", error);
						doGet(request, response);
					} else {
						if (resa.getStartDate().getTime() < reservation.getStartDate().getTime() && resa.getEndDate().getTime() > reservation.getEndDate().getTime()) {
							String error = "Vous avez deja une reservation en cours dans cette periode.";
							request.setAttribute("error", error);
							doGet(request, response);
						}
					}
				}
			}
		}
		
		request.setAttribute("resa", resa);
		RequestDispatcher rd = request.getRequestDispatcher("CarAvailableServlet");
		rd.forward(request, response);
		
	}

}
