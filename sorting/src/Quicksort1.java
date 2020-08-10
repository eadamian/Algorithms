// quicksort with partition class

public class Quicksort1{

    public void quicksort1(int low, int high, int[] array){
        int pivotpoint;

        // partitioning our array, recursively calling quicksort 1
        if(high > low){
            pivotpoint = partition(low, high, array);
            quicksort1(low, pivotpoint - 1, array);
            quicksort1(pivotpoint + 1, high, array);
        }
    }


    public int partition(int low, int high, int[] array){
        int i, j;
        int pivotitem, pivotpoint;

        // choosing first item for pivotitem
        pivotitem = array[low];
        j = low;

        // sorting through array
        for(i = low + 1; i <= high; i++){
            if(array[i] < pivotitem){
                j++;

                // exchange array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        pivotpoint = j;

        // exchange array[low] and array[pivotpoint]
        int temp = array[low];
        array[low] = array[pivotpoint];
        array[pivotpoint] = temp;

        return pivotpoint;
	}
}