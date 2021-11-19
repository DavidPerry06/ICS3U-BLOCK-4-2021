package week11;

public class SortingAlgorithms {
    public static void main(String[] args) {
        
    
    int[] arr = { 80, 95, 10, 60, 35, 10, 25};

    //selectionSort(arr);
    InsertionSort(arr);
    }

    private static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {  //sort the next element
            int j = i;
            int temp = arr[i];
            for (j = i; j > 0 && temp<arr[j-1]; j--) {  //shifting is done
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {  //sort the next element
            int smallestIndex = i;
            for(int j = i+1; j < arr.length; i++){    //where is the smallest
                if(arr[j]<arr[smallestIndex]){
                    smallestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
}
