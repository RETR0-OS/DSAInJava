class SelectionSort{
    public static void main(String[] args) {
        int[] a = {2,4,5,1,5,9,7};
        a = sort(a, a.length);
        for (int i:a){
            System.out.print(i+", ");
        }
    }

    private static int[] sort(int[] arr, int idx){
        if (idx==0){
            return arr;
        }
        int max = 0;
        for (int i=0; i<idx; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        idx--;
        int temp = arr[idx];
        arr[idx] = arr[max];
        arr[max] = temp;
        return sort(arr, idx);
    }

}