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
import com.campusnumerique.vehiclerental.dao.MotorbikeDAO;
import com.campusnumerique.vehiclerental.dao.UtilitaryDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Motorbike;
import com.campusnumerique.vehiclerental.entity.Utilitary;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		//creation l'attribut "liste de voitures"
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
		
		ArrayList<Motorbike> motoslist = new ArrayList<Motorbike>();
		MotorbikeDAO motorbikeDAO = new MotorbikeDAO();
		try {
			motoslist = (ArrayList<Motorbike>) motorbikeDAO.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("motoslist", motoslist);
		
		ArrayList<Utilitary> utilitarieslist = new ArrayList<Utilitary>();
		UtilitaryDAO utilitaryDAO = new UtilitaryDAO();
		try {
			utilitarieslist = (ArrayList<Utilitary>) utilitaryDAO.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("utilitarieslist", utilitarieslist);
		
		this.getServletContext().getRequestDispatcher( "/pages/cars.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
