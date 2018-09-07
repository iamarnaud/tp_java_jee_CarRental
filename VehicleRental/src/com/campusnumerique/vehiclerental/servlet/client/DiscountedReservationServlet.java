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
import com.campusnumerique.vehiclerental.entity.Reservation;

/**
 * Servlet implementation class DiscountedReservationServlet
 */
@WebServlet("/DiscountedReservationServlet")
public class DiscountedReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscountedReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int index = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		ArrayList<ReservationBean> resas = (ArrayList<ReservationBean>) session.getAttribute("resas");
		ReservationDAO resaDAO = new ReservationDAO();
		ReservationBean resaBean = resas.get(index);
		int i = 0;
		int totalPrice = 0;
		Reservation discountedResa = resaBean.getResa();
		
		for (ReservationBean reservationBean : resas) {
			if (reservationBean.getResa().getClientId() == resaBean.getResa().getClientId()) {
				totalPrice += reservationBean.getResa().getPrice();
				i++;
			}
		}
		
		if (!discountedResa.isDiscounted() && (i >= 3 || totalPrice >= 1000)) {		
			discountedResa.setPrice(discountedResa.getPrice() * 0.8);
			discountedResa.setDiscounted(true);
			resas.set(index, resaBean).setResa(discountedResa);
			
			resaDAO.update(discountedResa);
			
			request.setAttribute("resas", resas);
			this.getServletContext().getRequestDispatcher( "/pages/allReservations.jsp" ).forward( request, response );
		} else {
			String error = "Cette reservation ne remplie pas les conditions donnant droit à une reduction.";
			request.setAttribute("resas", resas);
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher( "/pages/allReservations.jsp" ).forward( request, response );
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
