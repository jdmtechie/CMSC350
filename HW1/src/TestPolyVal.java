/*
 * file: TestPolyVal.java
 * author: James Moore
 */
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class TestPolyVal {
	private int deg;
	private int x;
	private int[] polyArray;
	
	//Create an Array with randoms -9 to 9 and random x from 1 to 9
	public TestPolyVal(int arraySize) {
		polyArray = new int[arraySize];
		for(int i = 0; i < polyArray.length; i++)
			polyArray[i] = ThreadLocalRandom.current().nextInt(-9, 9 + 1);
		deg = polyArray.length - 1;
		x = ThreadLocalRandom.current().nextInt(1, 9 + 1);
	}
	
	public String toString() {
		if(deg == 0) return "" + polyArray[0];
		if(deg == 1 && polyArray[0] > 0 ) return polyArray[1] + "n + " + polyArray[0];
		if(deg == 1 && polyArray[0] < 0 ) return polyArray[1] + "n - " + (-polyArray[0]);
		String polyStr = polyArray[deg] + "n^" + deg;
		for(int i = deg - 1; i >= 0; i--) {
			if(polyArray[i] >= 0) polyStr += " + " + polyArray[i] + "n^" + i;
			else if(polyArray[i] < 0) polyStr += " - " + (-polyArray[i]) + "n^" + i;
			else polyStr += polyArray[i];
		}
		return polyStr;
	}
	
	public int calculateBruteForce() {
		int polyVal = 0;
		int raised;
		for(int i = 0; i <= deg; i++) {
			if(i == 0) polyVal += polyArray[i];
			else if(polyArray[i] == 0) polyVal += 0;
			else {
				raised = 1;
				for(int n = 0; n <= i - 1; n++)
					raised *= x;
			polyVal += raised * polyArray[i];
			}
		}
		return polyVal;
	}
	
	public int calculateHorner() {
		int polyVal = 0;
		for(int i = deg; i >= 0; i--)
			polyVal = (x * polyVal) + polyArray[i];
		return polyVal;
	}
	
	public static void main(String[] args) {
		TestPolyVal a = new TestPolyVal(10);
		System.out.println(Arrays.toString(a.polyArray));
		System.out.println(a);
		System.out.println("n = " + a.x);
		
		Long startBrute = System.nanoTime();
		System.out.println("Brute Force: " + a.calculateBruteForce());
		Long endBrute = System.nanoTime();
		
		Long startHorner = System.nanoTime();
		System.out.println("Horner: " + a.calculateHorner());
		Long endHorner = System.nanoTime();
		
		System.out.println("Brute: " + (endBrute - startBrute));
		System.out.println("Horner: " + (endHorner - startHorner));	
	}
}
