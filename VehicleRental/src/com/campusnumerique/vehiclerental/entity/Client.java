package com.campusnumerique.vehiclerental.entity;

import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.time.LocalDate;
import java.time.Period;

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
	private boolean agent = false;
	
	public Client(){
		setLogin("guest");
		setGuest(true);
	}
	
	public Client(int id, String login, String firstName, String lastName, String mail, Date dob, Date licenceDate, String licenceNumber, boolean agent){
		setId(id);
		setLogin(login);  
		setFirstName(firstName);
		setLastName(lastName);
		setMail(mail);
		setDob(dob);
		setLicenceDate(licenceDate);
		setLicenceNumber(licenceNumber);
		setGuest(false);
		setAgent(agent);
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login!=null && !login.equals(""))
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

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isAgent() {
		return agent;
	}

	public void setAgent(boolean agent) {
		this.agent = agent;
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

	public int getAge() {
		LocalDate date = LocalDate.of(dob.getYear() + 1900, dob.getMonth() +1, dob.getDay() +1);
		LocalDate now = LocalDate.now();
		Period period = Period.between(date, now);
		return period.getYears();
	}
	
	public static String encrypt(String strClearText,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(strClearText.getBytes());
			strData=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
	
	public static String decrypt(String strEncrypted,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
			strData=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
}