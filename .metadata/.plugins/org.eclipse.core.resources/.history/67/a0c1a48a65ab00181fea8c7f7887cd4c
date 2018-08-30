package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

public class Car {

	private String id="";
	private String brand="";
	private String model="";
	private String color="";
	private String plateNumber="";
	private String price="";
	private String kmPrice="";
	private String horsePower="";
	
	public Car(String id, String brand, String model, String color, String plateNumber, String price, String kmPrice, String horsePower){
		setId(id);
		setBrand(brand);
		setModel(model);
		setColor(color);
		setPlateNumber(plateNumber);
		setPrice(price);
		setKmPrice(kmPrice);
		setHorsePower(horsePower);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color = color;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getPrice(){
		return price;
	}
	public void setPrice (String price) {
		this.price = price;
	}
	public String getKmPrice() {
		return kmPrice;
	}
	public void setKmPrice(String kmPrice) {
		this.kmPrice = kmPrice;
	}
	public String getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(String horsePower) {
		this.horsePower = horsePower;
	}
	

	public JSONObject getInfos(){
		JSONObject infos= new JSONObject();
		infos.put("brand", brand);
		infos.put("model", model);
		infos.put("color", color);
		infos.put("plateNumber", plateNumber);
		infos.put("price", price);
		infos.put("kmPrice", kmPrice);
		infos.put("horsePower", horsePower);
		return infos;
	}
}