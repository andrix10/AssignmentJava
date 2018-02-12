package com.mycompany.myapp;
import java.util.Random;

public class Moveable extends GameObject{
	private int speed, direction;
	
	public Movable() {
		Random rand = new Random();
		speed = rand.nextInt(10) + 0;
		direction = rand.nextI(359) + 0;
	}
	
	public Movable(int a, int b) {
		speed = a;
		direction = b;
	}
	
	public void setSpDir(int a, int b) {
		speed = a;
		direction = b;
	}

	public void move() {
		double x, y;
		double rad = Math.toRadians(90-direction);
		x = Math.cos(rad)*speed;
		y = Math.sin(rad)*speed;
		
		
		this.setLoc(this.getX()+x,this.getY()+y);
	}
	
	
}
