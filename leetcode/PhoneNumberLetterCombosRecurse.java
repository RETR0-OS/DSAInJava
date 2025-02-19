import java.util.ArrayList;
import java.util.List;

class PhoneNumberLetterCombosRecurse{
    private static final String[] maps = {"", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //private final int[] factorials = {1,2,6,24};
    private static ArrayList<String> answers = new ArrayList<>();

    public static void main(String[] args) {
        //constraints => 0<= phone_number.length() <=4 ; 2<= digit <=9
        String ph_number = "237";
        System.out.println(letterCombinations(ph_number));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return answers;
        }
        makeCombos(digits, "");
        return answers;
    }

    public static void makeCombos(String digits, String p){
        if(digits.length() == 0){
            answers.add(p);
            return;
        }

        String selected = maps[Integer.parseInt(""+digits.charAt(0))-1];
        if (digits.length() ==1){
            digits = "";
        }
        else{
            digits = digits.substring(1);
        }

        for(int i=0; i<selected.length(); i++){
            makeCombos(digits, p+selected.charAt(i));
        }
    }
}