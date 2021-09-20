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
        String[] arr = new String[6];
        arr[0] = "phone, black, xiaomi";
        arr[1] = "phone, white, iphone";
        arr[2] = "pc, silver, dell";
        arr[3] = "laptop, pink, macbook";
        arr[4] = "headphones, gold, airpods";
        arr[5] = "phone, gold, iphone";

        System.out.println(parameterFiltering(arr, "color", "black"));
        System.out.println(parameterFiltering(arr, "type", "phone"));
        System.out.println(parameterFiltering(arr, "name", "iphone"));
        System.out.println(parameterFiltering(arr, "color", "gold"));
    }

    private static int parameterFiltering(String[] arr, String ruleKey, String ruleValue) {
        int result = 0;
        List<String> stringList = stringSplitting(arr);
        HashMap<String, String> mapTemp = new HashMap<>();
        List<HashMap> hashMaps = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i += 3) {
            mapTemp.put("type", stringList.get(i));
            mapTemp.put("color", stringList.get(i + 1));
            mapTemp.put("name", stringList.get(i + 2));
            hashMaps.add(new HashMap<>(mapTemp));
        }

        for (HashMap hashMap : hashMaps) {
            mapTemp = hashMap;
            for (Map.Entry<String, String> entry : mapTemp.entrySet()) {
                if (entry.getKey().equals(ruleKey) && entry.getValue().equals(ruleValue)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static List<String> stringSplitting(String[] arr) {
        String[] temp;
        List<String> stringList = new LinkedList<>();
        for (String s : arr) {
            temp = s.split(", ", 3);
            stringList.addAll(Arrays.asList(temp));
        }
        return stringList;
    }
}
