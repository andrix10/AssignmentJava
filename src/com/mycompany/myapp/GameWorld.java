package com.mycompany.myapp;
import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;
import java.util.List;

public class GameWorld extends Observable implements IGameWorld{
	//private ArrayList<GameObject> objlist;
	private Location loc;
	Collection objlist;
	private boolean turn;
	private Ship ship = null;
	private int timer,lives,score,id;
	private GameWorldProxy gwp;
	
	public void init() {
		objlist = new Collection();
		this.timer = 0;
		this.lives = 3;
		this.score = 0;
		this.id = 0;
		gwp = new GameWorldProxy(this);
		loc = new Location();
		setChanged();
		notifyObservers(gwp);
	}
	
	public void setWidth(double x) {
		loc.setWidth(x);
	}
	
	public void setHeight(double x) {
		loc.setHeight(x);
	}
	
	public void createAs() {
		objlist.add(new Asteroid(loc));
	}
	
	public void createShip() {
		if(ship == null) {
			ship = Ship.getInst();
			ship.setB(loc);
			objlist.add(ship);
		}
		setChanged();
		notifyObservers(gwp);
	}
	
	public void createSaucer() {
		objlist.add(new Saucer(loc));
	}
	
	public void createMissle() {
		if(ship==null)return;
		else {
			objlist.add(new Missle(ship));
			ship.dec();
		}
		setChanged();
		notifyObservers(gwp);
	}
	
	public void createStation() {
		objlist.add(new Station(loc));
	}
	
	public void destroyAs() {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Asteroid) {
				i.remove();
				break;
			}
		}
	}
	
	public void destroyShip() {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Ship) {
				i.remove();
				ship.destroy();
				break;
			}
		}
		ship = null;
	}
	
	public void destroySaucer() {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Saucer) {
				i.remove();
				break;
			}
		}
	}
	
	public void destroyMissle() {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Missle) {
				i.remove();
				break;
			}
		}
	}
	
	public void destroyStation() {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Station) {
				i.remove();
				break;
			}
		}
	}
	
	public void turnS(boolean t) {
		if(t)ship.steerR();
		else if(!t) ship.steerL();
	}
	
	public void jumpS() {
		ship.jump();
	}
	
	public void reffilS() {
		setChanged();
		ship.refill();
		notifyObservers(gwp);
	}
	
	public void tick() {
		
		timer =+ 1;
		Object i;
		Iterator<GameObject> iter = objlist.getIterator();
		while(iter.hasNext()){
			i = iter.next();
			
			if(i instanceof Moveable){
				Moveable temp = (Moveable)i;
				temp.move();
			}
			
			if(i instanceof Missle){
				Missle temp = (Missle)i;
				if(temp.getFuel() == 1)
					destroyMissle();
				else
					temp.dec();
			}
			
			if(i instanceof Station){
				Station temp = (Station)i;
				if(timer % temp.getBlink() == 0)
					temp.toggle();
			}
			
		}
		setChanged();
		notifyObservers(gwp);
	}
	/*
	public void printD() {
		if(ship !=null )
			System.out.println("score: " + score + " missles: " + ship.getMissle()+" time: " +timer+" lives: " + lives +" ");
		else 
			System.out.println("score: " + score + " time: " +timer+" lives: " + lives +" ");
	}*/
	
	public void score(boolean f) {
		if(f)score++;
		else if(score>=0)score--;
		else score = 0;
		setChanged();
		notifyObservers(gwp);
	}
	
	public int life(boolean f) {
		if(f)lives++;
		else if(lives>0 && !f)lives--;
		setChanged();
		notifyObservers(gwp);
		return lives;
	}
	
	public void increaseSS() {
		ship.setSpeed(ship.getSpeed()+1);
	}
	
	public void decreaseSS() {
		ship.setSpeed(ship.getSpeed()-1);
	}
	
	
	public void print() {
		Object i;
		Iterator<GameObject> iter = objlist.getIterator();
		
		while(iter.hasNext()) {
			i = iter.next();
			System.out.print(i + "\n");
		}
		//System.out.print(i + "\n");
	}
	
	public String printD() {
		if(ship == null)
			return "score: " + score + " missles: 0" +" time: " +timer+" lives: " + lives + " ";		
		else
			return "score: " + score + " missles: " + ship.getMissle()+" time: " +timer+" lives: " + lives + " ";		
	}
	
}
