package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class CH extends Command{
	private GameWorld gw;
	
	public CH(GameWorld gw){
		super("Destroy Ship with Saucer");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.destroyShip();
		gw.destroySaucer();
		if(gw.life(false)==0) {
			if(!Dialog.show("Restart?", "", "OK", "Cancel")) {
				System.exit(0);
			}
		}	
	}
}
