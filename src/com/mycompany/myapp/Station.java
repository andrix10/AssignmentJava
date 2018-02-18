package com.mycompany.myapp;

public class Station extends Fixed {
	private int rate;
	private boolean light;
	public Station() {
		rate = ran(0,5);
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
	
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = "rate: " + rate + " ";
		return parentDesc + myDesc;
	}
}
