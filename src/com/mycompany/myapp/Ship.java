package com.mycompany.myapp;

public class Ship extends Moveable implements Steer{
	private int missle;
	private static Ship instance = null;
	
	private Ship() {
		super();
		getLocation().reset();
		this.missle = 12;
		setColor(0);
	}
	
	public static Ship getInst() {
		if(instance == null) {
			instance = new Ship();
		}
		
		return instance;
	}
	
	public void steerR() {
		setDir((getDirection()+15));
	}
	
	public void steerL() {
		setDir((getDirection()-15));
	}
	
	public void fire() {
		if (missle > 0)
			this.missle -= 1;
	}
	
	public void jump() {
		getLocation().reset();
	}
	
	public void refill() {
		missle = 12;
	}
	
	public int getMissle() {
		return missle;
	}
	
	@Override
	public String toString() {
		String parentDesc = "Ship: " + super.toString();
		String myDesc = "missles: " + getMissle() + " ";
		return parentDesc + myDesc;
	}
}
