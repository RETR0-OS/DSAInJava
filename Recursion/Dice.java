import java.util.ArrayList;

class Dice{

    private static ArrayList<ArrayList<String>> answer = new ArrayList<>();
    public static void main(String[] args){
        int t = 4;
        System.out.println(makeSum(t, ""));
        // System.out.println(answer);
    }

    private static ArrayList<String> makeSum(int target, String cur_ans){
        if (target==0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(cur_ans);
            return ans;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <=6 && i<= target; i++) {;
            ans.addAll(makeSum(target-i, cur_ans+i));
        }

        return ans;

    }
}