package com.mycompany.myapp;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Dialog;


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
						gw.score(true);
					break;
					case 'e':
						gw.destroySaucer();
						gw.destroyMissle();
						gw.score(true);
					break;
					case 'c':
						gw.destroyShip();
						gw.destroyAs();
						if(gw.life(false)==0) {
							if(!Dialog.show("Restart?", "", "OK", "Cancel")) {
								System.exit(0);
							}
							else gw.init();
						}
						
					break;
					case 'w':
						gw.destroyAs();
						gw.destroySaucer();
					break;
					case 'h':
						gw.destroyShip();
						gw.destroySaucer();
						if(gw.life(false)==0) {
							if(!Dialog.show("Restart?", "", "OK", "Cancel")) {
								System.exit(0);
							}
							else gw.init();
						}
					break;
					case 'x':
						gw.destroyAs();
						gw.destroyAs();
					break;
					case 'q':
						if(Dialog.show("Quit?","", "OK", "Cancel")) {
							System.exit(0);
						}
					break;
					default:
						System.out.println("Wrong input...");
					break;
					//add cpde to handle rest commands
				}//switch
			}//actionPerformed
		});//addactionlist
	}//play
	
}
