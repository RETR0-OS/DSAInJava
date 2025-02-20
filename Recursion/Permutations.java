import java.util.ArrayList;

class Permutations{
    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(permutations(s, "", new ArrayList<>()));
    }

    private static ArrayList<String> permutations(String u, String p, ArrayList<String> ans){

        if (u.length() == 0){
            ans.add(p);
            return ans;
        }

        int times = p.length()+1;
        for (int i=0; i<times; i++){
            @SuppressWarnings("RedundantStringConstructorCall")
            String current = new String(p);
            if (p.length()==0){
                current += u.charAt(0);
            }
            else{
                current = current.substring(0,i)+u.charAt(0)+current.substring(i);
            }
            permutations(u.substring(1), current, ans);
        }
        return ans;

    }
}