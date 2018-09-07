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

import com.campusnumerique.vehiclerental.bean.ReservationBean;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;

/**
 * Servlet implementation class ReservationDeleteServlet
 */
@WebServlet("/ReservationDeleteServlet")
public class ReservationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int index = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		ArrayList<ReservationBean> resas = (ArrayList<ReservationBean>) session.getAttribute("resas");
		ReservationDAO resaDAO = new ReservationDAO();
		ReservationBean deletedResa = resas.get(index);
		resaDAO.delete(deletedResa.getResa());
		try {
			resas = (ArrayList<ReservationBean>) resaDAO.findAllResas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("resas", resas);
		this.getServletContext().getRequestDispatcher( "/pages/allReservations.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
