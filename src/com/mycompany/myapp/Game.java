package com.mycompany.myapp;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;


public class Game extends Form {
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	@SuppressWarnings("rawtypes")
	private void play() {
		Label myLabel = new Label("Enter a new Command");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				char command = myTextField.getText().toString().trim().length() != 0 ? myTextField.getText().toString().charAt(0): '1';
				myTextField.clear();
				switch (command) {
					case 'a':
						gw.createAs();
					break;
					case 'b':
						gw.createStation();
					break;
					case 'm':
						gw.print();
					break;
					case 'y':
						gw.createSaucer();
					break;
					case 's':
						gw.createShip();
					break;
					case 'i':
						gw.increaseSS();
					break;
					case 'd':
						gw.decreaseSS();
					break;
					case 'l':
						gw.turnS(false);
					break;
					case 'r':
						gw.turnS(true);
					break;
					case 'f':
						gw.createMissle();
					break;
					case 'j':
						gw.jumpS();
					break;
					case 'n':
						gw.reffilS();
					break;
					case 't':
						gw.tick();
					break;
					case 'p':
						gw.printD();
					break;
					case 'k':
						gw.destroyAs();
						gw.destroyMissle();
					break;
					case 'q':
						System.exit(0);;
					break;
					//add cpde to handle rest commands
				}//switch
			}//actionPerformed
		});//addactionlist
	}//play
	
}
