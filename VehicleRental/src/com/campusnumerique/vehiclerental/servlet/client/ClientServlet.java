package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO=null;
    /**
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() throws ClassNotFoundException {
        super();
        clientDAO= new ClientDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Client> clientslist = new ArrayList<Client>();
		ClientDAO clientDAO = new ClientDAO();
		try {
			clientslist = (ArrayList<Client>) clientDAO.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// on set l'attribut qu'on envoie à la vue
		request.setAttribute("clientslist", clientslist);
		this.getServletContext().getRequestDispatcher( "/pages/clients.jsp" ).forward( request, response );
		
//		String wAction = "";
//		JSONObject responseData = new JSONObject();
//	    PrintWriter out = response.getWriter();
//		response.setContentType("application/json");
//		if(request.getParameter("action")!=null && !request.getParameter("action").equals("")){
//			wAction=request.getParameter("action");
//			if(wAction.equals("getClients")){
//				
//					JSONArray clients = clientDAO.findAllAsJson();
//					responseData.put("clients", clients);
//					response.setStatus(HttpServletResponse.SC_OK);
//
//			}
//			out.println(responseData.toString());
//		}
//		else{
//			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
//			out.println("No action given");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
