package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CDown extends Command{
	private GameWorld gw;
	
	public CDown(GameWorld gw){
		super("Decrease Speed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.decreaseSS();
	}
}
