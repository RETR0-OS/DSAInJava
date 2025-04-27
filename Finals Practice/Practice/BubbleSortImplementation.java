
import java.util.Arrays;

public class BubbleSortImplementation{
    public static void main(String[] args) {
        int[] arr = {1,109,984, 38, 37, 373, 10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}