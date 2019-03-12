package com.mycompany.a3;
import java.util.*;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	private GameWorld gw;
	private boolean select = false;
	
	MapView(){
		super(new GridLayout(1,2));
		super.add(new Label("Not updated"));
		super.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		//this.add(BorderLayout.NORTH,topContainer);
		this.repaint();
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
		this.repaint();

	}
	
	
	public double getH() {
		return (double)this.getHeight();
	}
	
	public double getW() {
		return (double)this.getWidth();
	}
	
	public void update(Observable o,Object arg) {
		this.removeAll();
		if(select) {
			
		}
		this.setLayout(new GridLayout(1));
		//this.add(new Label("Updated"));
		this.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		this.repaint();
	}
	
	public void pointerPressed(int x, int y) {
		if(select) {
			x = x - getParent().getAbsoluteX();
			y = y - getParent().getAbsoluteY();
			Point pPtrRelPrnt = new Point(x, y);
			Point pCmpRelPrnt = new Point(getX(), getY());
			System.out.println(x + " " + y);
			Iterator<GameObject> f = gw.getIterator();
			GameObject k;
			while(f.hasNext()){
				k = f.next();
				if(k instanceof ISelectable) {
					if(((ISelectable) k).contains(pPtrRelPrnt, pCmpRelPrnt)) {
						((ISelectable) k).setSelected(true);
					}else {
						((ISelectable) k).setSelected(false);
					}
				}
				repaint();
			}
//		for (int i = 0; i < worldShapes.size(); i++) {
//		    if (worldShapes.elementAt(i).contains(pPtrRelPrnt, pCmpRelPrnt))
//				worldShapes.elementAt(i).setSelected(true);
//			else
//				worldShapes.elementAt(i).setSelected(false);
//		}
		}
	}
	
	public void runnings() {
		Iterator<GameObject> f = gw.getIterator();
		GameObject k;
		while(f.hasNext()){
			k = f.next();
			if(k instanceof ISelectable) {
				((ISelectable) k).setSelected(false);
			}
			repaint();
		}
		select = false;
	}
	
	public boolean getSelect() {
		return select;
	}
	public void selected() {
		if(select) select = false;
		else select = true;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point origin = new Point(getX(),getY());
		
		Iterator<GameObject> f = gw.getIterator();
		GameObject k;
		//super.paint();
		int w = getWidth();
		int h = getWidth();

		while(f.hasNext()){
			k = f.next();
			if(k instanceof Ship) {
				((Ship) k).draw(g, origin );
			}
			if(k instanceof Asteroid) {
				((Asteroid) k).draw(g, origin );
			}
			if(k instanceof Missle) {
				((Missle) k).draw(g, origin );
			}
			if(k instanceof Station) {
				((Station) k).draw(g, origin );
			}
			if(k instanceof Saucer) {
				((Saucer) k).draw(g, origin );
			}
		}
	}
}
