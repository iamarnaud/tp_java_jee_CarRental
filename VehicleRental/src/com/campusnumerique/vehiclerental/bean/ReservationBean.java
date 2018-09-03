package com.campusnumerique.vehiclerental.bean;

import com.campusnumerique.vehiclerental.entity.Reservation;

public class ReservationBean {

	private Reservation resa;
	
	public ReservationBean() {
		this.resa = new Reservation();
	}
	
	public ReservationBean(Reservation resa) {
		super();
		this.resa = resa;
	}

	public Reservation getResa() {
		return resa;
	}

	public void setResa(Reservation resa) {
		this.resa = resa;
	}
	
		
}
