// insertion sort class

public class InsertionSort{
    
    public void insertionsort(int high, int[] array){
        int low, j;
        int target;

        // sorting through entire array
        for(low = 2; low <= high; low++){

            // setting our target as low
            target = array[low];
            j = low - 1;

            // moving elements greater than target
            // ahead of current position
            while(j >= 0 && array[j] > target){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = target;
        }
    }

}