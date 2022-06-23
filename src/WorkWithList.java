import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WorkWithList {

    public static ArrayList<String> shiftList(String input,ArrayList<String> numbers){
        String helpString;
        String endOrBegin;
        String[] inputList = input.split(" ");
        int count = Integer.parseInt(inputList[2]);
        if(inputList[1].equalsIgnoreCase("left")){
            for (int i = 0; i < count; i++) {
                endOrBegin = numbers.get(0);
                for (int j = 0; j < numbers.size()-1; j++) {
                    numbers.set(j,numbers.get(j+1));
                }
                numbers.set(numbers.size()-1,endOrBegin);
            }
        }else{
            for (int i = 0; i < count; i++) {
                endOrBegin = numbers.get(numbers.size()-1);
                for (int j = numbers.size()-1; j > 0; j--) {
                    numbers.set(j,numbers.get(j-1));
                }
                numbers.set(0,endOrBegin);
            }
        }
        return numbers;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> numbers  =  new ArrayList<>(Arrays.stream(in.nextLine().split(" ")).collect(Collectors.toList()));
        String input = in.nextLine();
        String[] inputList = input.split(" ");
        while (!input.equalsIgnoreCase("end")){
            if(input.contains("Add")){
                numbers.add(inputList[1]);
            }else if(input.contains("Remove")){
                if(Integer.parseInt(inputList[1]) <= numbers.size()-1){
                    numbers.remove(Integer.parseInt(inputList[1]));
                }else{
                    System.out.println("Invalid index");
                }
            }else if(input.contains("Insert")){
                if(Integer.parseInt(inputList[2]) <= numbers.size()-1){
                    numbers.add(Integer.parseInt(inputList[2]),inputList[1]);
                }else{
                    System.out.println("Invalid index");
                }
            }else if(input.contains("Shift")){
                shiftList(input,numbers);
            }
            input = in.nextLine();
            inputList = input.split(" ");
        }
        System.out.println(String.join(" ", numbers));
    }
}
