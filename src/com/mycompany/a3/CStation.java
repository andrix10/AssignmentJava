package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CStation extends Command{
	private GameWorld gw;
	
	public CStation(GameWorld gw){
		super("Create Station");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.createStation();
	}
}
