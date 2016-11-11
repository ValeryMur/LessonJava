package lesson13;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
}
