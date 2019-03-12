package com.mycompany.a3;
import java.util.Random;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import com.codename1.charts.util.ColorUtil;

public class Saucer extends Moveable implements IDrawable,ICollider{
	private boolean size;
	public Saucer() {
		super();
		rand();
		setColor(2);
		int ran = ran(1,20);
		if(ran >10) {
			size = true;
		}else {
			size = false;
		}
	}
	public Saucer(Location loc) {
		super();
		setBounds(loc);
		rand();
		setColor(2);
		int ran = ran(1,20);
		if(ran >10) {
			size = true;
		}else {
			size = false;
		}
	}
	
	public boolean getSize() {
		return size;
	}
	
	public void changeColor(int a) {
		setColor(a);
	}
	
	public boolean collidesWith(ICollider o) {
		boolean result = false;
		double dx,dy;
		if(o instanceof Asteroid) {
			Asteroid k = (Asteroid)o;
			if(size) {
				dx = (getLocation().getX()+20)- (k.getLocation().getX()+(k.getSize()*3)/2);
				dy = (getLocation().getY()+20)- (k.getLocation().getY()+(k.getSize()*3)/2);
			}else {
				dx = (getLocation().getX()+50)- (k.getLocation().getX()+(k.getSize()*3)/2);
				dy = (getLocation().getY()+50)- (k.getLocation().getY()+(k.getSize()*3)/2);
			}
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad;
			if(size)
				thisRad = 20;
			else
				thisRad = 50;
			double otherRad = (k.getSize()*3)/2;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		if(o instanceof Saucer) {
			Saucer k = (Saucer)o;
			if(k.getSize()) {
				dx = (getLocation().getX()+20)- (k.getLocation().getX()+20);
				dy = (getLocation().getY()+20)- (k.getLocation().getY()+20);
			}else {
				dx = (getLocation().getX()+50)- (k.getLocation().getX()+50);
				dy = (getLocation().getY()+50)- (k.getLocation().getY()+50);
			}
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad;
			if(size)
				thisRad = 20;
			else
				thisRad = 50;
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
			
			if(getSize()) {
				dx = (getLocation().getX()+20)- (k.getLocation().getX()+30);
				dy = (getLocation().getY()+20)- (k.getLocation().getY()+30);
			}else {
				dx = (getLocation().getX()+50)- (k.getLocation().getX()+30);
				dy = (getLocation().getY()+50)- (k.getLocation().getY()+30);
			}
			
			double thisRad;
			double distBetSqr = (dx*dx + dy*dy);
			if(size)
				thisRad = 20;
			else
				thisRad = 50;
			double otherRad = (30)/2;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		if(o instanceof Missle) {
			Missle k = (Missle)o;
			
			if(getSize()) {
				dx = (getLocation().getX()+20)- (k.getLocation().getX()+16);
				dy = (getLocation().getY()+20)- (k.getLocation().getY()+16);
			}else {
				dx = (getLocation().getX()+50)- (k.getLocation().getX()+16);
				dy = (getLocation().getY()+50)- (k.getLocation().getY()+16);
			}
			
			double thisRad;
			double distBetSqr = (dx*dx + dy*dy);
			if(size)
				thisRad = 20;
			else
				thisRad = 50;
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
	
	public void draw(Graphics g, Point origin) {
		
		g.setColor(getColorUtil());
		//g.fillPolygon(xPoints, yPoints, 3);
		if(size)
			g.fillArc(origin.getX()+(int)(getLocation().getX()), origin.getY()+(int)(getLocation().getY()), 40, 40, 0, 360);
		else
			g.fillArc(origin.getX()+(int)(getLocation().getX()), origin.getY()+(int)(getLocation().getY()), 100, 100, 0, 360);
//		g.drawRect((int)(getLocation().getX() + origin.getX()), (int)(getLocation().getY()) + origin.getY(), 20, 40);
	}
	
	@Override
	public String toString() {
		String s;
		if(getSize()) s = "large";
		else s = "small";
			
		String parentDesc = "Saucer: " + super.toString();
		String myDesc = "size: " + s + " ";
		return parentDesc + myDesc;
	}
}
