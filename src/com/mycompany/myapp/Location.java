package com.mycompany.myapp;
import java.util.Random;
import java.lang.Math;

public class Location {
	private double x,y;
	private double maxX = 1024;
	private double maxY = 768;
	
	public Location(){
		this.x = 0;
		this.y = 0;
	}
	
	public Location(double xx, double yy){
		set(xx,yy);
	}
	
	public Location(Location loc){
		set(loc.x, loc.y);
	}
	
	public void ran() {
		Random rand = new Random();
		x = rand.nextInt(1024) + 0;
		y = rand.nextInt(768) + 0;
	}
	
	public void reset() {
		set(0, 0);
	}
	
	public double getX() {
		return this.x;
	}
	
	public void round() {
		x = Math.round(x*10.0)/10.0;
		y = Math.round(y*10.0)/10.0;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double xx) {
		this.x = xx;
	}
	
	public void setY(double yy) {
		this.y = yy;
	}
	
	public void setX(Location loc) {
		this.x = loc.x;
	}
	
	public void setY(Location loc) {
		this.y = loc.y;
	}
	
	public void addY(Location loc) {
		this.y += loc.y;
	}
	
	public void addX(Location loc) {
		this.x += loc.x;
	}
	
	public void add(Location loc) {
		this.x += loc.x;
		this.y += loc.y; 
	}
	
	public void addX(double x) {
		this.x += x;
	}
	
	public void addY(double y) {
		this.y = y;
	}
	
	public void set(double xx, double yy) {
		this.x = xx;
		this.y = yy;
	}

}