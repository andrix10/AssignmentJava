package com.mycompany.myapp;

public class Asteroid extends Moveable{
	private int size;
	
	public Asteroid() {
		rand();
		size = ran(6, 30);
		setColor(1);
	}
	
	public Asteroid(Location loc) {
		setBounds(loc);
		rand();
		size = ran(6, 30);
		setColor(1);
	}
	
	public void changeColor(int a) {
		setColor(a);
	}
	
	@Override
	public String toString() {
		String parentDesc = "Asteroid: " + super.toString();
		String myDesc = "size: " + size + " ";
		return parentDesc + myDesc;
	}
}
