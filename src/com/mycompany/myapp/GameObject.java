package com.mycompany.myapp;

public abstract class GameObject {
	private Location location;
	private int color;
	
	public GameObject() {
		location.reset();
	}
	
	public GameObject(double x, double y) {
		location.set(x,y);
		
	}
	
	public GameObject(Location loc) {
		location.setX(loc);
		location.setY(loc);
	}
	
	public void setLoc(Location loc) {
		location.set(loc.getX(), loc.getY());
	}
	
	public Location getLocation() {
		return location;
	}
	
	
	public void setColor() {
		
	}
	
	public void getCorlor() {
		
	}
	
}
