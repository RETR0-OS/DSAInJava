import java.util.ArrayList;
import java.util.List;

class PhoneNumberLetterCombos {

    private static final String[] maps = {"", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //private final int[] factorials = {1,2,6,24};

    public static void main(String[] args) {
        //constraints => 0<= phone_number.length() <=4 ; 2<= digit <=9
        String ph_number = "237";
        System.out.println(letterCombinations(ph_number));
    }
    
    public static List<String> letterCombinations(String digits) {

        ArrayList<String> answers = new ArrayList<>();
        
        if (digits.isEmpty()){
            return answers;
        }

        String selected = maps[Integer.parseInt(""+digits.charAt(0))-1];

        for(int i=0; i<selected.length(); i++){
            answers.add(""+selected.charAt(i));
        }

        if(digits.length()>1){
            digits = digits.substring(1);
        }
        else{
            digits = "";
        }

        while (digits.length()>=1){
            selected = maps[Integer.parseInt(""+digits.charAt(0))-1];
            int curr_size = answers.size();
            for (int i=0; i<curr_size; i++){
                String old = answers.get(i);
                for (int j=0; j<selected.length(); j++){
                    answers.add(answers.get(0)+selected.charAt(j));
                }
                answers.remove(0);
            }
            if(digits.length()>1){
                digits = digits.substring(1);
            }
            else{
                digits = "";
            }
        }

        System.out.println(answers);
        return answers;

    }
}