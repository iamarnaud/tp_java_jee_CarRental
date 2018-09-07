package com.campusnumerique.vehiclerental.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.campusnumerique.vehiclerental.bean.ReservationBean;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
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
		
		try {

			PreparedStatement ps = this.connection.prepareStatement("DELETE FROM reservation WHERE carId = ? AND clientId = ? AND startDate = ? AND endDate = ?");
			
			Date startDate = new Date(obj.getStartDate().getTime());
			Date endDate = new Date(obj.getEndDate().getTime());

			ps.setInt(1, obj.getCarId());
			ps.setInt(2, obj.getClientId());
			ps.setDate(3, startDate);
			ps.setDate(4, endDate);
//			System.out.println(ps);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		return true;
	}

	@Override
	public boolean update(Reservation obj) {
		try {

			PreparedStatement ps = this.connection.prepareStatement("UPDATE reservation SET carId = ?, clientId = ?, startDate = ?, endDate = ?, estimatedKm = ?, realKm = ?, price = ?, discounted = ? WHERE carId = ? AND clientId = ? AND startDate = ? AND endDate = ?");
			
			Date startDate = new Date(obj.getStartDate().getTime());
			Date endDate = new Date(obj.getEndDate().getTime());

			ps.setInt(1, obj.getCarId());
			ps.setInt(2, obj.getClientId());
			ps.setDate(3, startDate);
			ps.setDate(4, endDate);
			ps.setInt(5, obj.getEstimatedKm());
			ps.setInt(6, obj.getRealKm());
			ps.setDouble(7, obj.getPrice());
			ps.setBoolean(8, obj.isDiscounted());
			ps.setInt(9, obj.getCarId());
			ps.setInt(10, obj.getClientId());
			ps.setDate(11, startDate);
			ps.setDate(12, endDate);
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		return true;
	}

	@Override
	public Reservation find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ReservationBean> findClientResas(int id) throws SQLException {
		
		ArrayList<ReservationBean> resas = new ArrayList<ReservationBean>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM reservation INNER JOIN car ON reservation.carId = car.id "
				  			+ "INNER JOIN client ON reservation.clientId = client.id WHERE clientId = " + id);
		while(result.next()){ 
			Reservation resa = new Reservation(id, result.getInt("reservation.carId"), result.getDate("reservation.startDate"), result.getDate("reservation.endDate"), result.getInt("reservation.estimatedKm"), result.getInt("reservation.realKm"), result.getDouble("reservation.price"), result.getBoolean("discounted"));    
			Car car = new Car(
					result.getInt("id"), 
					result.getString("brand"), 
					result.getString("model"), 
					result.getString("color"), 
					result.getString("plateNumber"), 
					result.getDouble("price"), 
					result.getDouble("kmPrice"), 
					result.getString("type"), 
					result.getInt("horsePower"));
			Client client = new Client(result.getInt("client.id"), result.getString("client.login"), result.getString("client.firstName"), result.getString("client.lastName"), result.getString("client.mail"), result.getDate("client.dob"), result.getDate("client.licenceDate"), result.getString("client.licenceNumber"), result.getBoolean("agent"));
			ReservationBean resaBean = new ReservationBean(resa, car, client);
			resas.add(resaBean);
		}
		return resas;
	}
	
	public List<ReservationBean> findAllResas() throws SQLException {
		
		ArrayList<ReservationBean> resas = new ArrayList<ReservationBean>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM reservation INNER JOIN car ON reservation.carId = car.id "
				  			+ "INNER JOIN client ON reservation.clientId = client.id");
		while(result.next()){ 
			Reservation resa = new Reservation(result.getInt("reservation.clientId"), result.getInt("reservation.carId"), result.getDate("reservation.startDate"), result.getDate("reservation.endDate"), result.getInt("reservation.estimatedKm"), result.getInt("reservation.realKm"), result.getDouble("reservation.price"), result.getBoolean("discounted"));    
			Car car = new Car(
					result.getInt("id"), 
					result.getString("brand"), 
					result.getString("model"), 
					result.getString("color"), 
					result.getString("plateNumber"), 
					result.getDouble("price"), 
					result.getDouble("kmPrice"), 
					result.getString("type"), 
					result.getInt("horsePower"));
			Client client = new Client(result.getInt("client.id"), result.getString("client.login"), result.getString("client.firstName"), result.getString("client.lastName"), result.getString("client.mail"), result.getDate("client.dob"), result.getDate("client.licenceDate"), result.getString("client.licenceNumber"), result.getBoolean("agent"));
			ReservationBean resaBean = new ReservationBean(resa, car, client);
			resas.add(resaBean);
		}
		return resas;
	}
	


	@Override
	public List<Reservation> findAll() throws SQLException {
		ArrayList<Reservation> resas = new ArrayList<Reservation>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM reservation");
		while(result.next()){ 
			Reservation resa = new Reservation(result.getInt("clientId"), result.getInt("carId"), result.getDate("startDate"), result.getDate("endDate"), result.getInt("estimatedKm"), result.getInt("realKm"), result.getInt("price"), result.getBoolean("discounted"));    
			resas.add(resa);
		}
		return resas;
	}
	
	public List<Reservation> findByClientId(int clientId) throws SQLException {
		ArrayList<Reservation> resas = new ArrayList<Reservation>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM reservation WHERE clientId = "+clientId);
		while(result.next()){ 
			Reservation resa = new Reservation(result.getInt("clientId"), result.getInt("carId"), result.getDate("startDate"), result.getDate("endDate"), result.getInt("estimatedKm"), result.getInt("realKm"), result.getInt("price"), result.getBoolean("discounted"));    
			resas.add(resa);
		}
		return resas;
	}
	
	public List<Reservation> findByCarId(int carId) throws SQLException {
		ArrayList<Reservation> resacar = new ArrayList<Reservation>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		    ).executeQuery("SELECT * FROM reservation WHERE carId = " + carId);
		while(result.next()){
			Reservation resa = new Reservation(result.getInt("clientId"), result.getInt("carId"), result.getDate("startDate"), result.getDate("endDate"), result.getInt("estimatedKm"), result.getInt("realKm"), result.getInt("price"), result.getBoolean("discounted"));
			resacar.add(resa);
		}
		
		return resacar;
	}


}
