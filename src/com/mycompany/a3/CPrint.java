package com.mycompany.a3;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;

public class CPrint extends Command{
	private GameWorld gw;
	CPrint(GameWorld gw){
		super("Print");
		this.gw= gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.print();
	}
}
