package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Utilitary;

public class UtilitaryDAO extends DAO<Utilitary>{

	@Override
	public boolean create(Utilitary obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Utilitary obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilitary obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Utilitary find(int id) throws SQLException {
		Utilitary utilitary = new Utilitary();  
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE type = 'utilitary' AND id =" + id);
		if(result.first())
			utilitary = new Utilitary(
					result.getInt("id"), 
					result.getString("brand"), 
					result.getString("model"), 
					result.getString("color"), 
					result.getString("plateNumber"), 
					result.getDouble("price"), 
					result.getDouble("kmPrice"), 
					result.getString("type"), 
					result.getInt("volume"));         
		
		return utilitary;
	}

	@Override
	public List<Utilitary> findAll() throws SQLException{
		ArrayList<Utilitary> utilitarys = new ArrayList<Utilitary>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE type='utilitary'");
		while(result.next()){ 
			Utilitary utilitary = new Utilitary(
					result.getInt("id"), 
					result.getString("brand"), 
					result.getString("model"), 
					result.getString("color"), 
					result.getString("plateNumber"), 
					result.getDouble("price"), 
					result.getDouble("kmPrice"), 
					result.getString("type"), 
					result.getInt("volume"));    
			utilitarys.add(utilitary);
		}
		return utilitarys;
	}
	
	public List<Utilitary> findByVolume(int volume) throws SQLException{
		ArrayList<Utilitary> utilitarys = new ArrayList<Utilitary>();
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE type='utilitary'AND volume < " + volume);
		while(result.next()){ 
			Utilitary utilitary = new Utilitary(
					result.getInt("id"), 
					result.getString("brand"), 
					result.getString("model"), 
					result.getString("color"), 
					result.getString("plateNumber"), 
					result.getDouble("price"), 
					result.getDouble("kmPrice"), 
					result.getString("type"), 
					result.getInt("volume"));    
			utilitarys.add(utilitary);
		}
		return utilitarys;
	}
	

}
