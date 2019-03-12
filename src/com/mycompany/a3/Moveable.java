package com.mycompany.a3;
import java.lang.Math;

public abstract class Moveable extends GameObject implements IMoveable{
	private int speed, direction;
	
	public Moveable() {
		speed=0;
		direction = 0;
	}
	
	public void rand() {
		speed = ran(150,300);
		direction = ran(0,359);
		getLocation().ran();
	}
	
	public void ranSD() {
		speed = ran(150,300);
		direction = ran(0,359);
	}
	
	public void setSpeed(int a) {
		if (a >=0) speed = a;
	}
	
	public void setDir(int b) {
		direction = b;
	}

	public void move(double fps) {
		double x, y;
		double rad = Math.toRadians(90-direction);
		x = Math.cos(rad)*speed*(fps/1000);
		y = Math.sin(rad)*speed*(fps/1000);
//		x = x + x *(fps/1000);
//		y = y + y *(fps/1000);
		//System.out.println(" "+x +" "+y+ " ");
		getLocation().add(x,y);		
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
