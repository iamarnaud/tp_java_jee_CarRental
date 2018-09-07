package com.campusnumerique.vehiclerental.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.entity.Client;

/**
 * Servlet Filter implementation class ConnexionFilter2
 */
@WebFilter("/ConnexionFilter")
public class ConnexionFilter implements Filter {

	public static final String ACCES_CONNEXION	= "/WEB-INF/connexion.jsp";
	public static final String ATT_SESSION_USER	= "sessionClient";

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * Default constructor.
	 */
	public ConnexionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		/* Cast des objets request et response */
		HttpServletRequest request 	= (HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) res;
		
		/* Non filtrage des ressources statiques (css...) */
		String path = request.getRequestURI().substring( request.getContextPath().length() );
		
		if ( path.startsWith("/resources" ) || path.startsWith("/connexion")) {
			chain.doFilter(request, (ServletResponse) response);
		
			return;
		}

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("connectedClient");
		

		/**
		 * Si l'objet client n'existe pas dans la session en cours, alors
		 * l'utilisateur n'est pas connecté.
		 */
		if (session.getAttribute(ATT_SESSION_USER) == null || client==null || client.getLogin().equals("NoUserLogin") ) {
			/* Si le client n'est pas en bdd il est redirigé vers la page connexion */
			RequestDispatcher rd = request.getRequestDispatcher("connexion");
			rd.forward(request, response);
			
		} else {
			/*Sinon il peut afficher les pages restreintes */
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
