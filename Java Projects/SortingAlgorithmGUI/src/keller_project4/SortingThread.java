
package keller_project4;

/**
 *
 * @author Jack Keller
 */
public class SortingThread extends Thread{
    private char selection;
    private int[] arr;
    private int lo;
    private int hi;
    
    
    public SortingThread(char selection, int[] arr) {
        this.selection = selection;
        this.arr = arr;
        this.lo = arr[0];
        this.hi = arr[arr.length - 1];
    }

    public int[] getArr() {
        return arr;
    }
    
    public static void SelectionSort(int[] arr) {
         for (int i = 0; i < arr.length; i++) {
            
            int smallestIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIdx]) {
                    smallestIdx = j;
                }
            }

            int temp = arr[smallestIdx];
            arr[smallestIdx] = arr[i];
            arr[i] = temp;
         }
    }
    
    public static void BubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
    
    public void QuickSort(int[] arr,int lo,int hi) {
        if(lo >= hi) {
            return;
        }
        
        int i = lo;
        int j = hi;

        int pivot = arr[lo + (hi - lo) / 2];

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if (lo < j) {
            QuickSort(arr,lo,j);
        }
        if (i < hi) {
            QuickSort(arr,i,hi);
        }
    }
    
    @Override
    public void run() {
        switch(selection) {
            case 's':
                SelectionSort(arr);
                break;
            case 'b':
                BubbleSort(arr);
                break;
            case 'i':
                InsertionSort(arr);
                break;
            case 'q':
                QuickSort(arr,lo,hi);
                break;
        }
    }
    
}
