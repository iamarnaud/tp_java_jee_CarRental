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
 * Servlet Filter implementation class AgentFilter
 */
@WebFilter("/AgentFilter")
public class AgentFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AgentFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		/* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
     	
		/* Non-filtrage des ressources statiques */
	    String chemin = request.getRequestURI().substring( request.getContextPath().length() );
	    System.out.println(chemin);
	    if ( chemin.startsWith( "/resources" ) ) {
	    	System.out.println("test");
	        chain.doFilter( request, response );
	        return;
	    }
		
		HttpSession session = request.getSession();
		ClientBean clientBean = (ClientBean) session.getAttribute("client");
		
		/*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
    	if ( !clientBean.getClient().isAgent() ) {
            /* Redirection vers la page publique */
        	RequestDispatcher rd = request.getRequestDispatcher("ResaListServlet");
        	String error = "Vous n'avez pas les droits pour acceder à cette page";
        	request.setAttribute("error", error);
        	rd.forward(request, response);
        } else {
        
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
