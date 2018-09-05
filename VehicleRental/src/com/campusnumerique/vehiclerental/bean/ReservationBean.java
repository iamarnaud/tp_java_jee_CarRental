package com.campusnumerique.vehiclerental.bean;

import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Reservation;

public class ReservationBean {

	private Reservation resa;
	private Car car;
	private Client client;
	
	public ReservationBean() {
		this.resa = new Reservation();
		this.car = new Car();
		this.client = new Client();
	}

	public ReservationBean(Reservation resa, Car car, Client client) {
		super();
		this.resa = resa;
		this.car = car;
		this.client = client;
	}

	public Reservation getResa() {
		return resa;
	}

	public void setResa(Reservation resa) {
		this.resa = resa;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
		
}
