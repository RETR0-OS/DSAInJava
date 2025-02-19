import java.util.ArrayList;
class SubArray{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        ArrayList<ArrayList<Integer>> sub_arr = build_subarr(arr, new ArrayList<ArrayList<Integer>>(), new ArrayList<Integer>(), 0);
        // System.out.println(sub_arr);
        System.out.println(sub_arr.size());
    }

    private static ArrayList<ArrayList<Integer>> build_subarr(int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur_ans, int p_idx){
        if (p_idx == arr.length){
            ans.add(cur_ans);
            return ans;
        }

        //Skip the current element.
        build_subarr(arr, ans, cur_ans, p_idx+1);
        
        //Add the current element.
        cur_ans.add(arr[p_idx]);
        build_subarr(arr, ans, cur_ans, p_idx+1);

        return ans;
    }
}