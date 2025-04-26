import java.util.Arrays;

public class QuickSortImplementation{
    public static void main(String[] args) {
        int[] arr = {1,5,82,2,0,0,-1, 89, 90,100, 32};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int low, int high){
        int partition = high;
        int j = low -1;

        for(int i=low; i<high; i++){
            if(arr[i] < arr[partition]){
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[j+1];
        arr[j+1] = arr[high];
        arr[high] = temp;

        return j+1;

    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int partition_idx = partition(arr, low, high);

            quickSort(arr, low, partition_idx-1);
            quickSort(arr, partition_idx+1, high);
        }
    }
}