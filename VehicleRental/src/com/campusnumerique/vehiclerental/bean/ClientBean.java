package com.campusnumerique.vehiclerental.bean;

public class ClientBean {

	private String login;
	private String mail;


	public ClientBean(){
		setLogin("NoUserLogin");
		setMail("");
	}


	public ClientBean(String aLogin, String mail){
		setLogin(aLogin);
		setMail(mail);
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
