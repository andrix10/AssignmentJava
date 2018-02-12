package com.mycompany.myapp;

public class Fixed extends GameObject{
	private int id;
	private static int nextId = 0;
	public Fixed() {
		id = nextId;
		nextId++;
	}
}
