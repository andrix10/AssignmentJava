package com.mycompany.myapp;
import java.lang.Math;

public abstract class Moveable extends GameObject implements IMoveable{
	private int speed, direction;
	
	public Moveable() {
		speed=0;
		direction = 0;
	}
	
	public void rand() {
		speed = ran(0,10);
		direction = ran(0,359);
		getLocation().ran();
	}
	
	public void setSpeed(int a) {
		if (a >=0) speed = a;
	}
	
	public void setDir(int b) {
		direction = b;
	}

	public void move() {
		double x, y;
		double rad = Math.toRadians(90-direction);
		x = Math.cos(rad)*speed;
		y = Math.sin(rad)*speed;
		System.out.println(" "+x +" "+y+ " ");

		Location l = new Location(x,y);
		getLocation().add(l);
		getLocation().round();
		
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDirection() {
		return direction;
	}
	
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = "speed: " + getSpeed() + " " + "direction " + getDirection() + " ";
		return parentDesc + myDesc;
	}
	
}
