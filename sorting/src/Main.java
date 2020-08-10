// java programs by Eric Adamian
// sorting algorithms
// implementation through insertion sort, merge sort, and 3 forms of quicksorts

public class Main{
	public static void main(String[] args){

		Main format = new Main();
		InsertionSort is = new InsertionSort();
		MergeSort ms = new MergeSort();
		Quicksort1 qs1 = new Quicksort1();
        Quicksort2 qs2 = new Quicksort2();
        Quicksort3 qs3 = new Quicksort3();

		// unsorted array (output1.txt test)
        int[] array = {64, 52, 11, 5, 26, 63, 12, 93, 31, 65, 19, 23};

        // unsorted array (output2.txt test)
        // 32 elements for handling subarrays where n >= 16
		// int[] array = {24, 61, 90, 54, 62, 57, 179, 12, 41, 52, 36, 73, 22, 73, 4, 62, 91, 14, 42, 95, 57, 18, 72, 18, 26, 20, 28, 59, 37, 12, 29, 36, 83, 72, 89}; 

        System.out.println();
        System.out.println("*******************************************************************************");
        System.out.println("\tSorting algorithms testing results (contains hardcoded values)");
        System.out.println("\t\tRuntime completed with 2^16 iterations");
        System.out.println("*******************************************************************************");

		// *********************************************
        // insertion sort 
        System.out.println("\nInsertion Sort");

        // printing our sorted array
        System.out.print("Sorted array: \t");
        is.insertionsort(array.length - 1, array); 
        format.spacing(array);

        // start time
        long startTime = System.nanoTime();

        // iterating through our array 2^16 times
        for(int i = 0; i < 65535; i++){
            is.insertionsort(array.length - 1, array); 
        }

        // end time
        long endTime = System.nanoTime();

        // calculating runtime (nanoseconds to milliseconds)
        System.out.println("Runtime:\t" + ((double)(endTime - startTime) / 1000000) + " ms");

        // *********************************************
        // merge sort
        System.out.println("\nMerge Sort");

        System.out.print("Sorted array: \t");
        ms.mergesort(0, array.length - 1, array);
        format.spacing(array);

        startTime = System.nanoTime();

        for(int i = 0; i < 65535; i++){
            ms.mergesort(0, array.length - 1, array); 
        }

        endTime = System.nanoTime();

        System.out.println("Runtime:\t" + ((double)(endTime - startTime) / 1000000) + " ms");

  		// *********************************************
        // quicksort 1
        System.out.println("\nQuicksort1");

        System.out.print("Sorted array: \t");
        qs1.quicksort1(0, array.length - 1, array);
        format.spacing(array);

        startTime = System.nanoTime();

        for(int i = 0; i < 65535; i++){
            qs1.quicksort1(0, array.length - 1, array); 
        }

        endTime = System.nanoTime();

        System.out.println("Runtime:\t" + ((double)(endTime - startTime) / 1000000) + " ms");

        // *********************************************
        // quicksort 2
        System.out.println("\nQuicksort2");

        // printing out sorted array
        System.out.print("Sorted array: \t");
        qs2.quicksort2(0, array.length - 1, array);
        format.spacing(array);

        startTime = System.nanoTime();

        for(int i = 0; i < 65535; i++){
            qs2.quicksort2(0, array.length - 1, array); 
        }

        endTime = System.nanoTime();

        System.out.println("Runtime:\t" + ((double)(endTime - startTime) / 1000000) + " ms");

        // *********************************************
        // quicksort 3
        System.out.println("\nQuicksort3");

        System.out.print("Sorted array: \t");
        qs3.quicksort3(0, array.length - 1, array);
        format.spacing(array);

        startTime = System.nanoTime();

        for(int i = 0; i < 65535; i++){
            qs3.quicksort3(0, array.length - 1, array); 
        }

        endTime = System.nanoTime();

        System.out.println("Runtime:\t" + ((double)(endTime - startTime) / 1000000) + " ms");
	}


	// spacing for array
	public void spacing(int[] array){
		for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " "); 
		}
        	System.out.println();
	}
}