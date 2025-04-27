
import java.util.Arrays;

public class MergeSortImplementation{
    public static void main(String[] args) {
        int[] arr = {1,109,984, 38, 37, 373, 10};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] merge(int[] a, int[] b){
        int[] arr = new int[a.length + b.length];

        int g_idx = 0;
        int a_idx = 0;
        int b_idx = 0;

        while(a_idx < a.length && b_idx < b.length){
            if(a[a_idx] < b[b_idx]){
                arr[g_idx] = a[a_idx];
                a_idx++;
            }
            else{
                arr[g_idx] = b[b_idx];
                b_idx++;
            }
            g_idx++;
        }

        while (a_idx < a.length){
            arr[g_idx] = a[a_idx];
            g_idx++;
            a_idx++;
        }
        while (b_idx < b.length){
            arr[g_idx] = b[b_idx];
            g_idx++;
            b_idx++;
        }

        return arr;
    }

    private static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int[] l1 = new int[arr.length / 2];
        int[] l2 = new int[arr.length - arr.length / 2];
        for(int i =0; i<l1.length; i++){
            l1[i] = arr[i];
        }
        for(int i =0; i<l2.length; i++){
            l2[i] = arr[(arr.length/2) +i];
        }

        return merge(mergeSort(l1), mergeSort(l2));
    } 
}