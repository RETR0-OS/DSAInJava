
import java.util.Arrays;

class QuickSort{
    public static void main(String[] args) {
        int[] a = {5,4,6, 7,1,0, 2};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr, int low, int high){
        if (low >= high){
            return;
        }
        int s = low;
        int e = high;
        int mid = (e + s) / 2;
        int pivot = arr[mid];
        
        while (s <= e){
            while (arr[s] < pivot){
                s++;
            }

            while(arr[e] > pivot){
                e--;
            }

            if (s <=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        sort(arr, low, e);
        sort(arr, s, high);
    }
}