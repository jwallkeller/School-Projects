package keller_project4;

/**
 *
 * @author Jack Keller
 */
public class MergeSort extends Thread {

    private int[] arr1;
    private int[] arr2;
    private int[] output;

    public MergeSort(int[] arr, int[] arr2) {
        this.arr1 = arr;
        this.arr2 = arr2;
        output = new int[arr.length + arr2.length];
    }
    
    private void merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        
        for(int k = 0; k < output.length; k++) {
            if(i == arr1.length) {
                output[k] = arr2[j];
                j++;
            } else if(j == arr2.length) {
                output[k] = arr1[i];
                i++;
            } else if(arr1[i] > arr2[j]) {
                output[k] = arr2[j];
                j++;
            } else {
                output[k] = arr1[i];
                i++;
            }
        }
    }

    public int[] getOutput() {
        return output;
    }
    
    @Override
    public void run() {
        merge(arr1,arr2);
    }

}
