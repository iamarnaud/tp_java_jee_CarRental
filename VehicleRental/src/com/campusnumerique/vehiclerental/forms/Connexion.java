package com.campusnumerique.vehiclerental.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.campusnumerique.vehiclerental.entity.Client;

public final class Connexion {
	private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();
    
    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
    
    public Client connectedClient (HttpServletRequest request) {
    	
    	/* Récupération des champs du formulaire */
        String email = request.getParameter(CHAMP_EMAIL);
        String motDePasse = request.getParameter(CHAMP_PASS);
        
        Client client = new Client();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setError( CHAMP_EMAIL, e.getMessage() );
        }
        client.setMail(email);;

        /* Validation du champ mot de passe. */
        try {
            validationPassword( motDePasse );
        } catch ( Exception e ) {
            setError( CHAMP_PASS, e.getMessage() );
        }
        client.setLogin(motDePasse);;

        if (errors.isEmpty()) {
			result = "Succès de connexion";
		} else {
			result = "Echec de connexion";
		}
    	
    	return client;
    }

    /*
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }
    
    /*
     * Valide le mot de passe saisi.
     */
    private void validationPassword( String password ) throws Exception {
        if ( password == null || password == "" ) {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setError( String champ, String message ) {
        errors.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
}
