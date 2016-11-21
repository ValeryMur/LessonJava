package lesson13;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by valeria on 11.11.2016.
 */
public class SortList {
    @Test
    public void testList() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("3");
        arrayList.add("3");
        arrayList.add("3");
        arrayList.add("2");

        for(String text:arrayList){
            System.out.println(text);
        }

        System.out.println("How many 1: "+ Collections.frequency(arrayList, "1"));
        System.out.println("How many 2: "+ Collections.frequency(arrayList, "2"));
        System.out.println("How many 3: "+ Collections.frequency(arrayList, "3"));

    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("2");
        list.add("1");
        list.add("3");
        list.add("3");

        Map<String,Integer> resultMap = new HashMap<>();

        for (String elem:list){
            Integer count = resultMap.get(elem);
            if (count==null){
                resultMap.put(elem, 1);
            } else {
                resultMap.remove(count);
                resultMap.put(elem,++count);
            }
        }

        System.out.println(resultMap);

    }
}
