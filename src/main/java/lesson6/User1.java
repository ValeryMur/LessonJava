package lesson6;

/**
 * Created by valeria on 17.10.2016.
 */
public class User1 {

    public String name;
    public int age;
    public String city;
    public char gender;

    public static String type = "Human";

    @Override
    public String toString(){
        return name+":"+city+":"+gender;

    }


}
