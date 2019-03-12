package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Pause extends Command{
	private MapView m;
	private boolean s;
	private MyButton b;
	
	Pause(){
		super("Pause");
	}
	
	Pause(MapView mv, MyButton button){
		super("Pause");
		m = mv;
		b = button;
		//mv.selected();
		
	}
	
	public void actionPerformed(ActionEvent ev) {
		m.selected();
		if(!m.getSelect()) {
			b.changeName("Pause");
		}
		else {
			b.changeName("Resume");
		}
	}
	
}
