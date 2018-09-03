package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

public class Car extends Vehicule{


	private int horsePower;
	
	public Car() {
		super();
	}
		
	public Car(int id, String brand, String model, String color, String plateNumber, double price, double kmPrice,
			String type, int horsePower) {
		super(id, brand, model, color, plateNumber, price, kmPrice, type);
		// TODO Auto-generated constructor stub
		this.setHorsePower(horsePower);
	}

	public int getHorsePower() {
		return horsePower;
	}
	
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	

//	public JSONObject getInfos(){
//		JSONObject infos= new JSONObject();
//		infos.put("brand", brand);
//		infos.put("model", model);
//		infos.put("color", color);
//		infos.put("plateNumber", plateNumber);
//		infos.put("price", price);
//		infos.put("kmPrice", kmPrice);
//		infos.put("horsePower", horsePower);
//		return infos;
//	}
	
	@Override
	public int getEstimatedPrice(int estimatedKm) {
		int estimatedPrice = (int) (this.getPrice() + this.getKmPrice() * estimatedKm);
		return estimatedPrice;
	}


}