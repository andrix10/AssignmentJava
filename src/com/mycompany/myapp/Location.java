package com.mycompany.myapp;
import java.util.Random;
import java.lang.Math;

public class Location {
	private double x,y;
	private double maxX = 1024;
	private double maxY = 768;
	
	public Location(){
		this.x = 512;
		this.y = 384;
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
		set(512, 384);
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
		set(xx,y);
		round();
	}
	
	public void setY(double yy) {
		set(x,yy);
		round();
	}
	
	public void setX(Location loc) {
		this.x = loc.x;
		set(loc.x,y);
		round();
	}
	
	public void setY(Location loc) {
		set(x,loc.y);
		round();
	}
	
	public void addY(Location loc) {
		this.y += loc.y;
		round();
	}
	
	public void addX(Location loc) {
		this.x += loc.x;
		round();
	}
	
	public void add(Location loc) {
		addX(loc);
		addY(loc);
		round();
	}
	
	public void add(double xx, double yy) {
		addX(xx);
		addY(yy);
		round();
	}
	
	public void addX(double x) {
		this.x += x;
		round();
	}
	
	public void addY(double y) {
		this.y += y;
		round();
	}
	
	public void set(double xx, double yy) {
		if(xx>1024) x = 1024;
		else if(xx<0) x = 0;
		else x = xx;
		
		if(yy>768) y = 768;
		else if(yy<0) y = 0;
		else y = yy;
	}

}