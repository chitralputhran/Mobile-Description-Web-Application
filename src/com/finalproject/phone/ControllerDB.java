package com.finalproject.phone;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/ControllerDB")
public class ControllerDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DBtransactions dbtrans;
	
	@Resource(name="jdbc/mobile_phones")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
	
		try {
			dbtrans = new DBtransactions(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			
			switch (theCommand) {
			
			case "LIST":
				listDevices(request, response);
				break;
				
			case "ADD":
				addDevice(request, response);
				break;
				
			case "LOAD":
				loadDevice(request, response);
				break;
				
			case "UPDATE":
				updateDevice(request, response);
				break;
			
			case "DELETE":
				deleteDevice(request, response);
				break;
				
			default:
				listDevices(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteDevice(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		
		String theDeviceId = request.getParameter("deviceId");

		dbtrans.deleteDevice(theDeviceId);
		
	
		listDevices(request, response);
	}

	private void updateDevice(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		
		int id = Integer.parseInt(request.getParameter("deviceId"));
		String deviceName = request.getParameter("deviceName");
		String brand= request.getParameter("brand");
		String technology= request.getParameter("technology"); 
		String gprs= request.getParameter("gprs");
		String edge= request.getParameter("edge");
		

		Device newDevice = new Device(id, deviceName, brand, technology, gprs, edge);
		
		
		dbtrans.updateDevice(newDevice);
		
	
		listDevices(request, response);
		
	}

	private void loadDevice(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		
		String theDeviceId = request.getParameter("deviceId");
		
	
		Device newDevice = dbtrans.getDevice(theDeviceId);
		
		
		request.setAttribute("THE_DEVICE", newDevice);
		
	
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-device-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addDevice(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String deviceName = request.getParameter("deviceName");
		String brand= request.getParameter("brand");
		String technology= request.getParameter("technology"); 
		String gprs= request.getParameter("gprs");
		String edge= request.getParameter("edge");

	
		Device newDevice = new Device( deviceName, brand, technology, gprs, edge);
		
	
		dbtrans.addDevice(newDevice);
				
		
		listDevices(request, response);
	}

	private void listDevices(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

	
		List<Device> devices = dbtrans.getDevices();
		
		
		request.setAttribute("DEVICE_LIST", devices);
				
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-devices.jsp");
		dispatcher.forward(request, response);
	}

}