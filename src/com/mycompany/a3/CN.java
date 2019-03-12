package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CN extends Command{
	private GameWorld gw;
	
	public CN(GameWorld gw){
		super("Refill Ship");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.reffilS();
	}
}
