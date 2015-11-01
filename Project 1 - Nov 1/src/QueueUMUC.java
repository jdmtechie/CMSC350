/*
 * Course: CMSC 350
 * Assignment: Project 1
 * Author: James Moore
 * File: QueueUMUC.java
 * Date: 1 Nov 2015
 * IDE: eclipse with JRE 1.8
 */

import java.util.ArrayList;

//generic queue class built IAW project 1 specifications
public class QueueUMUC<T> {

	private ArrayList<T> q; //Array List to store queue
	
	//Class constructor for FIFO queue
	public QueueUMUC() {
		q = new ArrayList<T>();
	}
	
	//adds generic element to queue
	public void put(T x) {
		q.add(x);
	}
	
	//removes and returns first element placed in queue
	public T get() {
		if(isEmpty()) throw new RuntimeException("The queue is empty");
		return q.remove(0);
	}
	
	//returns first element placed in queue
	public T peek() {
		if(isEmpty()) throw new RuntimeException("The queue is empty");
		return q.get(0);
	}
	
	public String toString() {
		String qString = "";
		for(int i = 0; i <= q.size()-1; i++)
			qString += q.get(i) + " ";
		return qString;
	}
	
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	public int size() {
		return q.size();
	}
}
