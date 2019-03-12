package com.mycompany.a3;

public class Fixed extends GameObject{
	private int id;
	private static int nextId = 0;
	public Fixed() {
		id = nextId;
		nextId++;
		getLocation().ran();
	}
	
	public int getID() {
		return id;
	}
	
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = "id: " + getID() + " ";
		return parentDesc + myDesc;
	}
}
