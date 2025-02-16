//Iterate over the entire array to find the element.

/**
 * LinearSearch
 */

 
import java.util.ArrayList;
import java.util.Scanner;
public class LinearSearch {

    // Best case time complexity: O(1)
    // Worst case time complexity: O(n)


    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag){
            System.out.println("Enter integer element>> ");
            arr.add(sc.nextInt());
            System.out.print("Add more elements? (y/n)>>");
            char c = sc.next().charAt(0);
            if (c != 'y'){
                flag = false;
            }
        }

        System.out.print("Enter element to search>> ");
        int element = sc.nextInt();

        sc.close();

        System.out.println(linearSearch(arr, element));
    }

    static String linearSearch(ArrayList<Integer> arr, int element){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == element){
                return "Found at index " +i;
            }
        }
        return "Did not find element.";
    }
}