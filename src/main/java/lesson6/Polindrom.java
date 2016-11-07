package lesson6;

import java.util.Scanner;

/**
 * Created by valeria on 17.10.2016.
 */
public class Polindrom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ведите слово: ");
        String myString = in.nextLine();
        myString = myString.toLowerCase();
        myString = myString.replace(" ","").replace("!","").replace(",","");

        //String myString = "искатьтакси";
        String mySecString = new StringBuffer(myString).reverse().toString();
        System.out.println(myString);
        System.out.println(mySecString);
        if (myString.equals(mySecString)) {
            System.out.println("Палиндромы");
        } else {
            System.out.println("Не палиндромы");
        }

    }
}
