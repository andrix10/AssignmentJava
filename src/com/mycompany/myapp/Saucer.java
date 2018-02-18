package com.mycompany.myapp;
import java.util.Random;

public class Saucer extends Moveable {
	private boolean size;
	public Saucer() {
		super();
		setColor(3);
		int ran = ran(1,20);
		if(ran >10) {
			size = true;
		}else {
			size = false;
		}
	}
	
}
