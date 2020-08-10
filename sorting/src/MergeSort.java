// merge sort class

public class MergeSort{

    public void mergesort(int low, int high, int[] array){
        int mid;

        // recursively calling our mergesort
        // calling our merge method
        if(low < high){
            mid = (low + high) / 2;
            mergesort(low, mid, array);
            mergesort(mid + 1, high, array);
            merge(low, mid, high, array);
        }
    }


    private void merge(int low, int mid, int high, int[] array){
        // indexes of first subarray, second subarray, and merged subarray
        int i = low;
        int j = mid + 1;
        int k = 0;

        // temp array used for merging
        int[] temp = new int[(high - low) + 1];

        // sorting through our first/second subarray
        while(i <= mid && j <= high){
            if(array[i] < array[j]){
                temp[k] = array[i];
                i++;
            }else{
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        // move array[j] through array[high] to temp[k] through temp[high]
        if(i > mid){
        	while(j <= high){
				temp[k] = array[j];
				j++;
				k++;
    		}
    	// move array[i] through array[mid] to temp[k] through temp[high];
        }else{
        	while(i <= mid){
        		temp[k] = array[i];
        		i++;
        		k++;
        	}
        }

  		// move temp[low] through temp[high] to array[low] through array[high]
        for(k = 0, i = low; k <= high - low; i++){
        	array[i] = temp[k];
        	k++;
        }

	}
}