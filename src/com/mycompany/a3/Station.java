package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import java.util.Date;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Station extends Fixed implements IDrawable,ICollider{
	private int rate;
	private boolean light = true;
	private long lastTimeStamp = new Date().getTime();
	public Station() {
		rate = ran(1,5);
		setColor(3);
	}
	
	public Station(Location loc) {
		setBounds(loc);
		rate = ran(1,5);
		setColor(3); 
		getLocation().ran();
		System.out.println("X " +loc.getHeight());
		System.out.println("Y " +loc.getWidth());
		
	}
	
	public void resupply(){
		
	}
	
	public boolean getLight() {
		return light;
	}
	
	public int getBlink() {
		return rate;
	}
	
	public void changeColor(int a) {
		setColor(a);
	}
	public boolean collidesWith(ICollider o) {
		boolean result = false;
		
		if(o instanceof Ship && light) {
			Ship k = (Ship)o;
			double dx = (getLocation().getX()+50)- (k.getLocation().getX()+30);
			double dy = (getLocation().getY()+50)- (k.getLocation().getY()+30);
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = (50)/2;
			double otherRad = (30)/2;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		return result;
	}
	
	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		System.out.println("collided");
	}
	
	public void draw(Graphics g, Point origin) {
		long n = new Date().getTime();
		long diff = n - lastTimeStamp;
//		System.out.println("diff=" + diff);
		if(n - lastTimeStamp >= rate * 1000) {
			light = !light;
			lastTimeStamp = n;
		}
		if(light) {
			g.setColor(getColorUtil());
//			System.out.println("X " +getLocation().getX());
//			System.out.println("Y " +getLocation().getY());
//			System.out.println("X o " +origin.getX());
//			System.out.println("Y o " +origin.getY());
			g.fillRect(origin.getX()+(int)(getLocation().getX()), origin.getY()+(int)(getLocation().getY()), 100, 100);
		}
	}
	
	@Override
	public String toString() {
		String parentDesc = "Station: " + super.toString();
		String myDesc = "rate: " + rate + " ";
		return parentDesc + myDesc;
	}
}
