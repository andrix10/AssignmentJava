package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CUp extends Command{
	private GameWorld gw;
	
	public CUp(GameWorld gw){
		super("Increase Speed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.increaseSS();
	}
}
