package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cat;

public class CatDao {
	
	private Connection connection;
	private final String GET_CATS_QUERY = "SELECT * FROM cats";
	private final String GET_CAT_BY_ID_QUERY = "SELECT * FROM cats WHERE cat_id = ?";
	private final String CREATE_NEW_CAT_QUERY = "INSERT INTO cats(cat_name) VALUES(?)";
	private final String DELETE_CAT_BY_ID_QUERY = "DELETE FROM cats WHERE cat_id = ?";
	
	
	
	public CatDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Cat> getCats() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_CATS_QUERY).executeQuery();
		List<Cat> cats = new ArrayList<Cat>();
		
		while (rs.next()) {
			cats.add(populateCat(rs.getInt(1), rs.getString(2)));
		}
		
		return cats;
		
	}
	
	public Cat getCatById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CAT_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateCat(rs.getInt(1), rs.getString(2));
	}
	
	public void createNewCat(String catName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CAT_QUERY);
		ps.setString(1, catName);
		ps.executeUpdate();
		
	} 
	
	public void deleteCatById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CAT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Cat populateCat(int id, String name) {
		return new Cat (id, name);
	}
	
	

}
