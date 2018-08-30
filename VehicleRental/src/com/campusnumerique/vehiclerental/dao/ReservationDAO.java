package com.campusnumerique.vehiclerental.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.campusnumerique.vehiclerental.entity.Reservation;

public class ReservationDAO  extends DAO<Reservation> {

	@Override
	public boolean create(Reservation resa) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = this.connection.prepareStatement("INSERT INTO reservation (clientId, carId, startDate, endDate, estimatedKm, realKm, price) VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		Date startDate = new Date(resa.getStartDate().getTime() +86400000);
		Date endDate = new Date(resa.getEndDate().getTime() +86400000);
		
		ps.setInt(1, resa.getClientId());
		ps.setInt(2, resa.getCarId());
		ps.setDate(3, startDate);
		ps.setDate(4, endDate);
		ps.setInt(5, resa.getEstimatedKm());
		ps.setInt(6, resa.getRealKm());
		ps.setDouble(7, resa.getPrice());
		
		ps.executeUpdate();
		ps.close();				
		
		return true;
	}

	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
