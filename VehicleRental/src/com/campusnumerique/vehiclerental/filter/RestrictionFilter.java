package com.campusnumerique.vehiclerental.filter;

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

/**
 * Servlet Filter implementation class RestrictionFilter
 */
@WebFilter("/RestrictionFilter")
public class RestrictionFilter implements Filter {

	public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain ) throws IOException, ServletException {
    	/* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        ClientBean client = (ClientBean) session.getAttribute("client");

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
    	System.out.println(request.getRequestURI());
    	if (request.getRequestURI().startsWith("/VehicleRental/resources/")) {
        	System.out.println("test");
            chain.doFilter( request, response );
        } else if ( session.getAttribute("client") == null || client.getLogin().equals("NoUserConnected") ) {
            /* Redirection vers la page publique */
        	RequestDispatcher rd = request.getRequestDispatcher("ConnexionServlet");
			rd.forward(request, response);
        } else {
        
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
    }

    public void destroy() {
    }
}
