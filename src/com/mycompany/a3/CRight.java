package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CRight extends Command{
	private GameWorld gw;
	
	public CRight(GameWorld gw){
		super("Turn Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.turnS(true);
	}
}
