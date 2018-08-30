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
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Reservation;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		Reservation resa = (Reservation) request.getAttribute("resa");
		ReservationDAO resaDAO = new ReservationDAO();
		try {
			resa = resaDAO.find(resa.getClientId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//creation l'attribut "liste de voitures"
		//TODO nouvelle methode pour filter les voitures par age
		ArrayList<Car> carslist = new ArrayList<Car>();
		CarDAO carDAO = new CarDAO();
		try {
			carslist = (ArrayList<Car>) carDAO.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// on set l'attribut qu'on envoie à la vue
		request.setAttribute("carslist", carslist);
		
		this.getServletContext().getRequestDispatcher( "/pages/carsAvailable.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
