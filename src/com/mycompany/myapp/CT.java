package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CT extends Command{
	private GameWorld gw;
	
	public CT(GameWorld gw){
		super("Tick");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.tick();
	}
}
