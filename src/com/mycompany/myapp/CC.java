package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class CC extends Command{
	private GameWorld gw;
	
	public CC(GameWorld gw){
		super("Destroy Ship with Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.destroyShip();
		gw.destroyAs();
		if(gw.life(false)==0) {
			if(!Dialog.show("Restart?", "", "OK", "Cancel")) {
				System.exit(0);
			}
			else gw.init();
		}
	}
}
