import java.util.Arrays;

public class QuickSortImplementation{
    public static void main(String[] args) {
        int[] arr = {1,109,984, 38, 37, 373, 10};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int low, int high){
        int partition = arr[high];
        int j = low - 1;

        for(int i=low; i<high; i++){
            if (arr[i] < partition){
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[high];
        arr[high] = arr[j+1];
        arr[j+1] = temp;
        return j+1;
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int p_idx = partition(arr, low, high);
            quickSort(arr, low, p_idx-1);
            quickSort(arr,p_idx+1, high);
        }
    }
}