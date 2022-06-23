import java.text.DecimalFormat;
import java.util.*;

public class ProductShop {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        SortedMap<String, HashMap<String,String>> itemList = new TreeMap<>(String::compareTo);
        String input = in.nextLine();
        String[] inputArray;

        while(!input.equalsIgnoreCase("revision")){
            inputArray = input.split(", ");
            if(itemList.containsKey(inputArray[0])){
                itemList.get(inputArray[0]).put(inputArray[1],inputArray[2]);
            }else{

                HashMap<String,String> timeMap = new HashMap<>();
                timeMap.put(inputArray[1],inputArray[2]);
                itemList.put(inputArray[0],timeMap);

            }
            input = in.nextLine();
        }
        for(String shop : itemList.keySet()){
            System.out.println(shop + "->");
            for(String product : itemList.get(shop).keySet()){
                System.out.printf("Product: %s, Price: %s",product,new DecimalFormat("0.0").format(Float.parseFloat(itemList.get(shop).get(product))));
                System.out.println();
            }
        }
    }
}

//  Пример -- -- --
//perik, burn, 100.00
//ashan, redbull, 200.213
//kb, meat, 500.12313
//kb, icecream, 86.31231
//revision