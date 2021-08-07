
/**
 * @author Tobechi Onwenu
 * Main Driver Class
 *
 */
public class SortingAlgorithmDriver {

	public static void main(String[] args) {

		Sorting sort0 = new Sorting("Table", 23.45, 22);
		Sorting sort1 = new Sorting("Chair", 12.23, 44);
		Sorting sort2 = new Sorting("Beds", 150.45, 50);
		Sorting sort3 = new Sorting("Sceens", 125.89, 34);
		Sorting sort4 = new Sorting("Fridge", 55.76, 15);
		Sorting sort5 = new Sorting("Vacuum", 34.22, 39);
		Sorting sort6 = new Sorting("Stand", 13.85, 23);
		Sorting sort7 = new Sorting("Mirror", 10.83, 47);
		Sorting sort8 = new Sorting("Fans", 15.75, 77);
		Sorting sort9 = new Sorting("Mops", 8.95, 60);
		Sorting sort10 = new Sorting("Bottle", 5.76, 87);
		Sorting sort11 = new Sorting("Water", 11.82, 101);
		
		SortingAlgorithm array = new SortingAlgorithm(12);
		array.insert(sort0);
		array.insert(sort1);
		array.insert(sort2);
		array.insert(sort3);
		array.insert(sort4);
		array.insert(sort5);
		array.insert(sort6);
		array.insert(sort7);
		array.insert(sort8);
		array.insert(sort9);
		array.insert(sort10);
		array.insert(sort11);

		// Table print
		System.out.println("Table Data");
		System.out.println("***************** ");
		System.out.println(array);

		// Calculating time for Bubble Sort
		System.out.println("\nBubble Sorted");
		long startBubble = System.nanoTime();
		array.bubbleSort();
		long endBubble = System.nanoTime();
		System.out.println(array);
		long elapsedBubble = endBubble - startBubble;
		System.out.println("Elapsed Time is: " + elapsedBubble + "ms");

		// Calculating Time for Selection Sort
		System.out.println("\nSelection Sort");
		long startSelection = System.nanoTime();
		array.selectionSort();
		long endSelection = System.nanoTime();
		System.out.println(array);
		long elapsedSelection = endSelection - startSelection;
		System.out.println("Elapsed Time is: " + elapsedSelection + "ms");

		// Calculating Time for Insertion Sort
		System.out.println("\nInsertion Sort");
		long startInsertion = System.nanoTime();
		array.selectionSort();
		long endInsertion = System.nanoTime();
		System.out.println(array);
		long elapsedInsertion = endInsertion - startInsertion;
		System.out.println("Elapsed Time is: " + elapsedInsertion + "ms");
		
		// Calculating Time for Shell Sort
		System.out.println("\nShell Sort");
		long startShell = System.nanoTime();
		array.shellSort();
		long endShell = System.nanoTime();
		System.out.println(array);
		long elapsedShell = endShell - startShell;
		System.out.println("Elapsed Time is: " + elapsedShell + "ms");
		
		// Calculating Time for Shell Sort
		System.out.println("\nMerge Sort");
		long startMerge = System.nanoTime();
		array.mergeSort();
		long endMerge = System.nanoTime();
		System.out.println(array);
		long elapsedMerge = endMerge - startMerge;
		System.out.println("Elapsed Time is: " + elapsedMerge + "ms");
		
		// Calculating Time for Quick Sort
		System.out.println("\nQuick Sort");
		long startQuick = System.nanoTime();
		array.quickSort();
		long endQuick = System.nanoTime();
		System.out.println(array);
		long elapsedQuick = endQuick - startQuick;
		System.out.println("Elapsed Time is: " + elapsedQuick + "ms");		
		
		// Calculating Time for Array Sort
		System.out.println("\nArray Sort");
		long startArray = System.nanoTime();
		array.arraySort();
		long endArray = System.nanoTime();
		System.out.println(array);
		long elapsedArray = endArray - startArray;
		System.out.println("Elapsed Time is: " + elapsedArray + "ms");

	}

}
