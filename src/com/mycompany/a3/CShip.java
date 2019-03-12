package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CShip extends Command{
	private GameWorld gw;
	
	public CShip(GameWorld gw){
		super("Create Ship");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.createShip();
	}
}
