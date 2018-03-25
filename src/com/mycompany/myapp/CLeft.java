package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CLeft extends Command{
	private GameWorld gw;
	
	public CLeft(GameWorld gw){
		super("Turn Left");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.turnS(false);
	}
}
