// quicksort with randomizer class

import java.util.Random;

public class Quicksort3{

    public void quicksort3(int low, int high, int[] array){
        Quicksort1 qs1 = new Quicksort1();
        Random random = new Random();

        // randomizer will select a random element
        // instead of first element as pivot item
        int pivotpoint;
        int size = (high - low);
        int randomizer;

        // invoke randomizer for more than 16 elements
        // swaps array[low] for array[random index between high and low]
        if(size > 16){
            randomizer = (low + (random.nextInt(size)));
            int temp = array[low];
            array[low] = array[randomizer];
            array[randomizer] = temp;
        }

        // otherwise, call our partition and recursively quicksort
        if(high > low){
            pivotpoint = qs1.partition(low, high, array);
            quicksort3(low, pivotpoint - 1, array);
            quicksort3(pivotpoint + 1, high, array);
        }
    }
}