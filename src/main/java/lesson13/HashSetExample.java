package lesson13;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by valeria on 11.11.2016.
 */
public class HashSetExample {
    public void hashTable(){
        Set<String> set = new HashSet<String>();
        set.add("c");
        set.add("a");
        set.add("b");
        System.out.println(set);//#[b,c,a]
    }

}
