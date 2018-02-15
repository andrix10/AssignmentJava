package com.mycompany.myapp;

public class Ship extends Moveable implements Steer{
	private int missle;
	
	public Ship() {
		super();
		getLocation().reset();
		this.missle = 12;
	}
	
	public void steer(boolean st) {
		if(st) {
			setDir(getDirection()-90);
		}
		else{
			setDir(getDirection()+90);
		}
	}
	
	public void fire() {
		this.missle =- 1;
	}
	
	public void tooString() {
		
	}
}
