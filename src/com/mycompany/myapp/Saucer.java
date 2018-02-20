package com.mycompany.myapp;
import java.util.Random;

public class Saucer extends Moveable {
	private boolean size;
	public Saucer() {
		super();
		rand();
		setColor(2);
		int ran = ran(1,20);
		if(ran >10) {
			size = true;
		}else {
			size = false;
		}
	}
	
	public boolean getSize() {
		return size;
	}
	
	public void changeColor(int a) {
		setColor(a);
	}
	
	@Override
	public String toString() {
		String s;
		if(getSize()) s = "large";
		else s = "small";
			
		String parentDesc = "Saucer: " + super.toString();
		String myDesc = "size: " + s + " ";
		return parentDesc + myDesc;
	}
}
