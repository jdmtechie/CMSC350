/*
 * file: TestPolyVal.java
 * author: James Moore
 * 
 */
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class TestPolyVal {
	static int arrSize = 3;
	static int x;
	static int[] polyArray;
	
	public static void main(String[] args) {
		//generate array with random integers -9 thru 9
		polyArray = new int[arrSize];
		for(int i = 0; i < polyArray.length; i++)
			polyArray[i] = ThreadLocalRandom.current().nextInt(-9, 9 + 1);
		
		//generate random value from 1 to 9 for integer x
		x = ThreadLocalRandom.current().nextInt(1, 9 + 1);
		
		//print some shit
		int degree = 0;
		int coefficient = 0;
		String polyString = "";
		for(int i = polyArray.length - 1; i >= 0; i--) {
			degree = i;
			coefficient = polyArray[i];
			if(i == polyArray.length - 1 && coefficient != 0) {
				polyString += coefficient + "n^" + degree;
			} else if(i < polyArray.length -1 && coefficient > 0) {
				polyString += " + " + coefficient + "n^" + degree;
			} else if(i < polyArray.length -1 && coefficient < 0) {
				polyString += " - " + (coefficient * -1) + "n^" + degree;
			} else if(i < polyArray.length -1 && coefficient == 0){
				polyString += " + " + coefficient;
			} else {
				polyString += coefficient;
			}
		}
		
		System.out.println(polyString);
		System.out.println("");
		System.out.println("x = " + x);
		System.out.println("The coefficients are: " + Arrays.toString(polyArray));
		System.out.println("");
		calculateBruteForce(polyArray, x);
		//System.out.println(equation);
		
	}
	
	public static void calculateBruteForce(int[] arr, int xVal) {
		int polyVal = 0;
		String polyValStr = "";
	
		for(int i = 0; i <= arr.length - 1; i++) {
			if(i == 0) {
				polyVal += arr[i];
				polyValStr += " " + arr[i] + " ";
			} else if(arr[i] == 0) {
				polyVal += 0;
				polyValStr += " 0 ";
			} else {
				int raised = 0;
				for(int n = 0; n <= i - 1; n++) {
					raised += xVal*xVal;
				} 
				
				polyVal += raised;
				polyValStr += " " + xVal + " ";
			}
		}
		
		System.out.println(polyVal);
		System.out.println(polyValStr);
	}
	
	public static void raiseToPower(int[] args) {
		
	}
	
}
