package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CSave extends Command{
	private GameWorld gw;
	
	public CSave(GameWorld gw){
		super("Saving");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Saving...");
	}
}
