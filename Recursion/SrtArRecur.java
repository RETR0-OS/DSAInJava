public class SrtArRecur{
    public static void main(String[] args) {
        int[] ar = {2,4,1,6,3};
        ar = sort(ar);
        for(int i:ar){
            System.out.print(i+", ");
        }
        
    }

    public static int[] sort(int[] arr){
        boolean swapped = false;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                arr[i] = arr[i] ^ arr[i+1];
                arr[i+1] = arr[i] ^ arr[i+1];
                arr[i] = arr[i] ^ arr[i+1];
                swapped = true;
                break;
            }
        }
        if (!swapped){
            return arr;
        }
        return sort(arr);
    }

}