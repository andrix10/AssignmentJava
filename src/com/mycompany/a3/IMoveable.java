package com.mycompany.a3;

public interface IMoveable {
	//public Moveable();
	public void setSpeed(int a);
	public void setDir(int b);
	public void move(double fps);
	public int getSpeed();
	public int getDirection();
	public String toString();
}
