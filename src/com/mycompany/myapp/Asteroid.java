package com.mycompany.myapp;

public class Asteroid extends Moveable{
	private int size;
	public Asteroid() {
		rand();
		size = ran(6, 30);
		setColor(2);
	}
	
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = "size: " + size + " ";
		return parentDesc + myDesc;
	}
}
