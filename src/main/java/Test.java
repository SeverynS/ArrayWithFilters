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
                Collections.singletonList("phone, black, xiaomi"),
                Collections.singletonList("phone, white, iphone"),
                Collections.singletonList("pc, silver, dell"),
                Collections.singletonList("laptop, pink, macbook"),
                Collections.singletonList("headphones, gold, airpods"),
                Collections.singletonList("phone, gold, iphone")
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
            String s = l.toString();
            String s2 = s.substring(1, s.length() - 1);
            String[] strArr = s2.split(", ");
            if (type && ruleValue.equals(strArr[0])
                    || color && ruleValue.equals(strArr[1])
                    || name && ruleValue.equals(strArr[2])) {
                result++;
            }
        }
        return result;
    }
}
