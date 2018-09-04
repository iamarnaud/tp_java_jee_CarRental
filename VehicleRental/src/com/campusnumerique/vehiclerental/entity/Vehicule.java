package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

public abstract class Vehicule {

	private int id;
	private String brand;
	private String model;
	private String color;
	private String plateNumber;
	private double price;
	private double kmPrice;
	private String type;

	public Vehicule() {
		
	}
	
	public Vehicule(int id, String brand, String model, String color, String plateNumber, double price, double kmPrice, String type){
		setId(id);
		setBrand(brand);
		setModel(model);
		setColor(color);
		setPlateNumber(plateNumber);
		setPrice(price);
		setKmPrice(kmPrice);
		setType(type);
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
	public double getPrice(){
		return price;
	}
	public void setPrice (double price) {
		this.price = price;
	}
	public double getKmPrice() {
		return kmPrice;
	}
	public void setKmPrice(double kmPrice) {
		this.kmPrice = kmPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

//	public JSONObject getInfos(){
//		JSONObject infos= new JSONObject();
//		infos.put("brand", brand);
//		infos.put("model", model);
//		infos.put("color", color);
//		infos.put("plateNumber", plateNumber);
//		infos.put("price", price);
//		infos.put("kmPrice", kmPrice);
//		infos.put("type", type);
//		
//		return infos;
//	}
	
	public abstract double getEstimatedPrice(int estimatedKm) ;
}