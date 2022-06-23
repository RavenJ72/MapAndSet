import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,String> phoneBook = new HashMap<>();
        String[] input = in.nextLine().split(" ");
        String searchIn;

        while(!input[0].equalsIgnoreCase("stop")){
            if(input[0].equalsIgnoreCase("search")){
                searchIn = in.nextLine();
                if(phoneBook.containsKey(searchIn)){
                    System.out.println(searchIn + " -> " + phoneBook.get(searchIn));
                }else{
                    System.out.println("Contact " + searchIn + " does not exist.");
                }
            }else{
                phoneBook.put(input[0],input[2]);
            }
            input = in.nextLine().split(" ");
        }
    }
}
