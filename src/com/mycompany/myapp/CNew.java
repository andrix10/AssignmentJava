package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CNew extends Command{
	private GameWorld gw;
	
	public CNew(GameWorld gw){
		super("New");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.createShip();
	}
}
