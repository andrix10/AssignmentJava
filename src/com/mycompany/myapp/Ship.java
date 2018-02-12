package com.mycompany.myapp;

public class Ship extends Moveable{
	private int missle;
	
	public Ship() {
		this.setLoc(512, 384);
		this.setSpDir(0, 0);
		missle = 12;
	}
	
	public void fire() {
		missle =- 1;
	}
}
