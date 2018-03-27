package com.mycompany.myapp;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.events.ActionEvent;
import com.codename1.charts.util.ColorUtil;
/*
 * implement jump key
 * fix location
 * fix center mv thing
 * uml


*/
public class Game extends Form {
	private GameWorld gw;
	private PointsView pv;
	private MapView mv;
	
	public Game() {
		gw = new GameWorld();
		pv = new PointsView(gw);
		mv = new MapView(gw);
		gw.init();
		gw.addObserver(pv);
		gw.addObserver(mv);
		setLayout(new BorderLayout()); 
		this.add(BorderLayout.NORTH,pv);
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		leftContainer.getAllStyles().setFgColor(ColorUtil.BLACK);
		leftContainer.getAllStyles().setBgColor(ColorUtil.BLACK);
		this.add(BorderLayout.CENTER, mv);
		gw.setHeight((double)this.getInnerHeight());
		gw.setWidth((double)this.getInnerWidth());
		
		//leftContainer.getAllStyles().setPadding(Component.LEFT, );
		//leftContainer.getAllStyles().setPadding(Component.RIGHT, );
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		
		//Command sideMenuItem1 = new Command("Side Menu Item 1");
		 //myToolbar.addCommandToSideMenu(sideMenuItem1);
		 //add an "empty" item to overflow menu
		 MyButton bShip = new MyButton("Add Ship");
		 MyButton bAsteroid = new MyButton("Add Asteroid");
		 MyButton bSaucer = new MyButton("Add Saucer");
		 MyButton bStation = new MyButton("Add Station");
		 MyButton bFire = new MyButton("Fire Missle");
		 MyButton bN = new MyButton("Refill");
		 MyButton bT = new MyButton("Tick");
		 MyButton bK = new MyButton("Kill Asteroid 1");
		 MyButton bE = new MyButton("Destroy Saucer 1");
		 MyButton bC = new MyButton("Destroy Ship 1");
		 MyButton bW = new MyButton("Destroy Asteroid 2");
		 MyButton bH = new MyButton("Destroy Ship 2");
		 MyButton bX = new MyButton("Destroy 2 As.");

		 bShip.addActionListener(new CShip(gw));
		 bAsteroid.addActionListener(new CAsteroid(gw));
		 bSaucer.addActionListener(new CSaucer(gw));
		 bN.addActionListener(new CN(gw));
		 bT.addActionListener(new CT(gw));
		 bK.addActionListener(new CK(gw));
		 bE.addActionListener(new CE(gw));
		 bC.addActionListener(new CC(gw));
		 bW.addActionListener(new CW(gw));
		 bH.addActionListener(new CH(gw));
		 bX.addActionListener(new CX(gw));
		 
		 this.addKeyListener(-90 , new CFire(gw));
		 this.addKeyListener(-91 , new CUp(gw));
		 this.addKeyListener(-92 , new CDown(gw));
		 this.addKeyListener(-93 , new CLeft(gw));
		 this.addKeyListener(-94 , new CRight(gw));
		 this.addKeyListener('m' , new CPrint(gw));
		 
		 leftContainer.add(bShip);
		 leftContainer.add(bAsteroid);
		 leftContainer.add(bSaucer);
		 leftContainer.add(bStation);
		 leftContainer.add(bFire);
		 leftContainer.add(bN);
		 leftContainer.add(bT);
		 leftContainer.add(bK);
		 leftContainer.add(bE);
		 leftContainer.add(bC);
		 leftContainer.add(bW);
		 leftContainer.add(bH);
		 leftContainer.add(bX);
		 
		 this.add(BorderLayout.WEST, leftContainer);
		 
		 
		// myToolbar.addCommandToOverflowMenu(overflowMenuItem1);
		 myToolbar.addCommandToSideMenu(new CNew(gw));
		 myToolbar.addCommandToSideMenu(new CSave(gw));
		 myToolbar.addCommandToSideMenu(new CAbout(gw));
		 myToolbar.addCommandToSideMenu(new CExit(gw));
		 //add an "empty" item to right side of title bar area
		 //Command titleBarAreaItem1 = new Command("Title Bar Area Item 1");
		 //myToolbar.addCommandToRightBar(titleBarAreaItem1);
		 //add an "empty" item to left side of title bar area
		 //Command titleBarAreaItem2 = new Command("Title Bar Area Item 2");
		 //myToolbar.addCommandToLeftBar(titleBarAreaItem2);
		 //Container centerContainer = new Container();
		 myToolbar.setTitle("Asteroid Game");
		//play();
		 this.setFocused(mv);
		 this.show();
	}
}
