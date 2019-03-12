package com.mycompany.a3;
import java.lang.Math;
import java.util.*;
import java.util.Date;

public class GameWorld extends Observable implements IGameWorld{
	//private ArrayList<GameObject> objlist;
	private Location loc,max;
	Collection objlist;
	private boolean turn;
	private Ship ship = null;
	private int timer,lives,score,id;
	private GameWorldProxy gwp;
	private Sound exp, fire,end;
	private long lastAT = new Date().getTime();
	private long lastST = new Date().getTime();
	private boolean sound= true;
	
	public void init() {
		objlist = new Collection();
		this.timer = 0;
		this.lives = 3;
		this.score = 0;
		this.id = 0;
		gwp = new GameWorldProxy(this);
		loc = new Location();
		max = new Location();
		setChanged();
		notifyObservers(gwp);
		exp = new Sound("bam.wav");
		fire = new Sound("BLAST.WAV");
		end = new Sound("lose.mp3");
	}
	
	public void setWidth(double x,double y) {
		loc.setWidth(x);
		max.setWidth(y);
		max.setX(y);
	}
	
	public void splitTwo(Asteroid a){
//		Iterator<GameObject> i = objlist.getIterator();
		Location temp = a.getLocation();
		temp.set(temp.getX(), temp.getY());
		a.setSize(a.getSize() / 2);
		Asteroid newAstroid = new Asteroid(temp, a.getSize());
		newAstroid.setSize(a.getSize());
		newAstroid.setDir(a.getDirection() - 180);
		objlist.add(newAstroid);
		a.addToIgnoreList(newAstroid);
		newAstroid.addToIgnoreList(a);
//		while(i.hasNext()){
//			k = i.next();
//			temp = a.getLocation();
//			temp.setX(temp.getX()+20);
//			if(k instanceof Asteroid) {
//				if((Asteroid)k == (Asteroid)a) {
//					createAs(temp,(((Asteroid) k).getSize())/2);
//					((Asteroid) k).setSize((((Asteroid) k).getSize())/2);
//					System.out.println(((Asteroid) k).getSize()/2);
//					break;
//				}
//			}
//		}
		setChanged();
		notifyObservers(gwp);
	}
	
	public void splitThree(Asteroid a) {
		Location temp1 = a.getLocation();
		temp1.set(temp1.getX(), temp1.getY());
		a.setSize(a.getSize() / 2);
		Asteroid newAstroid = new Asteroid(temp1, a.getSize());
		newAstroid.setSize(a.getSize());
		newAstroid.setDir(a.getDirection() - 120);
		objlist.add(newAstroid);
		
		Location temp2 = a.getLocation();
		temp2.set(temp2.getX(), temp2.getY());
		Asteroid newAstroid2 = new Asteroid(temp2, a.getSize());
		newAstroid2.setDir(a.getDirection() - 240);
		objlist.add(newAstroid2);
		
		a.addToIgnoreList(newAstroid);
		a.addToIgnoreList(newAstroid2);
		newAstroid.addToIgnoreList(a);
		newAstroid.addToIgnoreList(newAstroid2);
		newAstroid2.addToIgnoreList(a);
		newAstroid2.addToIgnoreList(newAstroid);
//		GameObject k;
//		Iterator<GameObject> i = objlist.getIterator();
//		Location temp = a.getLocation();
//		while(i.hasNext()){
//			k = i.next();
//			temp = a.getLocation();
//			temp.setX(temp.getX()+20);
//			if(k instanceof Asteroid) {
//				if((Asteroid)k == (Asteroid)a) {
//					createAs(temp,((Asteroid) k).getSize()/3);
//					temp.setX(temp.getX()+10);
//					createAs(temp,(((Asteroid) k).getSize()/3));
//					((Asteroid) k).setSize((((Asteroid) k).getSize()/3));
//					//System.out.println(((Asteroid) k).getSize()/3);
//					break;
//				}
//			}
//		}
		setChanged();
		notifyObservers(gwp);
	}
	public Iterator getIterator() {
		return objlist.getIterator();
	}
	
	public void switchS() {
		sound = !sound;
		System.out.println("switched sound");
	}
	
	public double getSize() {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Asteroid) {
				return (((Asteroid) k).getSize());
			}
		}
		return 0;
	}
	
	public void setHeight(double x,double y) {
		loc.setHeight(x);
		max.setHeight(y);
		max.setY(y);
	}
	
	public void createAs() {
		objlist.add(new Asteroid(loc));
	}
	
	public void createAs(Location l,double x) {
		objlist.add(new Asteroid(l, x));
		setChanged();
		notifyObservers(gwp);
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
		setChanged();
		notifyObservers(gwp);
	}
	
	public void createMissle() {
		if(ship==null ) return;
		
		if(ship.getMissle()<1) {
			System.out.println("shipmissle "+ship.getMissle());
			return;
		}
		else 
		{
			System.out.println("missle bam rekt" + ship.getMissle());
			
			objlist.add(new Missle(ship));
			ship.dec();
		}
		fire.playSound(sound);
		setChanged();
		notifyObservers(gwp);
	}
	
	public void createStation() {
		objlist.add(new Station(loc));
		setChanged();
		notifyObservers(gwp);
	}
	
	public boolean getSound() {
		return sound;
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
		
		setChanged();
		notifyObservers(gwp);
	}
	
	public void destroyAs(Asteroid a) {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Asteroid) {
				if(k == a) {
					i.remove();
					break;
				}
			}
		}
		
		setChanged();
		notifyObservers(gwp);
	}
	public void destroySaucer(Saucer s) {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Saucer) {
				if(k == s) {
					i.remove();
					break;
				}
			}
		}
		
		setChanged();
		notifyObservers(gwp);
	}
	
	public void destroyMissle(Missle m) {
		GameObject k;
		Iterator<GameObject> i = objlist.getIterator();
		while(i.hasNext()){
			k = i.next();
			if(k instanceof Missle) {
				if(k == m) {
					i.remove();
					break;
				}
			}
		}
		
		setChanged();
		notifyObservers(gwp);
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
		life(false);
		ship = null;
		setChanged();
		notifyObservers(gwp);
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
		setChanged();
		notifyObservers(gwp);
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
		setChanged();
		notifyObservers(gwp);
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
		setChanged();
		notifyObservers(gwp);
	}
	
	public void turnS(boolean t) {
		if(ship != null) {
			if(t)ship.steerR();
			else if(!t) ship.steerL();
		}
		
	}
	
	public void jumpS() {
		if(ship!=null) ship.jump();
		setChanged();
		notifyObservers(gwp);
	}
	
	public void reffilS() {
		setChanged();
		if(ship!=null) ship.refill();
		notifyObservers(gwp);
	}
	
	public void tick() {
		
		timer = timer+ 1;
		Object i;
		
		long n = new Date().getTime();
		if(n - lastAT >= 3000 && sound) {
			createAs();
			lastAT = n;
		}
		if(n - lastST >= 6000 && sound) {
			createSaucer();
			lastST = n;
		}
		Iterator<GameObject> iter = objlist.getIterator();
		while(iter.hasNext()){
			i = iter.next();
			
			if(i instanceof Moveable){
				Moveable temp = (Moveable)i;
				
				if((((Moveable) i).getLocation().getX())<=(0) || (((Moveable) i).getLocation().getY())<=(0)) {
					((Moveable) i).setDir(((Moveable) i).getDirection()-180);
				}
				if(((Moveable) i).getLocation().getX()>(loc.getWidth()) || ((Moveable) i).getLocation().getY()>(loc.getHeight())) {
					((Moveable) i).setDir(((Moveable) i).getDirection()-180);
				}
//				if(((Moveable) i).getLocation().getY()>loc.getBounds().getY() ) {
//					((Moveable) i).setDir(((Moveable) i).getDirection()-180);
//				}
				temp.move(25);
			}
			
			if(i instanceof Missle){
				Missle temp = (Missle)i;
				if(temp.getFuel() == 1)
					destroyMissle();
				else
					temp.dec();
			}
			
			
			
//			if(i instanceof Station){
//				Station temp = (Station)i;
//				if(timer % temp.getBlink() == 0)
//					temp.toggle();
//			}
//			if(i instanceof Station){
//				Station temp = (Station)i;
//				if(timer % temp.getBlink() == 0)
//					temp.toggle();
//			}
//			if(i instanceof Moveable) {
//				if(((Moveable) i).getLocation().getX()>=((Moveable) i).getLocation().getBounds().getX() ) {
//					((Moveable) i).setSpeed(((Moveable) i).getSpeed()*-1);
//				}
//				if(((Moveable) i).getLocation().getY()>=((Moveable) i).getLocation().getBounds().getY() ) {
//					((Moveable) i).setSpeed(((Moveable) i).getSpeed()*-1);
//				}
//			}
			
		}
		iter = objlist.getIterator();
		//GameObject temp= iter.getClass();
		while(iter.hasNext()){
			ICollider curr = (ICollider) iter.next();
			Iterator iter2 = objlist.getIterator();
			while(iter2.hasNext()) {
				ICollider other = (ICollider) iter2.next();
				if(other != curr) {
					if(curr.collidesWith(other)) {
						if(curr instanceof Asteroid && other instanceof Missle) {
							aSplit((Asteroid)curr);
							destroyMissle((Missle)other);
							exp.playSound(sound);
							score(true);
						}
						else if(curr instanceof Missle && other instanceof Asteroid) {
							destroyMissle((Missle)curr);
							aSplit((Asteroid)other);
							exp.playSound(sound);
							score(true);
						}
						if(curr instanceof Saucer && other instanceof Missle) {
							destroySaucer((Saucer)curr);
							destroyMissle((Missle)other);
							score(true);
						}
						else if(curr instanceof Missle && other instanceof Saucer) {
							destroyMissle((Missle)curr);
							destroySaucer((Saucer)other);
							score(true);
						}
						else if(curr instanceof Asteroid && other instanceof Asteroid) {
							//destroyAs();
							aSplit((Asteroid)(curr));
							aSplit((Asteroid)(other));
							exp.playSound(sound);
						}
						else if(curr instanceof Saucer && other instanceof Asteroid) {
							//destroyAs();
							destroySaucer((Saucer)curr);
							aSplit((Asteroid)(other));
							//aSplit();
						}
						else if(curr instanceof Asteroid && other instanceof Saucer) {
							//destroyAs();
							destroySaucer((Saucer)other);
							aSplit((Asteroid)(curr));
							exp.playSound(sound);
							//aSplit();
						}
						else if(curr instanceof Saucer && other instanceof Saucer) {
							destroySaucer((Saucer)other);
							destroySaucer((Saucer)curr);
							exp.playSound(sound);
							//aSplit();
						}
						else if(curr instanceof Asteroid && other instanceof Ship) {
							aSplit((Asteroid)(curr));
							score(false);
							destroyShip();
							exp.playSound(sound);
							//aSplit();
						}
						else if(curr instanceof Ship && other instanceof Asteroid) {
							aSplit((Asteroid)(other));
							destroyShip();
							score(false);
							exp.playSound(sound);
							//aSplit();
						}
						else if(curr instanceof Saucer && other instanceof Ship) {
							destroySaucer((Saucer)curr);
							score(false);
							destroyShip();
							//exp.playSound();
							//aSplit();
						}
						else if(curr instanceof Ship && other instanceof Saucer) {
							destroySaucer((Saucer)other);
							score(false);
							destroyShip();
							//exp.playSound();
							//aSplit();
						}
						else if(curr instanceof Ship && other instanceof Station) {
							if(((Station) other).getLight()) ((Ship)curr).refill();
							//exp.playSound();
							//aSplit();
						}
						else if(curr instanceof Station && other instanceof Ship) {
							if(((Station) curr).getLight()) ((Ship)other).refill();
							//exp.playSound();
							//aSplit();
						}
					}
				}
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
	public void aSplit(Asteroid k) {
		if(k.getSize()<19) {
			destroyAs(k);
			return;
		}
		if (k.getSize()<25) {
			splitTwo(k);
			return;
		}
		if (k.getSize()>24) {
			splitThree(k);
			return;
		}
	}
	
	public void score(boolean f) {
		if(f)score++;
		else if(score>=0)score--;
		else score = 0;
		setChanged();
		notifyObservers(gwp);
	}
	
	public int life(boolean f) {
		if(f)lives++;
		else if(lives>0 && !f && ship != null)lives--;
		//else if(lives == 0) end.playSound(sound);
		setChanged();
		notifyObservers(gwp);
		return lives;
	}
	
	public int getLife() {
		if(lives == 0) end.playSound(sound);
		return lives;
	}
	
	public void increaseSS() {
		if(ship!=null) ship.setSpeed(ship.getSpeed()+30);
	}
	
	public void decreaseSS() {
		if(ship!=null) ship.setSpeed(ship.getSpeed()-30);
	}
	
	public void playEnd() {
		end.playSound(sound);
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
