package com.bean;

public class Routes {
	
	private int id;
	private String start;
	private String destination;
	private String date;
	private String time;
	private String vehicleID;
	private String vehicleType;
	
	public Routes() {
		
	}

	public Routes(int id, String start, String destination, String date, String time, String vehicleID, String vehicleType) {
		this.id = id;
		this.start = start;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.vehicleID = vehicleID;
		this.vehicleType = vehicleType;
	}

	public Routes(String start, String destination, String date, String time, String vehicleID, String vehicleType) {
		this.start = start;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.vehicleID = vehicleID;
		this.vehicleType = vehicleType;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	@Override
	public String toString() {
		return "Routes [id="+ id + ", start=" + start + ", destination=" + destination + ", date=" + date + ", time="
				+ time + ", vehicleID=" + vehicleID + ", vehicleType=" + vehicleType + "]";
	}

}
