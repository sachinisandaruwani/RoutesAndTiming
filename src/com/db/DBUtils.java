package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Routes;

public class DBUtils {
	
	private static final String url = "jdbc:mysql://localhost:3306/oop";
    private static final String userName = "root";
    private static final String password = "dAra6111926$";
    
    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        return connection;
    }
    
    public static int insertBooking(Routes b) {
    	
    	Connection con;
		String sql = "insert into routes(startLocation, destination, bookingDate, bookingTime, vehicleId, vehicleType) values(?, ?, ?, ?, ?, ?)";
		int status = 0;
		
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, b.getStart());
			ps.setString(2, b.getDestination());
			ps.setString(3, b.getDate());
			ps.setString(4, b.getTime());
			ps.setString(5, b.getVehicleID());
			ps.setString(6, b.getVehicleType());
			
			status = ps.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
    	
    }
    
    public static List<Routes> bookingList() {
    	
    	Connection con;
    	String sql = "select * from routes";
    	List<Routes> booking = new ArrayList<Routes>();
    	
    	try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Routes b = new Routes();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setStart(rs.getString("startLocation"));
				b.setDestination(rs.getString("destination"));
				b.setDate(rs.getString("bookingDate"));
				b.setTime(rs.getString("bookingTime"));
				b.setVehicleID(rs.getString("vehicleId"));
				b.setVehicleType(rs.getString("vehicleType"));
				booking.add(b);
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return booking;
    	
    }
    
    public static Routes getBooking(int id) {
    	
    	Routes booking = null;
    	
    	Connection con;
    	String sql = "select * from routes where id=?";
    	
    	try {
    		con = getConnection();
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			booking = new Routes();
    			booking.setId(rs.getInt("id"));
    			booking.setStart(rs.getString("startLocation"));
    			booking.setDestination(rs.getString("destination"));
    			booking.setDate(rs.getString("bookingDate"));
    			booking.setTime(rs.getString("bookingTime"));
    			booking.setVehicleID(rs.getString("vehicleId"));
    			booking.setVehicleType(rs.getString("vehicleType"));
    		}
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return booking;
    	
    }
    
    public static void updateBooking(Routes b) {
    	
    	Connection con;
    	con = getConnection();
    	String sql = "update routes "
    			+ "set bookingDate=?, bookingTime=?, vehicleId=?, vehicleType=? "
    			+ "where id=?";
    	
    	try {
    		con = getConnection();
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, b.getDate());
    		ps.setString(2, b.getTime());
    		ps.setString(3, b.getVehicleID());
    		ps.setString(4, b.getVehicleType());
    		ps.setInt(5, b.getId());
    		
    		ps.executeUpdate();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    }
    
    public static void deleteBooking(int id) {
		Connection con;
		String sql = "delete from routes where id=?";
		
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
