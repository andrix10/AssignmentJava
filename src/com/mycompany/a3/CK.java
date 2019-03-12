package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CK extends Command{
	private GameWorld gw;
	
	public CK(GameWorld gw){
		super("Destroy Asteroid and Score");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(gw.getSize()<19) {
//			gw.destroyAs();
			gw.destroyMissle();
			gw.score(true);
			return;
		}
		if (gw.getSize()<25) {
//			gw.splitTwo();
			gw.destroyMissle();
			gw.score(true);
			return;
		}
		if (gw.getSize()>24) {
//			gw.splitThree();
			gw.destroyMissle();
			gw.score(true);
			return;
		}
		
	}
}
