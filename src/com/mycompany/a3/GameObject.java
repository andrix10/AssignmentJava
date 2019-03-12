package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import java.util.Random;

public abstract class GameObject {
	private Location location;
	private int color;
	
	public GameObject() {
		location = new Location();
	}
	
	public GameObject(double x, double y) {
		location.set(x,y);
		
	}
	
	public GameObject(Location loc) {
		setLoc(loc);
		setBounds(loc);
	}
	public void setBounds(Location loc) {
		location.setHeight(loc.getHeight());
		location.setWidth(loc.getWidth());
	}
	public void setLoc(Location loc) {
		location.setX(loc.getX());
		location.setY(loc.getY());
		setBounds(loc);
	}
	
	public Location getLocation() {
		return location;
	}
	
	public int ran(int a, int b) {
		Random rand = new Random();
		int ran = rand.nextInt(b) + a;
		return ran;
	}
	
	public void setColor(int a) {
		if(a == 0) color = ColorUtil.GREEN;
		else if(a == 1) color = ColorUtil.BLUE;
		else if(a == 2)color = ColorUtil.MAGENTA;
		else if(a == 3)color = ColorUtil.CYAN;
		else color = ColorUtil.YELLOW;
	}
	
	public String getColor() {
		String s = "["+ColorUtil.red(color) +","+ ColorUtil.green(color) +","+ ColorUtil.blue(color)+"]";
		return s;
	}
	
	public int getColorUtil() {
		return color;
	}
	
	@Override
	public String toString() {
		String myDesc = "loc: " + getLocation().getX() + " " + getLocation().getY() + " " + "color: " + getColor() + " ";
		return myDesc;
	}
	
}
