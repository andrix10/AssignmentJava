package com.mycompany.myapp;

public class Missle extends Moveable{
	private int fuel;
	
	public Missle(Ship s) {
		setLoc(s.getLocation());
		setSpeed(s.getSpeed()*2);
		fuel = 10;
	}
	
	public void dec() {
		fuel =- 1;
	}
}
