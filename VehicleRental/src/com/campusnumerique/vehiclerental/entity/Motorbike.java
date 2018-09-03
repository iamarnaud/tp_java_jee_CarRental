package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

public class Motorbike extends Vehicule{

	private int cylinder;
	
	public Motorbike() {
		super();
	}
		
	public Motorbike(int id, String brand, String model, String color, String plateNumber, double price, double kmPrice,
			String type, int cylinder) {
		super(id, brand, model, color, plateNumber, price, kmPrice, type);
		// TODO Auto-generated constructor stub
		this.setCylinder(cylinder);
	}
	
	public int getCylinder() {
		return cylinder;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	@Override
	public int getEstimatedPrice(int estimatedKm) {
		int estimatedPrice = (int) (this.getCylinder() * 0.001 * this.getKmPrice() * estimatedKm + this.getPrice());
		return estimatedPrice;
	}


}