package lesson13;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by valeria on 11.11.2016.
 */
public class ListExample {


    @Test
    public void testList() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("Jack");
        arrayList.add("Jack");
        arrayList.add("Jack");
        arrayList.add("Jack2");
        arrayList.add("Jack2");
        arrayList.add("Jack2");

        List<String> collect = arrayList.stream().filter(s -> s.contains("2")).collect(Collectors.toList());

        List<String> linkedList = new LinkedList<String>();


    }
}
