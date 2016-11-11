package lesson13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by valeria on 11.11.2016.
 */
public class IteratorExample {
    public void iteratorAndEachFor (){
        List<String> list= new ArrayList<String>();
        list.add("Masha");
        list.add("Sasha");
        list.add("Lola");

        Iterator<String> iterator=list.iterator();

        while(iterator.hasNext()){
            String text = iterator.next();
            System.out.println(text);
        }

        for(String text:list){
            System.out.println(text);
        }
    }
}
