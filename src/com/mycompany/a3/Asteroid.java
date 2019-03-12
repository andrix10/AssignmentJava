package com.mycompany.a3;

import java.util.ArrayList;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Asteroid extends Moveable implements IDrawable,ICollider,ISelectable{
	private double size;
	private boolean selected = false;
	private ArrayList<Asteroid> ignoreList = new ArrayList<Asteroid>();
	
	public Asteroid() {
		rand();
		size = ran(15, 50);
		//System.out.println("asteroid : " + size);
		setColor(1);
	}
	
	public Asteroid(Location loc) {
		setBounds(loc);
		setLoc(loc);
		rand();
		size = ran(15, 50);
		//System.out.println("asteroid : " + size);
		setColor(1);
	}
	
	public Asteroid(Location loc, double x) {
		setBounds(loc);
		setLoc(loc);
		ranSD();
		if(x==1)
			size = 3;
		else
			size = x;
		setColor(1);
	}
	
	 public void setSelected(boolean b) {
		 selected=b;
	 }
	 public boolean isSelected() {
		 return selected;
	 }
	 // a way to determine if a pointer is �in� an object
	 // pPtrRelPrnt is pointer position relative to the parent origin
	 // pCmpRelPrnt is the component position relative to the parent origin
	 public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		 int px = pPtrRelPrnt.getX(); 
			int py = pPtrRelPrnt.getY(); 
			int xLoc = pCmpRelPrnt.getX()+ (int)getLocation().getX();
			int yLoc = pCmpRelPrnt.getY()+ (int)getLocation().getY();
			if ( (px >= xLoc) && (px <= xLoc+(size*3)) 
				&& (py >= yLoc) && (py <= yLoc+(size*3) ))
				return true; 
			else 
				return false;
	 }
	 // a way to �draw� the object that knows about drawing
	 // different ways depending on �isSelected�
	
	public void randSplit() {
		rand();
	}
	
	public void changeColor(int a) {
		setColor(a);
	}
	
	public double getSize() {
		return size;
	}
	
	
	public void draw(Graphics g, Point origin) {
		if(selected) {
			g.setColor(ColorUtil.BLACK);
			//g.fillPolygon(xPoints, yPoints, 3);
			g.fillArc(origin.getX()+(int)(getLocation().getX()), origin.getY()+(int)(getLocation().getY()), (int)(3*size), (int)(3*size), 0, 360);
			//		g.drawRect((int)(getLocation().getX() + origin.getX()), (int)(getLocation().getY()) + origin.getY(), 20, 40);
		}else {

			g.setColor(getColorUtil());
			//g.fillPolygon(xPoints, yPoints, 3);
			g.fillArc(origin.getX()+(int)(getLocation().getX()), origin.getY()+(int)(getLocation().getY()), (int)(3*size), (int)(3*size), 0, 360);
//			g.drawRect((int)(getLocation().getX() + origin.getX()), (int)(getLocation().getY()) + origin.getY(), 20, 40);
		}
	}
	public void setSize(double x) {
		if (size ==1)
			size = 2;
		else 
			size = x;
	}
	
	public void addToIgnoreList(Asteroid o) {
		ignoreList.add(o);
	}
	
	public boolean collidesWith(ICollider o) {
		boolean result = false;
		if(o instanceof Asteroid) {
			Asteroid k = (Asteroid)o;
			if(ignoreList.contains(k)) {
				return false;
			}
			double dx = (getLocation().getX()+(size*3)/2)- (k.getLocation().getX()+(k.getSize()*3)/2);
			double dy = (getLocation().getY()+(size*3)/2)- (k.getLocation().getY()+(k.getSize()*3)/2);
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = (size*3)/2;
			double otherRad = (k.getSize()*3)/2;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) {
				return true;
			}
			
			ignoreList.remove(k);
			
			return result;
		}
		if(o instanceof Saucer) {
			Saucer k = (Saucer)o;
			double dx,dy;
			if(k.getSize()) {
				dx = (getLocation().getX()+(size*3)/2)- (k.getLocation().getX()+20);
				dy = (getLocation().getY()+(size*3)/2)- (k.getLocation().getY()+20);
			}else {
				dx = (getLocation().getX()+(size*3)/2)- (k.getLocation().getX()+50);
				dy = (getLocation().getY()+(size*3)/2)- (k.getLocation().getY()+50);
			}
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = (size*3)/2;
			double otherRad;
			if(k.getSize())
				otherRad = 20;
			else
				otherRad = 50;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		if(o instanceof Ship) {
			Ship k = (Ship)o;
			double dx = (getLocation().getX()+(size*3)/2)- (k.getLocation().getX()+30);
			double dy = (getLocation().getY()+(size*3)/2)- (k.getLocation().getY()+30);
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = (size*3)/2;
			double otherRad = (30);
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		if(o instanceof Missle) {
			Missle k = (Missle)o;
			double dx = (getLocation().getX()+(size*3)/2)- (k.getLocation().getX()+16);
			double dy = (getLocation().getY()+(size*3)/2)- (k.getLocation().getY()+16);
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = (size*3)/2;
			double otherRad = (16)/2;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		return result;
	}
	
	public void handleCollision(ICollider o){
		System.out.println("Colided with as");
	}
	@Override
	public String toString() {
		String parentDesc = "Asteroid: " + super.toString();
		String myDesc = "size: " + size + " ";
		return parentDesc + myDesc;
	}
}
