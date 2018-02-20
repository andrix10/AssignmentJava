package com.mycompany.myapp;

public class Station extends Fixed {
	private int rate;
	private boolean light;
	public Station() {
		rate = ran(0,5);
		setColor(3);
	}
	
	public void resupply(){
		
	}
	
	public void toggle() {
		if(light) light = false;
		else light = true;
	}
	
	public int getBlink() {
		return rate;
	}
	
	public void changeColor(int a) {
		setColor(a);
	}
	
	@Override
	public String toString() {
		String parentDesc = "Station: " + super.toString();
		String myDesc = "rate: " + rate + " ";
		return parentDesc + myDesc;
	}
}
