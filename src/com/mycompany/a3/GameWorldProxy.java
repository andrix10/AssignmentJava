package com.mycompany.a3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class GameWorldProxy extends Observable implements IGameWorld {
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw) {
		this.gw = gw;
	}
	
	public void setGW(GameWorld gw) {
		this.gw = gw;
	}
	public Iterator getIterator() {
		return gw.getIterator();
	}
	public void init() {
		System.out.println("Can't do that");
	}
	
	public void createAs() {
		System.out.println("Can't do that");
	}
	
	public void createShip() {
		System.out.println("Can't do that");
	}
	
	public void createSaucer() {
		System.out.println("Can't do that");
	}
	
	public void createMissle() {
		System.out.println("Can't do that");
	}
	
	public void createStation() {
		System.out.println("Can't do that");
	}
	
	public void destroyAs() {
		System.out.println("Can't do that");
	}
	
	public void destroyShip() {
		System.out.println("Can't do that");
	}
	
	public void destroySaucer() {
		System.out.println("Can't do that");
	}
	
	public void destroyMissle() {
		System.out.println("Can't do that");
	}
	
	public void destroyStation() {
		System.out.println("Can't do that");
	}
	
	public void turnS(boolean t) {
		System.out.println("Can't do that");
	}
	
	public void jumpS() {
		System.out.println("Can't do that");
	}
	
	public void reffilS() {
		System.out.println("Can't do that");
	}
	
	public void tick() {
		System.out.println("Can't do that");
	}
	
	public String printD() {
		return gw.printD();
	}
	
	public void score(boolean f) {
		System.out.println("Can't do that");
	}
	
	public int life(boolean f) {
		System.out.println("Can't do that");
		return 0;
	}
	
	public void increaseSS() {
		System.out.println("Can't do that");
	}
	
	public void decreaseSS() {
		System.out.println("Can't do that");
	}
	
	public void print() {
		gw.print();
	}
}
