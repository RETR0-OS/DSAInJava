class BubbleSort{
    public static void main(String[] args) {
        int[] a = {2,4,5,1,5,9,7};
        a = sort(a);
        for (int i:a){
            System.out.print(i+", ");
        }
    }

    private static int[] sort(int[] arr){
        boolean swapped = false;
        for (int i=0; i<arr.length-1; i++){
            if (arr[i] > arr[i+1]){
                arr[i] = arr[i]^arr[i+1];
                arr[i+1] = arr[i]^arr[i+1];
                arr[i] = arr[i]^arr[i+1];
                swapped = true;
            }
        }
        if (!swapped){
            return arr;
        }
        return sort(arr);
    }
}