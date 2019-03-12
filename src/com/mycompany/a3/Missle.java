package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Missle extends Moveable implements IDrawable,ICollider,ISelectable{
	private int fuel;
	private static int drawSize =16;
	private boolean selected = false;
	
	public Missle(Ship s) {
		setBounds(s.getLocation().getBounds());
		setLoc(s.getLocation());
		System.out.println("mis" + getLocation().getX() +" " +getLocation().getY());
		System.out.println("ship"+s.getLocation().getX() +" " +s.getLocation().getY());
		//setBounds(s.getLocation().getBounds());
//		getLocation().setY(getLocation().getY()+33);
//		getLocation().setX(getLocation().getX()+33);
		setSpeed(200+6*s.getSpeed());
		setDir(s.getDirection());
		fuel = 26;
		setColor(0);
	}
	
	public void dec() {
		fuel -= 1;
	}
	
	public int getFuel() {
		return fuel;
	}
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		 int px = pPtrRelPrnt.getX(); 
			int py = pPtrRelPrnt.getY(); 
			int xLoc = pCmpRelPrnt.getX()+ (int)getLocation().getX();
			int yLoc = pCmpRelPrnt.getY()+ (int)getLocation().getY();
			if ( (px >= xLoc-drawSize) && (px <= xLoc+drawSize) 
				&& (py >= yLoc-drawSize) && (py <= yLoc+drawSize))
				return true; 
			else 
				return false;
	 }
	
	public int getDrawSize() {
		return drawSize;
	}
	public void setSelected(boolean b) {
		 selected=b;
	 }
	 public boolean isSelected() {
		 return selected;
	 }
	public void draw(Graphics g, Point origin) {
		int[] xPoints = {origin.getX()+(int)(getLocation().getX()),
				origin.getX()+(int)(getLocation().getX()+drawSize),
				origin.getX()+(int)(getLocation().getX()-drawSize)};
		int[] yPoints = {origin.getY()+(int)(getLocation().getY()+drawSize),
				origin.getY()+(int)(getLocation().getY()-drawSize),
				origin.getY()+(int)(getLocation().getY()-drawSize)};
//		System.out.println("X " +getLocation().getX());
//		System.out.println("Y " +getLocation().getY());
//		System.out.println("X o " +origin.getX());
//		System.out.println("Y o " +origin.getY());
		if(selected) {
			g.setColor(ColorUtil.BLACK);
		}else {
			g.setColor(getColorUtil());
		}
		g.fillPolygon(xPoints, yPoints, 3);
//		g.drawRect((int)(getLocation().getX() + origin.getX()), (int)(getLocation().getY()) + origin.getY(), 20, 40);
	}
	
	public void changeColor(int a) {
		setColor(a);
	}
	
	public boolean collidesWith(ICollider o) {
		boolean result = false;
		if(o instanceof Asteroid) {
			Asteroid k = (Asteroid)o;
			double dx = (getLocation().getX()+drawSize)- (k.getLocation().getX()+(k.getSize()*3)/2);
			double dy = (getLocation().getY()+drawSize)- (k.getLocation().getY()+(k.getSize()*3)/2);
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = (drawSize)/2;
			double otherRad = (k.getSize()*3)/2;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		if(o instanceof Saucer) {
			Saucer k = (Saucer)o;
			double dx,dy;
			if(k.getSize()) {
				dx = (getLocation().getX()+drawSize)- (k.getLocation().getX()+20);
				dy = (getLocation().getY()+drawSize)- (k.getLocation().getY()+20);
			}else {
				dx = (getLocation().getX()+drawSize)- (k.getLocation().getX()+50);
				dy = (getLocation().getY()+drawSize)- (k.getLocation().getY()+50);
			}
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = drawSize/2;
			double otherRad;
			if(k.getSize())
				otherRad = 20;
			else
				otherRad = 50;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		return false;
	}
	
	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		System.out.println("collided");
	}
	
	@Override
	public String toString() {
		String parentDesc = "Missle: " + super.toString();
		String myDesc = "fuel: " + getFuel() +" ";
		return parentDesc + myDesc;
	}
}
