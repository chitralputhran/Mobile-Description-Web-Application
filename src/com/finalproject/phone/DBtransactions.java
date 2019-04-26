package com.finalproject.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class DBtransactions {

	private DataSource dataSource;

	public DBtransactions(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	
	public List<Device> getDevices() throws Exception {
		
		List<Device> devices = new ArrayList<>();
		
		Connection myConn = null;
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
		myConn = dataSource.getConnection();
			
			
			String sql = "select id, DeviceName, Brand, technology, gprs, edge from devices";
			
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				
				int id = myRs.getInt("id");				
				String deviceName = myRs.getString("DeviceName");
				String brand= myRs.getString("Brand");
				String technology= myRs.getString("technology"); 
				String gprs= myRs.getString("gprs");
				String edge= myRs.getString("edge");

				Device newDevice = new Device(id, deviceName, brand,technology,gprs,  edge);
				
				devices.add(newDevice);				
			}
			
			return devices;		
		}
		finally {
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addDevice(Device newDevice) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into devices "
					   + "(id, DeviceName, Brand, technology, gprs, edge ) "
					   + "values (?, ?, ?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			
			myStmt.setInt(1, newDevice.getId());
			myStmt.setString(2, newDevice.getDeviceName());
			myStmt.setString(3, newDevice.getBrand());
			myStmt.setString(4, newDevice.getTechnology());
			myStmt.setString(5, newDevice.getGprs());
			myStmt.setString(6, newDevice.getEdge());

					
			myStmt.execute();
		}
		finally {
			close(myConn, myStmt, null);
		}
	}

	public Device getDevice(String theDeviceId) throws Exception {

		Device newDevice = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int deviceId;
		
		try {
		
			deviceId = Integer.parseInt(theDeviceId);
			
		
			myConn = dataSource.getConnection();
			
			
			String sql = "select DeviceName, Brand, technology, gprs, edge from devices where id = ?";
			
			
			myStmt = myConn.prepareStatement(sql);
			
			
			myStmt.setInt(1, deviceId);
			
		
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String deviceName = myRs.getString("DeviceName");
				String brand= myRs.getString("Brand");
				String technology= myRs.getString("technology"); 
				String gprs= myRs.getString("gprs");
				String edge= myRs.getString("edge");

				newDevice = new Device(deviceId, deviceName, brand, technology, gprs, edge );
			}
			else {
				throw new Exception("Could not find Device with Id: " + theDeviceId);
			}				
			
			return newDevice;
		}
		finally {

			close(myConn, myStmt, myRs);
		}
	}

	public void updateDevice(Device newDevice) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
		
			myConn = dataSource.getConnection();
			
			String sql = "update devices "
						+ "set DeviceName = ?,  Brand = ? ,technology = ? ,gprs = ? ,edge = ? "
						+ "where id = ?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, newDevice.getDeviceName());
			myStmt.setString(2, newDevice.getBrand());
			myStmt.setString(3, newDevice.getTechnology());
			myStmt.setString(4, newDevice.getGprs());
			myStmt.setString(5, newDevice.getEdge());
			myStmt.setInt(6, newDevice.getId());
			
		
			myStmt.execute();
		}
		finally {

			close(myConn, myStmt, null);
		}
	}

	public void deleteDevice(String theDeviceId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			int id = Integer.parseInt(theDeviceId);
			

			myConn = dataSource.getConnection();
			
		
			String sql = "delete from devices where id=?";
			
		
			myStmt = myConn.prepareStatement(sql);
			
			
			myStmt.setInt(1, id);
			
			
			myStmt.execute();
		}
		finally {
			
			close(myConn, myStmt, null);
		}	
	}
}
