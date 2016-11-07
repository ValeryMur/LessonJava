package lesson6;

/**
 * Created by valeria on 17.10.2016.
 */
public class StringImmutable {
    public static void main(String[] args) {
        String myString = "Jack";
        myString.concat("Sparrow"); // "Jack"+"Sparrow"
        System.out.println(myString); //Jack

        myString = myString.concat(" Sparow");
        System.out.println(myString); //Jack Sparrrow
    }
}
