/*
 * Course: CMSC 350
 * Assignment: Project 1
 * Author: James Moore
 * File: Point.java
 * Date: 1 Nov 2015
 * IDE: eclipse with JRE 1.8
 */

//class for data type Point to store Cartesian points in (x,y) format
public class Point {

	private double x;
	private double y;
	
	//Constructs a Point object
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	//retrieves the x value of a Point
	public Double getX() {
		return this.x;
	}
	
	//retrieves the y value of a Point
	public Double getY() {
		return this.y;
	}
	
	//returns Point in (x,y) format
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
