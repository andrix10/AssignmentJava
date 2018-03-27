package com.mycompany.myapp;
import java.util.Random;
import java.lang.Math;

public class Location {
	private double x,y;
	private double maxX = 1024;
	private double maxY = 768;
	
	public Location(){
		this.x = maxX/2;
		this.y = maxY/2;
	}
	
	public Location(double xx, double yy){
		set(xx,yy);
	}
	
	public Location(Location loc){
		set(loc.x, loc.y);
	}
	
	public void setWidth(double x) {
		maxX = x;
	}
	
	public void setHeight(double x) {
		maxY = x;
	}
	
	public double getWidth() {
		return maxX;
	}
	
	public double getHeight() {
		return maxY;
	}
	
	public void ran() {
		Random rand = new Random();
		x = rand.nextInt((int)maxX) + 0;
		y = rand.nextInt((int)maxY) + 0;
	}
	
	public void reset() {
		set(maxX/2, maxY/2);
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
		if(xx>maxX) x = maxX;
		else if(xx<0) x = 0;
		else x = xx;
		
		if(yy>maxY) y = maxY;
		else if(yy<0) y = 0;
		else y = yy;
	}

}