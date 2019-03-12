package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CW extends Command{
	private GameWorld gw;
	
	public CW(GameWorld gw){
		super("Destroy Saucer and As");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.destroyAs();
		gw.destroySaucer();
	}
}
