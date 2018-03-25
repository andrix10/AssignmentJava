package com.mycompany.myapp;
import java.util.*;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.*;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.events.ActionEvent;
import com.codename1.charts.util.ColorUtil;

public class PointsView extends Container implements Observer{
	private GameWorld gw;
	
	PointsView(){
		super(new GridLayout(1,2));
		String m = gw.printD();
		super.add(new Label(m));
		super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		//System.out.println(m);
		//this.add(BorderLayout.NORTH,topContainer);
	}
	
	PointsView(GameWorld gw){
		super(new GridLayout(1,2));
		//super.add(new Label("Not updated"));
		super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		this.gw = gw;
		String m = this.gw.printD();
		super.add(new Label(m));

	}
	
	public void update(Observable o,Object arg) {
		//setLayout(new BorderLayout());
		super.removeAll();
		String m = new String(gw.printD());
		super.add(new Label(m));
		super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		System.out.println("Updated");
		this.repaint();
	}
}
