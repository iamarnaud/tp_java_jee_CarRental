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

import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.ConnexionForm;
import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.dao.ClientDAO;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = { "/connexion" })

public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_USER			= "clientBean";
	public static final String ATT_FORM			= "form";
	public static final String ATT_SESSION_USER = "sessionClient";
	public static final String VUE				= "/WEB-INF/connexion.jsp";
       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ConnexionServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Préparation de l'objet formulaire */
		ConnexionForm form = new ConnexionForm();
		
		/* Traitement de la requête et récupération du bean en résultant*/
		ClientBean client = form.connecterUtilisateur(request);
		
		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		
		/* instanciation du connectedClient et du clientDAO */
		Client connectedClient = new Client();
		ClientDAO clientDAO = new ClientDAO();
		
		/* vérification que les informations du connectedClient correspondent à ce qu'il y a en BDD */
		try {
			connectedClient = clientDAO.findConnectedClient(client.getMail(), client.getLogin());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 *  On récupère la session et on renvoie vers la page de liste des voitures si l'utilisateur existe en BDD,
		 *  sinon on reste sur la page Connexion. La methode doGet du Servlet renvoie vers la page Connextion*
		 *  
		 */
		if (connectedClient.getLogin().equals("guest")){
         session.setAttribute( ATT_SESSION_USER, null );
			request.setAttribute( ATT_FORM, form );
			doGet(request, response);
			return;
		}
		else{
            session.setAttribute( ATT_SESSION_USER, client );
    		session.setAttribute("connectedClient", connectedClient);
    		RequestDispatcher rd = request.getRequestDispatcher("CarServlet");
    		rd.forward(request, response);
		
		}
		
		
		/**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Client à la session, sinon suppression du bean de la session.
         */
//        if ( form.getErreurs().isEmpty() ) {
//        } else {
//            session.setAttribute( ATT_SESSION_USER, null );
//            /* Stockage du formulaire et du bean dans l'objet request */
//            
//            request.setAttribute( ATT_USER, client );
//
//            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
//        }

 		
	}
}
