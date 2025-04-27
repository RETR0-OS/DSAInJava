import java.util.Arrays;

public class MergeSortImplementation{
    public static void main(String[] args) {
        int[] arr = {1,5,82,2,0,0,-1, 89, 90,100};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] sort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int[] l1 = new int[arr.length/2];
        int[] l2 = new int[arr.length - arr.length/2];

        for (int i=0; i<l1.length; i++){
            l1[i] = arr[i];
        }
        for (int i=0; i<l2.length; i++){
            l2[i] = arr[arr.length/2 + i];
        }
        int[] ans = merge(sort(l1), sort(l2));
        return ans;
    }
    
    private static int[] merge(int[] a1, int[] a2){
        int[] ans = new int[a1.length + a2.length];
        int g_idx = 0;
        int a_idx = 0;
        int b_idx = 0;

        while (a_idx < a1.length && b_idx < a2.length){
            if (a1[a_idx] < a2[b_idx]){
                ans[g_idx] = a1[a_idx];
                a_idx++;
            }
            else{
                ans[g_idx] = a2[b_idx];
                b_idx++;
            }
            g_idx++;
        }

        while(a_idx<a1.length){
            ans[g_idx] = a1[a_idx];
            g_idx++;
            a_idx++;
        }
        while(b_idx<a2.length){
            ans[g_idx] = a2[b_idx];
            g_idx++;
            b_idx++;
        }

        return ans;

    }
}