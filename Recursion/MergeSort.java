import java.util.Arrays;

class MergeSort{
    public static void main(String[] args) {
        int[] arr = {3,2,4,2,4,21,5,1};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int[] ans = new int[arr1.length+arr2.length];
        int i = 0;
        int j = 0;
        int count=0;
        while (i<arr1.length && j<arr2.length){
            if (arr1[i] < arr2[j]){
                ans[count] = arr1[i];
                i++;
                count++;
            }
            else if(arr1[i] > arr2[j]){
                ans[count] = arr2[j];
                j++;
                count++;
            }
            else{
                ans[count] = arr1[i];
                i++;
                count++;
                ans[count] = arr2[j];
                j++;
                count++;
            }
        }
        while(j < arr2.length){
            ans[count] = arr2[j];
            count++;
            j++;
        }
        while(i < arr1.length){
            ans[count] = arr1[i];
            count++;
            i++;
        }
        return ans;
    }

    public static int[] sort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int[] h1 = new int[arr.length/2];
        int[] h2 = new int[arr.length/2];
        System.arraycopy(arr, 0, h1, 0, arr.length/2);
        System.arraycopy(arr, arr.length/2, h2, 0, arr.length/2);
        return merge(sort(h1), sort(h2));
    }
}