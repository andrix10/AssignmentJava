package com.mycompany.a3;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.events.ActionEvent;
import com.codename1.charts.util.ColorUtil;
/*
 * fix location
 * fix center mv thing
 * uml


*/
public class Game extends Form implements Runnable {
	private GameWorld gw;
	private PointsView pv;
	private MapView mv;
	private BGSound bgSound;
	private CheckBox checkSideMenuComp= new CheckBox("Sound");
	
	public Game() {
		gw = new GameWorld();
		pv = new PointsView(gw);
		mv = new MapView(gw);
		gw.init();
		gw.addObserver(pv);
		gw.addObserver(mv);
		bgSound = new BGSound("KISS OF DEATH - Mika Nakashima x Hyde.mp3");
		bgSound.run();
		setLayout(new BorderLayout()); 
		
		this.add(BorderLayout.NORTH,pv);
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		leftContainer.getAllStyles().setFgColor(ColorUtil.BLACK);
		leftContainer.getAllStyles().setBgColor(ColorUtil.BLACK);
		//Container center = new Container(mv);
		//leftContainer.add(new CheckBox("Enable Printing (l)"));
//		if(gw.getLife()==0) {
//			if(!Dialog.show("Restart?", "", "OK", "Cancel")) {
//				System.exit(0);
//			}
//			else gw.init();
//		}
		
		this.add(BorderLayout.CENTER, mv);
		//gw.setHeight((double)this.getInnerHeight());
	
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		//Command sideMenuItemCheck = new Command("Side Menu Item Check ");
		//CheckBox checkSideMenuComp= new CheckBox("Sound");
		checkSideMenuComp.setSelected(true);
		leftContainer.add(checkSideMenuComp);
		checkSideMenuComp.addActionListener(new PlayS(bgSound));
		//set the style of the check box
		 MyButton bShip = new MyButton("Add Ship");
		 MyButton bAsteroid = new MyButton("Add Asteroid");
		 MyButton bSaucer = new MyButton("Add Saucer");
		 MyButton bStation = new MyButton("Add Station");
		 MyButton bFire = new MyButton("Fire Missle");
		 MyButton bN = new MyButton("Refill");
		 MyButton bT = new MyButton("Pause");
		 myToolbar.addCommandToOverflowMenu(new Command("Song: KISS OF DEATH - Mika Nakashima x Hyde"));
//		 MyButton bK = new MyButton("Kill Asteroid 1");
//		 MyButton bE = new MyButton("Destroy Saucer 1");
//		 MyButton bC = new MyButton("Destroy Ship 1");
//		 MyButton bW = new MyButton("Destroy Asteroid 2");
//		 MyButton bH = new MyButton("Destroy Ship 2");
//		 MyButton bX = new MyButton("Destroy 2 As.");
		 this.setFocused(mv);
		 bShip.addActionListener(new CShip(gw));
		 bAsteroid.addActionListener(new CAsteroid(gw));
		 bSaucer.addActionListener(new CSaucer(gw));
		 bStation.addActionListener(new CStation(gw));
		 bFire.addActionListener(new CFire(gw));
		 bN.addActionListener(new CN(gw));
		 bT.addActionListener(new Pause(mv,bT));
//		 bK.addActionListener(new CK(gw));
//		 bE.addActionListener(new CE(gw));
//		 bC.addActionListener(new CC(gw));
//		 bW.addActionListener(new CW(gw));
//		 
//		 bH.addActionListener(new CH(gw));
//		 bX.addActionListener(new CX(gw));
		
//		 this.addKeyListener(-90 , new CFire(gw));
		 this.addKeyListener('f' , new CFire(gw));
		 this.addKeyListener(-91 , new CUp(gw));
		 this.addKeyListener(-92 , new CDown(gw));
		 this.addKeyListener(-93 , new CLeft(gw));
		 this.addKeyListener(-94 , new CRight(gw));
		 this.addKeyListener('j' , new CJump(gw));
		 this.addKeyListener('m' , new CPrint(gw));
		 
		 leftContainer.add(bShip);
		 leftContainer.add(bAsteroid);
		 leftContainer.add(bSaucer);
		 leftContainer.add(bStation);
		 leftContainer.add(bFire);
		 leftContainer.add(bN);
		 leftContainer.add(bT);
//		 leftContainer.add(bT);
//		 leftContainer.add(bK);
//		 leftContainer.add(bE);
//		 leftContainer.add(bC);
//		 leftContainer.add(bW);
//		 leftContainer.add(bH);
//		 leftContainer.add(bX);
		 
		 this.add(BorderLayout.WEST, leftContainer);
		 
		 
		// myToolbar.addCommandToOverflowMenu(overflowMenuItem1);
		 myToolbar.addCommandToSideMenu(new CNew(gw));
		 myToolbar.addCommandToSideMenu(new CSave(gw));
		 myToolbar.addCommandToSideMenu(new CAbout(gw));
		 myToolbar.addCommandToSideMenu(new CExit(gw));

		 myToolbar.setTitle("Asteroid Game");

		 this.setFocused(myToolbar);
		 this.show();
		 gw.setHeight(mv.getH(),getHeight());
		 gw.setWidth(mv.getW(),getWidth());
		 UITimer timer = new UITimer(this);
		 timer.schedule(25, true, this);
		 this.setFocused(mv);
		 this.show();

	}
	
	public void run() {
		if(mv.getSelect() == false) {
			if(checkSideMenuComp.isSelected()) {
				bgSound.play();
				if(gw.getSound() == false)gw.switchS();
			}else {
				if(gw.getSound())gw.switchS();
			}
			//gw.life(false);
			mv.runnings();
			gw.tick();
			if(gw.getLife()==0) {
				System.out.println("stupid lose");
				if(!Dialog.show("You Lose. Restart?", "", "OK", "Cancel")) {
					System.exit(0);
				}
				else{
					int x;
					gw.init();
					gw.setHeight(mv.getH(),getHeight());
					gw.setWidth(mv.getW(),getWidth());
//					x = gw.life(true);
//					x =gw.life(true);
//					x = gw.life(true);
				}
				try{
					//print something here
					Thread.sleep(3000); //sleep for 3 seconds
					//print something else here
					}
					catch(InterruptedException e){    System.out.println("got interrupted!");
					}
			}
//			this.addKeyListener('f' , new CFire(gw));
//			 this.addKeyListener(-91 , new CUp(gw));
//			 this.addKeyListener(-92 , new CDown(gw));
//			 this.addKeyListener(-93 , new CLeft(gw));
//			 this.addKeyListener(-94 , new CRight(gw));
//			 this.addKeyListener('j' , new CJump(gw));
//			 this.addKeyListener('m' , new CPrint(gw));
		}
		else {
			bgSound.pause();
			if(gw.getSound())gw.switchS();
//			this.removeKeyListener(keyCode, listener);
		}
	}
}
