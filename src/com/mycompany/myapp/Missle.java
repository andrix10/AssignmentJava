package com.mycompany.myapp;

public class Missle extends Moveable{
	private int fuel;
	
	public Missle(double a, double b, int c) {
		fuel = 10;
		this.setLoc(a, b);
		this.setSpDir(c, this.getY());
	}
	
	public void decMis() {
		fuel =- 1;
	}
}
