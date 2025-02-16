public class InfiniteArraySearch {
    
    public static void main(String[] args) {
        int[] in_arr = {1, 2, 3, 4,5 ,6 ,7,8, 9, 20, 32, 52, 56, 67, 89, 100, 230, 450};
        int t = 67;
        int s = 0;
        int e = 20;
        while (t > in_arr[e]){
            s = e+1;
            e = s + 20;
        }
        if (in_arr[s] < t){
            System.out.println(""+-1);
        }
        else{
            System.out.println(binarySearch(in_arr, t, s, e));
        }
    }

    static int binarySearch(int[] arr, int t, int s, int e){
        while (s<=e){
            int mid = (s+e) / 2;
            if (arr[mid] == t){
                return mid;
            }
            else if(arr[mid] < t){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return -1;
    }
}
