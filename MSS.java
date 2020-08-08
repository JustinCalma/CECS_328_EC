import java.util.*;

public class MSS {
	
	public static void main(String[] args) {
		
		// Creates objects for program
		Scanner scnr = new Scanner(System.in);
		MSS mss = new MSS();
		
		// Requests the user for the desired array length
		System.out.println("Enter the desired size of the array: ");
		
		// Gets the users input
		int n = scnr.nextInt();
		
		// Creates an array of the desired length
		int[] a = new int[n];
				
		// Generate random integers between the given range
		for (int i = 0; i < n; i++) {
			int randNum = -100 + (int)(Math.random() * (101 - -100));
			a[i] = randNum;
		}
		
		// Create a clone of array a
		int[] b = a.clone();
		
		// Find the length of array b
		int b_Length = b.length - 1;
		
		// Variable for the left side of the array
		int left = 0;
		
		// Variable for the right side of the array
		int right = a.length - 1;
		
		// Call MSS_Recursive and save the result into a variable
		int a_Result = mss.MSS_Recursive(a, left, right);
		
		// Call MSS_Linear and save the result into a variable
		int b_Result = mss.MSS_Linear(b, b_Length);
		
		// Output the result of the MSS_Recursive algorithm
		System.out.println("The MSS of the array: " + Arrays.toString(a) + " using MSS Recursive is: " + a_Result);
		
		// Output the result of the MSS_Linear algorithm
		System.out.println("The MSS of the array: " + Arrays.toString(b) + " using MSS Linear is: " + b_Result);
		
	}
	
	// MSS Linear Method
	public int MSS_Linear(int[] b, int b_Length) {
		int max_Sum = 0;
		
		// Iterate through the entire array
		for (int i = 0; i < b_Length; i++) {
			int this_Sum = 0;
			
			// Each iteration find the sum of the known elements
			for (int j = i; j < b_Length; j++) {
				this_Sum += b[j];
				
				// If the calculated sum is greater than the current max sum then become new max sum
				if(this_Sum > max_Sum) {
					max_Sum = this_Sum;
				}
			}
		}
		
		// Return the final max sum
		return max_Sum;
	}
	
	// MSS Recursive Method
	public int MSS_Recursive (int[] a, int left, int right) {
		// Base case 1
		if (right == left) {
			return a[left];
		}
		
		int mid = (left + right) / 2;
		
		// Find MSS of left array
		int MSS_Left = MSS_Recursive (a, left, mid);
		
		// Find MSS of right array
		int MSS_Right = MSS_Recursive (a, mid + 1, right);
		
		int MSS_Middle = MSS_MidRecursive (a, left, mid, right);
		
		return Math.max(Math.max(MSS_Left, MSS_Right), MSS_Middle);
		
	}
	
	// MSS Middle Recursive Method
	public int MSS_MidRecursive (int[] a, int left, int mid, int right) {
		
		// Temp variable to store the max sum of the left array
		int max_left_sum = -999;
		
		// Variable to store the current sum
		int sum = 0;
		
		// Variable to find the correct index to get each element
		int i;
		
		// Find the maximum sum from the left side of the array
		for (i = mid; i >= left; i--) {
			sum += a[i];
			
			// If the current sum is greater than the max found sum then become new max sum
			if (sum > max_left_sum) {
				max_left_sum = sum;
			}
		}
		
		// Temp variable to store the max sum of the right array
		int max_right_sum = -999;
		
		// Variable to store the current sum
		sum = 0;
		
		// Find the maximum sum of the right side of the array
		for (i = mid + 1; i <= right; i++) {
			sum += a[i];
			
			// If the current sum is greater than the max found sum then become new max sum
			if (sum > max_right_sum) {
				max_right_sum = sum;
			}
		}
		
		// Return the sum between the max sums of the left and right sides of the array
		return max_left_sum + max_right_sum;
		
	}
	
}
