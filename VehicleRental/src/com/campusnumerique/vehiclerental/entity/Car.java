package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

public class Car {

	private int id = 0;
	private String brand="";
	private String model="";
	private String color="";
	private String plateNumber="";
	private double price = 0;
	private double kmPrice= 0;
	private int horsePower= 0;
	
	public Car(int id, String brand, String model, String color, String plateNumber, double price, double kmPrice, int horsePower){
		setId(id);
		setBrand(brand);
		setModel(model);
		setColor(color);
		setPlateNumber(plateNumber);
		setPrice(price);
		setKmPrice(kmPrice);
		setHorsePower(horsePower);
	}
	

	

	public int getId() {
		return id;
	}




	public void setId(int id) {
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




	public String getColor() {
		return color;
	}




	public void setColor(String color) {
		this.color = color;
	}




	public String getPlateNumber() {
		return plateNumber;
	}




	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public double getKmPrice() {
		return kmPrice;
	}




	public void setKmPrice(double kmPrice) {
		this.kmPrice = kmPrice;
	}




	public int getHorsePower() {
		return horsePower;
	}




	public void setHorsePower(int horsePower) {
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