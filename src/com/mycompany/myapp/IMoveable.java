package com.mycompany.myapp;

public interface IMoveable {
	//public Moveable();
	public void setSpeed(int a);
	public void setDir(int b);
	public void move();
	public int getSpeed();
	public int getDirection();
	public String toString();
}
