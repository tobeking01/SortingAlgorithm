import java.util.Arrays;

/**
 * @author Tobechi Onwenu
 **************************
 *         Programming Assignment 6 Sorting Algorithm
 *******************************************************        
 *         Bubble sort: A Quadratic Algorithm than checks an Unsorted collection from the bigger to Lowest value and swap from left to right to Sort through a collection of Objects. 
 *         Selection sort: A Quadratic Algorithm that Selects the first value in index 0 of an Unsorted collection and checks the bigger value swapping from left to right to sort a collection.
 *         Insertion sort: A Quadratic Algorithm that grabs the second index Unsorted an checks with the first value in the index Sorted and continuously swaps bigger objects in the collection.
 *         Shell Sort: A Quadratic Algorithm that uses a formula to calculate a Gap to use as Index in trying to sort an Unsorted collection. 
 *         Merge Sort: A logarithm Algorithm that take two values side by side and Sorts them, the recursive call is best for this sort algorithm.
 *         Quick Sort: A logarithm Algorithm that Sorts using a pivotIndex and sorts based on its value.
 *         Array Sort: A logarithm Algorithm that uses java JDK to sort. Fast and stable.
 *         
 	* Big O Notations
 	******************
	* O(1) Constant (Best) 
	* O(logn) Logarithm 
	* O(n) Linear 
	* O(nlogn) nlog-star n 
	* O(nsquare) Quadratic (Worst)
	*
	* Time Complexity in Arrays
	**************************** 
	* 1. In an Array if the Code has to loop over an
	* array to complete a task then it has Linear time complexity O(n)
	* 
	* 2. In an Array if the Code has no loop to complete a task then it has
	* Constant time Complexity O(1)
	* 
	*
 */

public class SortingAlgorithm {

	private Sorting[] array;
	private int numItems;

	public SortingAlgorithm(int maxItems) {
		array = new Sorting[maxItems];
		numItems = 0;
	}

	public void insert(Sorting objectToAdd) {
		array[numItems++] = objectToAdd;
	}

	public int size() {
		return numItems;
	}
	/**
	 * Bubble Sort
	 ***************
	 * In-place algorithm time complexity - quadratic
	 * 
	 * It will take 100 steps to sort 10 items, 10,000 steps to sort 100
	 * items, 1,000,000 steps to sort 1000 items. Algorithm Degrades quickly
	 * 
	 * Doesn't require as much swapping as bubble sort
	 * 
	 * It's unstable algorithm because you sort the greatest with the last element
	 * which can be a duplicate of the largest
	 */
	
	public void bubbleSort() {
		for (int lastUnsortedIndex = numItems - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) { 	// loop from the end of the array to the beginning backwards (First n)
			for (int i = 0; i < lastUnsortedIndex; i++) { 											// loop through all and again forwards (Second n)
				if (array[i].compareTo(array[i + 1]) > 0) {											// if values at i greater than last its next index
					swap(array, i, i + 1);															//	swap both value contents
				}
			} 																						
		}																							// Return result when called. Final Complexity is Quadratic nsquare
	}

	/**
	 * Selection Sort
	 *****************
	 * In-place algorithm time complexity - quadratic
	 * 
	 * It will take 100 steps to sort 10 items, 10,000 steps to sort 100
	 * items, 1,000,000 steps to sort 1000 items Algorithm Degrades quickly
	 * 
	 * Doesn't require as much swapping as bubble sort
	 * 
	 * It's unstable algorithm because you sort the greatest with the last element
	 * which can be a duplicate of the largest
	 */

	public void selectionSort() {
		for (int lastUnsortedIndex = numItems - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) { 	// loop trough from end to beginning (first n)
			int largest = 0;																	 	// element at index 0 is Selected as max in the array as it is the first known element
			for (int i = 1; i <= lastUnsortedIndex; i++) { 											// loop trough from beginning to end (second n)
				if (array[i].compareTo(array[largest]) > 0) {										// find the largest
					largest = i;																	// allocate the largest to value found
				}
			}
			swap(array, largest, lastUnsortedIndex);												// swap the values found and continue loop
		}																							
	}																								// Return the result when called. Final Complexity is Quadratic nsquare
	
	/**
	 * Insertion Sort
	 *****************
	 * In-place algorithm
	 * 0(nsquare) time complexity - quadratic
	 * It will take 100 steps to sort 10 items, 10,000 steps to sort 100
	 * items, 1,000,000 steps to sort 1000 items. Algorithm Degrades quickly
	 * 
	 * 	Stable algorithm
	 */
	
	public void insertionSort() {
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < numItems; firstUnsortedIndex++) { 	// Takes the item in index 1 and allocates it to firstChoiceIndex
			Sorting newElement = array[firstUnsortedIndex];											// store the firstChoiceIndex in a newElement to be returned later
			int i; 																					// i is established out of loop as it is being used again outside innerLoop
			for (i = firstUnsortedIndex; i > 0 && array[i -1].compareTo(newElement) > 0; i--) {		// if values[i] not 0 and not greater than values[firstUnsortedIndex element] go backwards
				array[i] = array[i - 1];															// if found make values[i] value[i-1]
			}
			array[i] = newElement; 																	// put newElent in position i 
		}																							// Return result when called.
	}
	
	/**
	 * Shell Sort
	 *************
	 * In-place algorithm
	 * Difficult to nail down the time complexity because it will depend on the gap. Worst case: 0(nsquared), but it can
	 * perform much better than that
	 * 
	 * Doesn't require as much shifting as insertion sort, so it usually performs better
	 * 
	 * It improves on Bubble Sort and Insertion Sort
	 * Unstable Algorithm
	 * 
	 */
	public void shellSort() {
		for(int gap = numItems/2; gap > 0; gap /= 2) { 												// loop using Gap(length/2) of the collection and continue with half/gap 
			for (int i = gap; i < numItems; i++) {													// loop again through all values in the collection
				Sorting newElement = array[i];														// Store value[i] which is length/2 of every iteration
				int j = i;																			// store i to int j 
				while (j >= gap && array[j - gap].compareTo(newElement) > 0) {						// using j: if >= to gap && j - gap(half/length) is greater than element Stored 
					array[j] = array[j - gap];														// swap
					j -= gap;																		// exit loop
				}
				array[j] = newElement;																// put newElement in position j.
			}
		}																							// return result. 
	}

	/**
	 * Merge Sort
	 *************
	 *
	 *Not an in-place algorithm
	 *
	 *0(nlogn) - base2. We're repeatedly dividing the array in half during the splitting phase
	 *
	 *Stable algorithm
	 */
	
	public void mergeSort() {
		int start = 0;
		int end = numItems;
		mergeSort(array, start, end);																// calling the mergeSort Method 
	}
	
	private void mergeSort(Sorting[] mergeItem, int start, int end) {		
		if(start == 0) {																			// Base Case: if start index is at 0. 
			return;
		}		
		int mid = numItems/2;																		// get midpoint
		mergeSort(mergeItem, start, mid);															// recursive for start and mid
		mergeSort(mergeItem, mid, end);																// recursive for mid and end
		merge(mergeItem, start, mid, end);															// merge all
	}

	private void merge(Sorting[] mergeItem, int start, int mid, int end) {
		if(mergeItem[mid - 1].compareTo(mergeItem[mid]) <= 0) {										// Base case: If what is behind mid and mid is less than or equal 
		return;
		}
		int tempIndex = 0; 																			//beginning index to hold temp object
		Sorting[] temp = new Sorting[numItems];														// create a temp Sorting Array object to hold all values 
		while(start < mid && mid < end) {															// while 
			temp[tempIndex++] = mergeItem[start].compareTo(mergeItem[mid]) < 0 ? mergeItem[start++] : mergeItem[mid++];	// from small to big merge from start++ to mid++
		}
		System.arraycopy(mergeItem, start, mergeItem, start + tempIndex, mid - start);				// arraycopy: source, startingPosition, Destination, destinationPosition, length
		System.arraycopy(temp, 0, mergeItem, start, tempIndex);										// arraycopy: source, startingPosition, Destination, destinationPosition, length 
	}
	
	/**
	 * Quick Sort
	 *************
	 *
	 *In-place Algorithm
	 *
	 *0(nlogn) - base 2. We're repeatedly partitioning the array in two halves
	 *
	 *Unstable algorithm
	 *
	 */
	public void quickSort() {
		int start = 0;
		int end = numItems;
		quickSort(array, start, end);																
	}

	private void quickSort(Sorting[] quickSearchItem, int start, int end) {
		if (start == 0) {																			// Base case: at index 0
			return;
		}
		int pivotIndex = partition(quickSearchItem, start, end);									// calling the partition method to get pivotIndex
		quickSort(quickSearchItem, start, pivotIndex);												// recursive left side
		quickSort(quickSearchItem, pivotIndex + 1, end);											// recursive right side
	}

	private int partition(Sorting[] quickSearchItem, int start, int end) {
		Sorting pivot = quickSearchItem[start];														// storing pivot 
		while( start < end) {
			while (start < end && quickSearchItem[--end].compareTo(pivot) >= 0); 					// Note: Empty loop to traverse forward based on the greater objects from pivot
			if (start < end) {
				quickSearchItem[start] = quickSearchItem[end];										// swap
			}
			
			while (start < end && quickSearchItem[++start].compareTo(pivot) <= 0);					// Note: Empty loop to traverse backward based on the lesser objects from pivot
			if (start < end) {
				quickSearchItem[end] = quickSearchItem[start];										// swap
			}
		}
		quickSearchItem[end] = pivot;																//return result.
		return end;
	}
	
	/**
	 * Array Sort
	 **************
	 * Uses the DualPivotQuickSorce.sort method
	 * 
	 * 0(nlog n) performance and doesn't degrade like quick sort does, and its typically faster
	 * 
	 * stable Algorithm
	 */
	
	public void arraySort() {
		if (numItems == 0 ) { 																		// checking for null
			Arrays.sort(array);
		}
	}

	public String toString() {
		String temp = "";
		temp += "Name \t\t Price \t\t Number \n";
		temp += "*********************************************\n";
		for (int i = 0; i < numItems; i++) {
			temp += array[i] + "\n";
		}
		return temp;
	}

	// swap Algorithm
	private void swap(Sorting[] array, int i, int j) {
		if (i == j) {
			return;
		}
		Sorting temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
