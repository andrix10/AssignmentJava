package com.mycompany.myapp;
import com.codename1.ui.Form;

public class Game extends Form {
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		System.out.print("play");
		play();
	}
	
	private void play() {
		
	}
}
