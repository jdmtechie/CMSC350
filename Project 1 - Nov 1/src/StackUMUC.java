/*
 * Course: CMSC 350
 * Assignment: Project 1
 * Author: James Moore
 * File: StackUMUC.java
 * Date: 1 Nov 2015
 * IDE: eclipse with JRE 1.8
 */

import java.util.ArrayList;

//generic stack class built IAW project 1 specifications
public class StackUMUC<T> {

	private ArrayList<T> a; //Array List to store stack
	
	//Class Constructor for FILO stack
	public StackUMUC() {
		this.a = new ArrayList<T>();
	}
	
	//adds generic element to top of stack
	public void push(T x) {
		a.add(x);
	}
	
	//removes and returns last element added to stack
	public T pop() {
		if(isEmpty()) throw new RuntimeException("The stack is empty");
		return a.remove(a.size()-1);
	}
	
	//returns last element added to stack
	public T peek() {
		if(isEmpty()) throw new RuntimeException("The stack is empty");
		return a.get(a.size()-1);
	}
	
	public String toString() {
		String aString = "";
		for(int i = a.size()-1; i >= 0; i--)
			aString += a.get(i) + " ";
		return aString;
	}
	
	public boolean isEmpty() {
		return a.isEmpty();
	}
	
	public int size() {
		return a.size();
	}
	
}
