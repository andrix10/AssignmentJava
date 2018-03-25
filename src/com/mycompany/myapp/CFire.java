package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CFire extends Command{
	private GameWorld gw;
	
	public CFire(GameWorld gw){
		super("Fire Missle");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.createMissle();
	}
}
