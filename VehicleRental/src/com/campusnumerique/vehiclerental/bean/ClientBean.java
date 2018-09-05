package com.campusnumerique.vehiclerental.bean;

import com.campusnumerique.vehiclerental.entity.Client;

public class ClientBean {

	private String login;
	private Client client;

	public ClientBean(){
		setLogin("NoUserConnected");
		setClient(new Client());
	}

	public ClientBean(String aLogin, Client client){
		setLogin(aLogin);
		setClient(client);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
