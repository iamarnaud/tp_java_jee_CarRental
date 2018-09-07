package com.campusnumerique.vehiclerental.entity;

import java.util.Date;

public class Reservation {

	private int clientId;
	private int carId;
	private Date startDate;
	private Date endDate;
	private int estimatedKm;
	private int realKm;
	private double price;
	private boolean discounted = false;
	
	
	public Reservation() {
		setCarId(1);
		setRealKm(0);
		setPrice(0);
	}
	
	public Reservation(int clientId, int carId, Date startDate, Date endDate, int estimatedKm, int realKm, double price, boolean discounted) {
		super();
		this.clientId = clientId;
		this.carId = carId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.estimatedKm = estimatedKm;
		this.realKm = realKm;
		this.price = price;
		setDiscounted(discounted);
	}
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getEstimatedKm() {
		return estimatedKm;
	}
	public void setEstimatedKm(int estimatedKm) {
		this.estimatedKm = estimatedKm;
	}
	public int getRealKm() {
		return realKm;
	}
	public void setRealKm(int realKm) {
		this.realKm = realKm;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDiscounted() {
		return discounted;
	}

	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}
	
	
	
	
}
