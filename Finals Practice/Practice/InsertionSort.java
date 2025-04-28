import java.util.Arrays;

public class InsertionSort{
    public static void main(String[] args) {
        int[] arr = {1,109,984, 38, 37, 373, 10};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr){
        if (arr.length <= 1){
            return;
        }
        int sort_idx = 1;
        while(sort_idx < arr.length){
            int i = sort_idx -1;
            int j = sort_idx;
            while(arr[i] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i--;
                j--;
            }
            sort_idx++;
        }
    } 
}