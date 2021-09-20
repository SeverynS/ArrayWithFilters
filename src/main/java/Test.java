import java.util.*;

/*
* You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name
* of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.*/
public class Test {
    public static void main(String[] args) {

        List<List<String>> inputData = new ArrayList<>(Arrays.asList(
                Arrays.asList("phone", "black", "xiaomi"),
                Arrays.asList("phone", "white", "iphone"),
                Arrays.asList("pc", "silver", "dell"),
                Arrays.asList("laptop", "pink", "macbook"),
                Arrays.asList("headphones", "gold", "airpods"),
                Arrays.asList("phone", "gold", "iphone")
        ));

        System.out.println(parameterFiltering(inputData, "color", "black"));
        System.out.println(parameterFiltering(inputData, "type", "phone"));
        System.out.println(parameterFiltering(inputData, "name", "iphone"));
        System.out.println(parameterFiltering(inputData, "color", "gold"));
    }

    private static int parameterFiltering(List<List<String>> arr, String ruleKey, String ruleValue) {
        int result = 0;
        boolean type = ruleKey.equals("type");
        boolean color = ruleKey.equals("color");
        boolean name = ruleKey.equals("name");
        for (List l : arr) {
            if (type && ruleValue.equals(l.get(0))
                    || color && ruleValue.equals(l.get(1))
                    || name && ruleValue.equals(l.get(2))) {
                result++;
            }
        }
        return result;
    }
}
