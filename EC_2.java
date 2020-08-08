import java.util.*;

public class EC_2 {
	
	public static void main(String[] args) {
		
		// Create Objects for program
		EC_2 sort = new EC_2();
		Scanner scnr = new Scanner(System.in);
		
		// Request the desired length from the user
		System.out.println("Enter the desired array length: ");
		
		int n = scnr.nextInt();
		
		// Create an array of the desired size
		int[] a = new int[n];
		
		// Create a clone of the array a
		int[] b = a.clone();
		
		long avgRunTimeQuick = 0; // Variable to save the average runtime per iteration for Quick Sort
		long avgRunTimeInsertion = 0; // Variable to save the average runtime per iteration for Insertion Sort
		
		for (int i = 0; i < 100; i++) { // Runs Quick Sort and Insertion Sort 100 times to calculate average runtime 
			a = sort.createArrays(n); // Creates a new random generated array
			b = a.clone(); // Creates a clone of array a
			
			int firstElem = 0; // Gets the first element / index of the array a
			int lastElem = a.length - 1; // Returns the last element / index of the array a 
						
			long startTimeQuick = System.nanoTime(); // Start timer for Quick Sort
			sort.quick_Sort(a, firstElem, lastElem); // Calls Quick Sort and sorts array a
			long endTimeQuick = System.nanoTime(); // End timer for Quick Sort
			
			long startTimeInsertion = System.nanoTime(); // Start timer for Insertion Sort
			sort.insertion_Sort(b); // Calls Insertion Sort and sorts array b
			long endTimeInsertion = System.nanoTime(); // End timer for Insertion Sort
			
			long durationQuick = endTimeQuick - startTimeQuick; // Calculate how long it takes for Quick Sort to complete
			long durationInsertion = endTimeInsertion - startTimeInsertion; // Calculate how long it takes for Insertion Sort to complete
			
			avgRunTimeQuick += durationQuick; // Keeps track of total runtime for Quick Sort
			avgRunTimeInsertion += durationInsertion; // Keeps track to total runtime for Insertion Sort
			
		}
				
		// Calc avg run time for Quick Sort
		System.out.println("Average - running time for Quick Sort in ns: " + avgRunTimeQuick / 100); 

		// Calc avg run time for Insertion Sort
		System.out.println("Average - running time for Insertion Sort in ns: " + avgRunTimeInsertion / 100); 
		
		
	}
	
	// Time Complexity: O(n log n)
	// Quick Sort Method
	public void quick_Sort(int[] a, int firstElem, int lastElem) {
		
		// Check if the first element in the array is greater than the last element
		if(firstElem >= lastElem) {
			
			// Call partition method to find the pivot 
			int pivot = partition(a, firstElem, lastElem);
			
			// Sort the left side of the array 
			quick_Sort(a, firstElem, pivot);
			
			// Sort the right side of the array 
			quick_Sort(a, pivot, lastElem);
		}
	}
	
	// Time Complexity: O(n^2)
	// Insertion Sort Method
	public void insertion_Sort(int[] b) {
		for (int i = 0; i < b.length; i++) {
			int next = b[i];
			
			// Move the larger elements to the end of the array
			int j = i;
			
			// Keep iterating until a larger element than the current has been found
			while((j > 0) && (b[j - 1] > next)) {
				b[j] = b[j - 1];
				j--;
			}
			
			// Insert the element into the sorted position
			b[j] = next;
		}
	}

	// Partition Method for Quick Sort
	public int partition(int[] a, int firstElem, int lastElem) { // O(n)
		EC_2 swapper = new EC_2();
		
		int pivot = a[firstElem];
		int i = firstElem - 1;
		int j = lastElem + 1;
		
		while (i < j) {
			i++;
			while (a[i] < pivot) { // Left pointer i starts at left of array and increases towards to pivot
				// start at beginning of array and move toward pivot
				i++;
			}
			
			j--;
			while (a[j] > pivot){ // Right pointer j starts at right of array and decrements towards pivot
				// start at end of array and move toward pivot
				j--;
			}
			
			// Call the swap method to swap the two values 	
			if (i < j) {
				swapper.swap(a, i, j);
				
			}		
		}
		
		return j; // Return the index of the median
		
	}
	
	// Helper function to swap two elements that need to be swapped 
	public void swap (int[] a, int x, int y) { // O(1)
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		
	}
	
	// Helper method to create random generated arrays of the desired length
	public int[] createArrays(int n) {
		int[] newArr = new int[n];
		
		for (int i = 0; i < n ; i++) { // Add random generated numbers from the range -100 to 100 into the array
			int randNum = -5000 + (int)(Math.random() * (5001 - -5000));
			newArr[i] = randNum;
		}
		
		return newArr;
		
	}
	
}
