package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CAsteroid extends Command{
	private GameWorld gw;
	
	public CAsteroid(GameWorld gw){
		super("Create Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.createAs();
	}
}
