import java.util.*;

public class EC_1 {

	public static void main(String[] args) {
		// Create objects for the program
		Scanner scnr = new Scanner(System.in);
		EC_1 ec = new EC_1();
		
// Question 1
		
		// Request the user to input a binary array
		System.out.println("Enter a random binary array: ");
		
		// Save the input of the user
		String input = scnr.nextLine();
		
		// Create an array with the length of the user
		int[] a = new int[input.length()];
		
		// Get each element from the user input and put it into an int array
		for (int i = 0; i < input.length(); i++) {
			a[i] = Integer.parseInt(Character.toString(input.charAt(i)));
		}
				
		// Call Find First One Method to find the index of the first one in the array
		int result = ec.findFirstOne(a);
		
		// Output the result of Question 1
		System.out.println("The index of the first 1 found from the array " + Arrays.toString(a) + " is: " + result);
		
// Question 2
		
		// EXAMPLE 1:
		// Create the arrays for Example 1
		int[] a1 = {0, 2, 10, 26, 68};
		int[] b1 = {1, 11, 18, 20, 41};
		
		// Get the first and last elements / index 
		int firstElem = 0;
		int lastElem = a1.length - 1;
		
		// Call the Find Median method to find the median of the merged array
		double result1 = ec.findMedian(a1, b1, firstElem, lastElem);
		
		// Output the result of example 1
		System.out.println("The calculated merged median is: " + result1);
		
		// EXAMPLE 2:
		// Create the arrays for Example 2
		int[] a2 = {5, 6, 14, 26};
		int[] b2 = {3, 41, 88, 100};
		
		// Get the first and last elements / index 
		firstElem = 0;
		lastElem = a2.length - 1;
		
		// Call the Find Median method to find the median of the merged array
		double result2 = ec.findMedian(a2, b2, firstElem, lastElem);
		
		// Output the result of example 2
		System.out.println("The calculated merged median is: " + result2);
		
		// EXAMPLE 3:
		// Create the arrays for Example 3
		int[] a3 = {5, 10};
		int[] b3 = {2, 41};
		
		// Get the first and last elements / index 
		firstElem = 0;
		lastElem = a3.length - 1;
		
		// Call the Find Median method to find the median of the merged array
		double result3 = ec.findMedian(a3, b3, firstElem, lastElem);
		
		// Output the result of example 3
		System.out.println("The calculated merged median is: " + result3);
		
	}
	
// QUESTION 1:
	// Find the index of the first 1
	public int findFirstOne(int[] a) {
		int midIdx = 0;
		int lowIdx = 0;
		int highIdx = a.length - 1;
		
		while (highIdx >= lowIdx) {
			midIdx = (highIdx + lowIdx) / 2;
			
			// Base case: If the first 1 is located at the middle of the array
			if (a[midIdx] == 1 && (midIdx == 0 || a[midIdx - 1] == 0)) { 
				return midIdx;
				
			// The first 1 is located to the left of the midIdx
			} else if (a[midIdx] == 1) { 
				highIdx = midIdx -1;
				
				// The first 1 is located to the right of the midIdx
			} else {
				lowIdx = midIdx + 1; 
			}
		}
		// Return -1 if there are no 1's within the array
		return -1; 
	}
	
// QUESTION 2:
	// Find Median Method
	public double findMedian(int[] a, int[] b, int firstElem, int lastElem) {
		
		// Variable to store the merged median
		double mergedMedian = 0;
		
		// Get the length of the array
		int arrayLength = a.length;
		
		// If the length of both arrays is 1 (EXAMPLE 3)
		if (a.length == 2 && b.length == 2) {
			
			// Find the max of the first elements in the arrays
			double max = Math.max(a[0], b[0]);
			
			// Find the min of the second elements in the arrays
			double min = Math.min(a[1], b[1]);
			
			return (max + min) / 2;
		}
		
		// Call calcMedian method to find the median of the 2 arrays
		double a_Median = calcMedian(a, firstElem, lastElem);
		double b_Median = calcMedian(b, firstElem, lastElem);
		
		// If the length of both arrays is even
		if (arrayLength % 2 == 0) {
			mergedMedian = ((a_Median) + (b_Median)) / 2;
			
		// Else, the array has an odd length
		} else {
			mergedMedian = (a_Median / 2) + (b_Median / 2);
		}
		
		// Return the calculated merged median
		return mergedMedian;
	}
	
	// Calculate Median Method
	public double calcMedian(int[] array, int firstElem, int lastElem) {
		
		// Finds the length of the array
		int arrayLength = array.length;
		
		// Checks if the array length is even
		if (arrayLength % 2 == 0) {
			
			// Calculated the left median element
			int leftMedian = array[arrayLength / 2];
			
			// Calculated the right median element
			int rightMedian = array[(arrayLength - 1) / 2];
			
			// Add the left and right medians and return the calculated value
			return (leftMedian + rightMedian) / 2;
			
		// Else, the array has an odd length	
		} else {
			
			// Return the median if the array has an odd length
			return array[arrayLength / 2];
		}		
	}	
}

// Justin Calma CECS 328 - 14 F 8 AM - 12:45 PM