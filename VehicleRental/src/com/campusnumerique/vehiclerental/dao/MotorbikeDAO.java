package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Motorbike;

public class MotorbikeDAO extends DAO<Motorbike>{

	@Override
	public boolean create(Motorbike obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Motorbike obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Motorbike obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Motorbike find(int id) throws SQLException {
		Motorbike motorbike = new Motorbike();  
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE type = 'motorbike' AND id = " + id);
		if(result.first())
			motorbike = new Motorbike(
					result.getInt("id"), 
					result.getString("brand"), 
					result.getString("model"), 
					result.getString("color"), 
					result.getString("plateNumber"), 
					result.getDouble("price"), 
					result.getDouble("kmPrice"), 
					result.getString("type"), 
					result.getInt("cylinder"));         
		
		return motorbike;
	}

	@Override
	public List<Motorbike> findAll() throws SQLException{
		ArrayList<Motorbike> motorbikes = new ArrayList<Motorbike>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE type='motorbike'");
		while(result.next()){ 
			Motorbike motorbike = new Motorbike(
					result.getInt("id"), 
					result.getString("brand"), 
					result.getString("model"), 
					result.getString("color"), 
					result.getString("plateNumber"), 
					result.getDouble("price"), 
					result.getDouble("kmPrice"), 
					result.getString("type"), 
					result.getInt("cylinder"));    
			motorbikes.add(motorbike);
		}
		return motorbikes;
	}
	
	public List<Motorbike> findByCylinder(int 
			Cylinder) throws SQLException{
		ArrayList<Motorbike> motorbikes = new ArrayList<Motorbike>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE type = 'motorbike' AND cylinder < " + Cylinder);
		while(result.next()){ 
			Motorbike motorbike = new Motorbike(
					result.getInt("id"), 
					result.getString("brand"), 
					result.getString("model"), 
					result.getString("color"), 
					result.getString("plateNumber"), 
					result.getDouble("price"), 
					result.getDouble("kmPrice"), 
					result.getString("type"), 
					result.getInt("cylinder"));    
			motorbikes.add(motorbike);
		}
		return motorbikes;
	}
	

}
