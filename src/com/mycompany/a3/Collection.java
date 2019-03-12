package com.mycompany.a3;
import java.util.*;

public class Collection implements ICollection {
	private ArrayList<GameObject> objlist;
	private int next = 0;
	//private int currElementIndex;
	//private int current = 0;
	
	Collection(){
		objlist = new ArrayList<GameObject>();
	}
	
	Collection(ArrayList<GameObject> tobj){
		objlist = tobj;
	}
	
	public Iterator getIterator() {
		return new myIterator();
	}
	
	public void add(GameObject m) {
		objlist.add(m);
	}
	
	public GameObject getMine() {
		return objlist.get(next);
	}
	
	public GameObject getMine(int x) {
		next = x;
		return objlist.get(x);
	}
	
	public int size() {
		return objlist.size();
	}
	
	
	private class myIterator implements Iterator{
		private int currElementIndex;
		
		myIterator(){
			currElementIndex = -1;
		}
		
		public boolean hasNext() {
			if (objlist.size ( ) <= 0)  return false;
			if (currElementIndex >= objlist.size() - 1 ) return false;
			return true;
		}
		
		public Object next(){
			currElementIndex++;
			return(objlist.get(currElementIndex));
		}
		
		public void remove() {
			if(objlist.size() <= 0) return;
			objlist.remove(currElementIndex);
		}
		/*
		public GameObject next(){
			if(next<objlist.size()) {
				next++;
				//System.out.println(next-1);
				return objlist.get(next-1);
			}
			return null;
		}
		
		public boolean hasNext() {
			//System.out.println(objlist.get(objlist.size()));
			if(next<objlist.size()) return true;
			else return false;
		}
		*/
		
	}
}
