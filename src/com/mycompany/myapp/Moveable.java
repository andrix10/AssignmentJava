package com.mycompany.myapp;
import java.util.Random;
import java.lang.Math;

public abstract class Moveable extends GameObject{
	private int speed, direction;
	
	public Moveable() {
		speed=0;
		direction = 0;
	}
	
	public void rand() {
		Random rand = new Random();
		speed = rand.nextInt(10) + 0;
		direction = rand.nextInt(359) + 0;
	}
	
	public void setSpeed(int a) {
		speed = a;
	}
	
	public void setDir(int b) {
		direction = b;
	}

	public void move() {
		double x, y;
		double rad = Math.toRadians(90-direction);
		x = Math.cos(rad)*speed;
		y = Math.sin(rad)*speed;

		Location l = new Location(x,y);
		getLocation().add(l);
		
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDirection() {
		return direction;
	}
	
}
