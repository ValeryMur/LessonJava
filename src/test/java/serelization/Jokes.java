package serelization;

import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Created by valeria on 10.02.2017.
 */
public class Jokes {

    @Test
    public void readXml(){
        System.out.println(getBashJoke());
    }

        public static String getBashJoke(){
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Rss.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = jc.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Rss sc = null;
        try {
            sc = (Rss) unmarshaller.unmarshal(new URL("http://bash.im/rss/"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(((sc.channel.item.length-1) - 0) + 1) + 0;

        if(sc.channel.item[randomNum].description != null){
            return sc.channel.item[randomNum].description;
        }
        return "No Jokes For you! HA-HA!";
    }
}
