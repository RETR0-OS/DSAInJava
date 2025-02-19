class SkipString{
    public static void main(String[] args) {
        String s = "abbcad";
        String skip = "e";
        System.out.println(skipStr(s, skip, 0, skip.length()-1, ""));
    }

    private static String skipStr(String original, String skip, int s, int e, String ans){
        if (e>=original.length()-1){
            if (ans.equals("")){
                ans = original;
            }
            while (s<original.length()){
                ans+=original.charAt(s);
                s++;
            }
            return ans;
        }
        if (original.substring(s, e+1).equals(skip)){
            s = e+1;
            e = e+skip.length();
        }
        else{
            ans+=original.charAt(s);
            s++;
            e++;
        }
        // System.out.println(ans);
        return skipStr(original, skip, s, e, ans);
    }
}