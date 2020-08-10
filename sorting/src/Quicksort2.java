// quicksort with insertion sort class

public class Quicksort2{

    public void quicksort2(int low, int high, int[] array){
        InsertionSort is = new InsertionSort();
        Quicksort1 qs1 = new Quicksort1();

        int pivotpoint;
        int size = (high - low);

        // calling insertion sort for arrays OR subarrays (size 16 or less)
        // otherwise, recursively calling quicksort2
        if(size <= 16){
            is.insertionsort(high, array);
        }else if(high > low){
            pivotpoint = qs1.partition(low, high, array);
            quicksort2(low, pivotpoint - 1, array);
            quicksort2(pivotpoint + 1, high, array);
        }
    }
}