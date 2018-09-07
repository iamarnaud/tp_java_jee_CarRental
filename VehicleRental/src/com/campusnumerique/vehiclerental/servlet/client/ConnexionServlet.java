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

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.forms.Connexion;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/pages/connection.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* Préparation de l'objet formulaire */
		Connexion connexion = new Connexion();
		
//		Traitement de la requete et recuperation du bean
		ClientDAO clientDAO = new ClientDAO();
		Client client = connexion.connectedClient(request);
		
		if (!connexion.getErrors().isEmpty()) {
			request.setAttribute("connexion", connexion);
			doGet(request, response);
			return;
		}
		
		String pwd="";
		try {
			pwd = client.encrypt(client.getLogin(), "toto");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		try {
//			pwd = client.decrypt(pwd, "toto");
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		try {
			client = clientDAO.findByConnection(client.getMail(), pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (client.getLogin().equals("guest")) {
			String error = "Mot de passe et/ou email invalide(s)";
			request.setAttribute("error", error);
			doGet(request, response);
			return;
		}
		
		ClientBean connectedClient = new ClientBean(client.getFirstName(), client);
		
//		Recuperation depuis la requete
		HttpSession session = request.getSession();
		session.setAttribute("client", connectedClient);
		request.setAttribute("connexion", connexion);
				
		RequestDispatcher rd = request.getRequestDispatcher("ResaListServlet");
		rd.forward(request, response);
	}

}
