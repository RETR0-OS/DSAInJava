import java.util.Arrays;

public class SelectionSortImplementation{
    public static void main(String[] args){
        int[] arr = {1,109,984, 38, 37, 373, 10};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr){
        int max_idx = 0;
        int sorted_idx = arr.length;
        while (sorted_idx > 1){
            for(int j=0; j<sorted_idx;j++){
                if(arr[j] > arr[max_idx]){
                    max_idx = j;
                }
            }
            int temp = arr[max_idx];
            arr[max_idx] = arr[sorted_idx-1];
            arr[sorted_idx-1] = temp;
            max_idx = 0;
            sorted_idx--;
        }
    }
}