class RotatedBS{
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        int idx = search(arr,100, 0, arr.length-1);
        System.out.println(idx);
    }

    private static int search(int[] arr, int e, int left, int right){
        if (right < left){
            return -1;
        }
        int middle = (left+right)/2;

        if (arr[middle] == e){
            return middle;
        }
        else if (arr[left] < arr[middle]){
            if (e >= arr[0] && e < arr[middle]){
                right = middle-1;
            }
            else{
                left = middle+1;
            }
            return search(arr, e, left, right);
        }
        else{
            left = middle+1;
            return search(arr, e, left, right);
        }
    
    }
}