package com.mycompany.myapp;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CJump extends Command{
	private GameWorld gw;
	
	public CJump(GameWorld gw){
		super("Jump Ship");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.jumpS();
	}
}
