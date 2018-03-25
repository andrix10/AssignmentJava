package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CAbout extends Command{
	private GameWorld gw;
	
	public CAbout(GameWorld gw){
		super("About");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		System.out.println("The best game ever");
	}
}
