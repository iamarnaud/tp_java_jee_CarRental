package com.campusnumerique.vehiclerental.entity;

import java.sql.Date;

import org.json.JSONObject;

public class Client {

	private int id=0;
	private String login="";
	private String firstName="";
	private String lastName="";
	private String mail="";
	private Date dob;
	private Date licenceDate;
	private String licenceNumber = "";
	private boolean isGuest=false;
	
	public Client(){
		setLogin("guest");
		setGuest(true);
	}
	
	public Client(int id, String login, String firstName, String lastName, String mail, Date dob, Date licenceDate, String licenceNumber){
		setId(id);
		setLogin(login);  
		setFirstName(firstName);
		setLastName(lastName);
		setMail(mail);
		setDob(dob);
		setLicenceDate(licenceDate);
		setLicenceNumber(licenceNumber);
		setGuest(false);
	}
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getLicenceDate() {
		return licenceDate;
	}

	public void setLicenceDate(Date licenceDate) {
		this.licenceDate = licenceDate;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	public JSONObject getInfos(){
		JSONObject infos= new JSONObject();
		infos.put("login", login);
		infos.put("id", id);
		infos.put("firstName", firstName);
		infos.put("lastName", lastName);
		infos.put("mail", mail);
		infos.put("isGuest", isGuest);
		return infos;
	}
	
	public String toString(){
		return getInfos().toString();
	}
}