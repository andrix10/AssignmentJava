package com.mycompany.myapp;
import java.util.*;

public class Collection implements ICollection {
	private ArrayList<GameObject> objlist;
	private int next = 0;
	
	Collection(ArrayList<GameObject> tobj){
		objlist = tobj;
	}
	
	public Iterator getIterator() {
		return new myIterator();
	}
	
	public void add(GameObject m) {
		objlist.add(m);
	}
	
	private class myIterator implements Iterator{
		
		public GameObject next(){
			return objlist.get(next++);
		}
		
		public boolean hasNext() {
			if(objlist.get(next+1) == null)
				return false;
			else 
				return true;
		}
		
		public void remove() {
			
		}
		
	}
}
