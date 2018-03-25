package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class CExit extends Command{
	private GameWorld gw;
	
	public CExit(GameWorld gw){
		super("Exit");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(Dialog.show("Quit?","", "OK", "Cancel")) {
			System.exit(0);
		}
	}
}
