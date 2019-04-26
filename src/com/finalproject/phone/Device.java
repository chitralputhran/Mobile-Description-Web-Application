package com.finalproject.phone;

public class Device {
	private int id;
	private String DeviceName;
	private String Brand;
	private String technology; 
	private String gprs; 
	private String edge; 

	public Device(int id, String deviceName, String brand, String technology, String gprs, String edge) {
		super();
		this.id = id;
		DeviceName = deviceName;
		Brand = brand;
		this.technology = technology;
		this.gprs = gprs;
		this.edge = edge;

	}
	public Device(String deviceName, String brand, String technology, String gprs, String edge) {
		super();
		DeviceName = deviceName;
		Brand = brand;
		this.technology = technology;
		this.gprs = gprs;
		this.edge = edge;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceName() {
		return DeviceName;
	}
	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getGprs() {
		return gprs;
	}
	public void setGprs(String gprs) {
		this.gprs = gprs;
	}
	public String getEdge() {
		return edge;
	}
	public void setEdge(String edge) {
		this.edge = edge;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", DeviceName=" + DeviceName + ", Brand=" + Brand + ", technology="
				+ technology + ", gprs=" + gprs + ", edge=" + edge + "]";
	}
	
	
	
}
