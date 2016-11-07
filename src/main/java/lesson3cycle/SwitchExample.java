package lesson3cycle;
import java.util.Scanner;

/**
 * Created by valeria on 03.10.2016.
 */
public class SwitchExample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter smth: ");
        int input = scanner.nextInt();

        switch (input) {
            case 1 :
            System.out.println("Jack");
            break;
            case 2 :
                System.out.println("56");
            case 3 :
                System.out.println("monday");
            default:
                System.out.println("lololol");

                if(input == 1) {
                    System.out.println("Jack");
                } else {
                    System.out.println("lololol");
                }

        }
    }
}
