package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CX extends Command{
	private GameWorld gw;
	
	public CX(GameWorld gw){
		super("Destroy 2 Asteroids");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.destroyAs();
		gw.destroyAs();
	}
}
