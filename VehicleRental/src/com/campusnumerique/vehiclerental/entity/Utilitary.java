package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

public class Utilitary extends Vehicule{

	private int volume;
	
	public Utilitary() {
		super();
	}
		
	public Utilitary(int id, String brand, String model, String color, String plateNumber, double price, double kmPrice,
			String type, int volume) {
		super(id, brand, model, color, plateNumber, price, kmPrice, type);
		// TODO Auto-generated constructor stub
		this.setVolume(volume);
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public double getEstimatedPrice(int estimatedKm) {
		double estKm = (double) estimatedKm;
		double estimatedPrice = (double) (this.getVolume() * 0.05 * this.getKmPrice() * estKm + this.getPrice());
		return estimatedPrice;
	}


}