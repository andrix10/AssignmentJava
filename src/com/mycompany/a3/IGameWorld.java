package com.mycompany.a3;

public interface IGameWorld {
	public void init() ;
	
	public void createAs() ;
	
	public void createShip() ;
	
	public void createSaucer() ;
	
	public void createMissle() ;
	
	public void createStation() ;
	
	public void destroyAs() ;
	
	public void destroyShip() ;
	
	public void destroySaucer();
	
	public void destroyMissle() ;
	
	public void destroyStation();
	
	public void turnS(boolean t) ;
	
	public void jumpS() ;
	
	public void reffilS();
	
	public void tick() ;
	
	public String printD() ;
	
	public void score(boolean f) ;
	
	public int life(boolean f) ;
	
	public void increaseSS() ;
	
	public void decreaseSS() ;
	
	public void print() ;
}
