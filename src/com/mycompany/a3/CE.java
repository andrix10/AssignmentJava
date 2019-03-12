package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CE extends Command{
	private GameWorld gw;
	
	public CE(GameWorld gw){
		super("Destroy Saucer Score");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.destroySaucer();
		gw.destroyMissle();
		gw.score(true);
	}
}
