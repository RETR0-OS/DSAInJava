import java.util.Arrays;

class InPlaceMergeSort{
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void merge(int[] arr, int s, int m, int e){
        int i = s;
        int j = m;
        int count=0;
        while (i<m && j<e){
            if (arr[i] < arr[j]){
                int temp = arr[s+count];
                arr[s+count] = arr[i];
                arr[i] = temp;
                i++;
            }
            else if(arr[i] > arr[j]){
                int temp = arr[s+count];
                arr[s+count] = arr[j];
                arr[j] = temp;
                j++;
            }
            else{
                int temp = arr[s+count];
                arr[s+count] = arr[i];
                arr[i] = temp;
                i++;
                count++;
                temp = arr[s+count];
                arr[s+count] = arr[j];
                arr[j] = temp;
                j++;
            }
            count++;
        }
        while(j < e){
            int temp = arr[s+count];
            arr[s+count] = arr[j];
            arr[j] = temp;
            count++;
            j++;
        }
        while(i < m){
            int temp = arr[s+count];
            arr[s+count] = arr[i];
            arr[i] = temp;
            count++;
            i++;
        }
    }

    private static void sort(int[] arr, int s, int e){
        if (e-s ==1){
            return;
        }
        sort(arr, s, (s+e)/2);
        sort(arr, ((s+e)/2), e);
        merge(arr, s,(s+e)/2,e);
    }
}