import java.util.ArrayList;

class LinearSearch{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,4,5,7,9,100};
        ArrayList<Integer> ans = findAll(new ArrayList<>() ,arr, 4, 0);
        for(int a:ans){
            System.out.print(a + " ");
        }
    }

    public static ArrayList<Integer> findAll(ArrayList<Integer> ans, int[] arr, int e, int idx){
        if (idx >= arr.length){
            return ans;
        }
        if(arr[idx] == e){
            ans.add(idx);
        }
        return findAll(ans, arr, e, idx+1);
    }
}