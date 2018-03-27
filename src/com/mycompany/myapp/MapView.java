package com.mycompany.myapp;
import java.util.*;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	private GameWorld gw;
	
	MapView(){
		super(new GridLayout(1,2));
		super.add(new Label("Not updated"));
		super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		//this.add(BorderLayout.NORTH,topContainer);
	}
	
	MapView(GameWorld gw){
		Container center = new Container();
		center.setLayout(new GridLayout(1,2));
		
		//super.add(new Label("Not updated"));
		//super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		center.add(new Label("Not updated"));
		center.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		this.gw = gw;
		this.add(center);

	}
	
	public double getH() {
		return (double)this.getHeight();
	}
	
	public double getW() {
		return (double)this.getWidth();
	}
	
	public void update(Observable o,Object arg) {
		this.removeAll();
		this.add(new Label("Updated"));
		this.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		this.repaint();
	}
}
