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
	
	public Asteroid(Location loc, int x) {
		setBounds(loc);
		rand();
		size = x;
		setColor(1);
	}
	
	public void randSplit() {
		rand();
	}
	
	public void changeColor(int a) {
		setColor(a);
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int x) {
		size = x;
	}
	@Override
	public String toString() {
		String parentDesc = "Asteroid: " + super.toString();
		String myDesc = "size: " + size + " ";
		return parentDesc + myDesc;
	}
}
