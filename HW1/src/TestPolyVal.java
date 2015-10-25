/*
 * Course: CMSC 350
 * Assignment: Homework 1
 * Author: James Moore
 * File: TestPolyVal.java
 * Date: 25 OCT 2015
 * IDE: eclipse with JRE 1.8
 */
import java.util.concurrent.ThreadLocalRandom;

//Tests 2 methods for evaluating polynomial equations
public class TestPolyVal {
	private int deg;			//degree of the equation
	private int x;				//x value
	private int[] polyArray;	//Array of Coefficients
	
	//Constructor of an Array with randoms -9 to 9 and random x from 1 to 9
	//Assigns degree to equation based on Array size desired
	public TestPolyVal(int arraySize) {
		polyArray = new int[arraySize];
		for(int i = 0; i < polyArray.length; i++) {
			polyArray[i] = ThreadLocalRandom.current().nextInt(-9, 9 + 1);
		}
		deg = polyArray.length - 1;
		x = ThreadLocalRandom.current().nextInt(1, 9 + 1);
	}//close TestPolyVal
	
	//Prints equation in an easier to read format
	//Returns string representation of equation in ax^b format
	public String toString() {
		if(deg == 0) {
			return "" + polyArray[0];
		}
		if(deg == 1 && polyArray[0] > 0 ) {
			return polyArray[1] + "n + " + polyArray[0];
		}
		if(deg == 1 && polyArray[0] < 0 ) {
			return polyArray[1] + "n - " + (-polyArray[0]);
		}
		String polyStr = polyArray[deg] + "n^" + deg;
		for(int i = deg - 1; i >= 0; i--) {
			if(polyArray[i] >= 0) {
				polyStr += " + " + polyArray[i] + "n^" + i;
			} else if(polyArray[i] < 0) {
				polyStr += " - " + (-polyArray[i]) + "n^" + i;
			} else {
				polyStr += polyArray[i];
			}
		}
		return polyStr;
	}//close toString
	
	//Evaluates a polynomial stored as an array of coefficients with brute force 
	//Returns an integer total
	public int calculateBruteForce() {
		int polyVal = 0;
		int raised;
		for(int i = 0; i <= deg; i++) {
			if(i == 0) {
				polyVal += polyArray[i];
			} else if(polyArray[i] == 0) {
				polyVal += 0;
			} else {
				raised = 1;
				for(int n = 0; n <= i - 1; n++) {
					raised *= x;
				} 
				polyVal += raised * polyArray[i];
			}
		}
		return polyVal;
	}//close calculateBruteForce
	
	//Evaluates a polynomial stored as an array of coefficients using Horner's method
	//Returns an integer total
	public int calculateHorner() {
		int polyVal = 0;
		for(int i = deg; i >= 0; i--) {
			polyVal = (x * polyVal) + polyArray[i];
		}
		return polyVal;
	}//close calculateHorner
	
	//Runs test runs
	public long meanTime() {
		for(int i = 0; )
	}
	//Instantiates object TestPolyVal and prints relevant information
	public static void main(String[] args) {
		TestPolyVal a = new TestPolyVal(10);
		
		System.out.println("James Moore, CMSC 350, Homework 1");
		System.out.println(a);
		System.out.println("n = " + a.x);
		
		Long startBrute = System.nanoTime();
		System.out.println("Brute Force Result: " + a.calculateBruteForce());
		Long endBrute = System.nanoTime();
		
		Long startHorner = System.nanoTime();
		System.out.println("Horner Result: " + a.calculateHorner());
		Long endHorner = System.nanoTime();
		
		System.out.println("Brute Force Time: " + (endBrute - startBrute) + " nanoseconds");
		System.out.println("Horner Time: " + (endHorner - startHorner) + " nanoseconds");	
	}//close main
}//close TestPolyVal class
