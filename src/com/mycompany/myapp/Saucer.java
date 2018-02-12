package com.mycompany.myapp;
import java.util.Random;

public class Saucer extends Moveable {
	private boolean size;
	public Saucer() {
		this.Movable();
		int ran = rand.nextInt(20) + 0;
		if(ran >10) {
			size = true;
		}else {
			size = false;
		}
	}
	
}
