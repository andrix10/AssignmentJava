package com.mycompany.myapp;

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
	
	public void init() {
		System.out.println("Can't do that");
	}
	
	public void createAs() {
		gw.createAs();
	}
	
	public void createShip() {
		gw.createShip();
	}
	
	public void createSaucer() {
		gw.createSaucer();
	}
	
	public void createMissle() {
		gw.createMissle();
	}
	
	public void createStation() {
		gw.createStation();
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
		gw.turnS(t);
	}
	
	public void jumpS() {
		gw.jumpS();
	}
	
	public void reffilS() {
		gw.reffilS();
	}
	
	public void tick() {
		gw.tick();
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
		gw.increaseSS();
	}
	
	public void decreaseSS() {
		gw.decreaseSS();
	}
	
	public void print() {
		gw.print();
	}
}
