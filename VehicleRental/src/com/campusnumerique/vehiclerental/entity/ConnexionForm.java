package com.campusnumerique.vehiclerental.entity;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.campusnumerique.vehiclerental.bean.ClientBean;

public final class ConnexionForm {
	private static final String CHAMP_EMAIL	= "mail";
	private static final String CHAMP_PASS 	= "login";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public ClientBean connecterUtilisateur(HttpServletRequest request) {
		/* Récupération des champs du formulaire */
		String mail = request.getParameter(CHAMP_EMAIL);
		String login = request.getParameter(CHAMP_PASS);

		ClientBean client = new ClientBean();

		/* Validation du champ email. */
		try {
			validationEmail(mail);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		client.setMail(mail);

		/* Validation du champ mot de passe. */
		try {
			validationLogin(login);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		client.setLogin(login);

		/* Initialisation du résultat global de la validation. */
		if (erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}
		return client;
	}

	/* Valide l'adresse email saisie. */
	private void validationEmail(String mail) throws Exception {
		if (mail != null && !mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	
	}

	/* Valide le mot de passe saisi. */
	private void validationLogin(String login) throws Exception {
		if (login != null || login == "") {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}

	/* Ajoute un message correspondant au champ spécifié à la map des erreurs. */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}


}