package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Ship extends Moveable implements ISteer, IDrawable,ICollider{
	private int missle;
	private static Ship instance = null;
	
	private Ship() {
		super();
		getLocation().reset();
		this.missle = 12;
		setColor(0);
	}
	private Ship(Location loc) {
		super();
		setBounds(loc);
		getLocation().reset();
		this.missle = 12;
		setColor(0);
	}
	
	public static Ship getInst() {
		if(instance == null) {
			instance = new Ship();
		}
		
		return instance;
	}
	
	public void setB(Location loc) {
		setBounds(loc);
		System.out.println(getLocation().getHeight());
		System.out.println(getLocation().getWidth());
		getLocation().reset();
	}
	
	public void draw(Graphics g, Point origin) {
		int[] xPoints = {
				origin.getX()+(int)(getLocation().getX()),
				origin.getX()+(int)(getLocation().getX()+30),
				origin.getX()+(int)(getLocation().getX()-30)};
		
		int[] yPoints = {
				origin.getY()+(int)(getLocation().getY()+30),
				origin.getY()+(int)(getLocation().getY()-30),
				origin.getY()+(int)(getLocation().getY()-30)};
//		System.out.println("X " +getLocation().getX());
//		System.out.println("Y " +getLocation().getY());
//		System.out.println("X o " +origin.getX());
//		System.out.println("Y o " +origin.getY());
		g.setColor(getColorUtil());
		g.fillPolygon(xPoints, yPoints, 3);
		//g.drawRect(origin.getX()+(int)(getLocation().getX()), origin.getY()+(int)(getLocation().getY()), 5, 5, 5);
//		g.drawRect((int)(getLocation().getX() + origin.getX()), (int)(getLocation().getY()) + origin.getY(), 20, 40);
	}
	
	public void  destroy() {
		instance = null;
	}
	
	public void steerR() {
		setDir((getDirection()+15));
	}
	
	public void steerL() {
		setDir((getDirection()-15));
	}
	
	public void fire() {
		if (missle > 0)
			this.missle -= 1;
	}
	
	public void jump() {
		getLocation().reset();
	}
	
	public void refill() {
		missle = 12;
	}
	
	public void dec() {
		if(missle>0) missle -= 1;
	}
	public int getMissle() {
		return missle;
	}
	
	public boolean collidesWith(ICollider o) {
		double dx,dy;
		boolean result =false;
		if(o instanceof Asteroid) {
			Asteroid k = (Asteroid)o;
			dx = (getLocation().getX()+30)- (k.getLocation().getX()+(k.getSize()*3)/2);
			dy = (getLocation().getY()+30)- (k.getLocation().getY()+(k.getSize()*3)/2);
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = (30);
			double otherRad = (k.getSize()*3)/2;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		if(o instanceof Saucer) {
			Saucer k = (Saucer)o;
			if(k.getSize()) {
				dx = (getLocation().getX()+30)- (k.getLocation().getX()+20);
				dy = (getLocation().getY()+30)- (k.getLocation().getY()+20);
			}else {
				dx = (getLocation().getX()+30)- (k.getLocation().getX()+50);
				dy = (getLocation().getY()+30)- (k.getLocation().getY()+50);
			}
		
			double distBetSqr = (dx*dx + dy*dy);
			double thisRad = 30;
			double otherRad;
			if(k.getSize())
				otherRad = 20;
			else
				otherRad = 50;
			double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
			if(distBetSqr <= radSqr) return true;
			return result;
		}
		if(o instanceof Station) {
			if(((Station) o).getLight()) {
				Station k = (Station)o;
				dx = (getLocation().getX()+30)- (k.getLocation().getX()+50);
				dy = (getLocation().getY()+30)- (k.getLocation().getY()+50);
		
				double distBetSqr = (dx*dx + dy*dy);
				double thisRad = 30;
				double otherRad = (50)/2;
				double radSqr= (thisRad*thisRad + 2*thisRad*otherRad+otherRad*otherRad);
				if(distBetSqr <= radSqr) return true;
				return result;
			}
		}
		return result;
	}
	
	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		String parentDesc = "Ship: " + super.toString();
		String myDesc = "missles: " + getMissle() + " ";
		return parentDesc + myDesc;
	}
}
