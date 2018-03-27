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
		super(new GridLayout(1,2));
		//super.add(new Label("Not updated"));
		//super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		super.add(new Label("Not updated"));
		super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		this.gw = gw;

	}
	
	public double getH() {
		return (double)super.getHeight();
	}
	
	public double getW() {
		return (double)super.getWidth();
	}
	
	public void update(Observable o,Object arg) {
		super.removeAll();
		super.add(new Label("Updated"));
		super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		super.repaint();
	}
}
