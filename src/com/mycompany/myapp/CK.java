package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CK extends Command{
	private GameWorld gw;
	
	public CK(GameWorld gw){
		super("Destroy Asteroid and Score");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.destroyAs();
		gw.destroyMissle();
		gw.score(true);
	}
}
