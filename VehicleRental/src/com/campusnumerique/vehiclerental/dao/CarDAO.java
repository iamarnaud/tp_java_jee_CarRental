package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;

public class CarDAO extends DAO<Car>{

	@Override
	public boolean create(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Car find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAll() throws SQLException{
		ArrayList<Car> cars = new ArrayList<Car>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car");
		while(result.next()){ 
			Car car = new Car(result.getInt("id"), result.getString("brand"), result.getString("model"), result.getString("color"), result.getString("plateNumber"), result.getDouble("price"), result.getDouble("kmPrice"), result.getInt("horsePower"));    
			cars.add(car);
		}
		return cars;
	}
	
	public List<Car> findSmall() throws SQLException{
		ArrayList<Car> cars = new ArrayList<Car>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE horsePower < 8");
		while(result.next()){ 
			Car car = new Car(result.getInt("id"), result.getString("brand"), result.getString("model"), result.getString("color"), result.getString("plateNumber"), result.getDouble("price"), result.getDouble("kmPrice"), result.getInt("horsePower"));    
			cars.add(car);
		}
		return cars;
	}
	
	public List<Car> findMedium() throws SQLException{
		ArrayList<Car> cars = new ArrayList<Car>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE horsePower < 14");
		while(result.next()){ 
			Car car = new Car(result.getInt("id"), result.getString("brand"), result.getString("model"), result.getString("color"), result.getString("plateNumber"), result.getDouble("price"), result.getDouble("kmPrice"), result.getInt("horsePower"));    
			cars.add(car);
		}
		return cars;
	}

}
