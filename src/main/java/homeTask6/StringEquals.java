package homeTask6;



import java.util.Scanner;

/**
 * Created by valeria on 20.10.2016.
 */
public class StringEquals {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        System.out.println("1. Сравнить строки на равенство");
        System.out.println("2. Сравнить строки без учета регистра");
        System.out.println("3. Сравнить строки без учета пробелов между буквами\\словами");
        Scanner in =  new Scanner(System.in);
        System.out.println("Введите пункт меню: ");
        int num = in.nextInt();
        System.out.println("Введите первую фразу: ");
        String phrase1 = in.nextLine();
        System.out.println("Введите вторую фразу: ");
        String phrase2 = in.nextLine();

        if (num==1) {
            System.out.println (phrase1.equals(phrase2));
        }
        if (num==2) {
            System.out.println(phrase1.equalsIgnoreCase(phrase2));
        }
        if (num==3) {
            System.out.println(phrase1.replace(" ", "").equals(phrase2.replace(" ","")));
        }




//        if (phrase1.equals(phrase2)) {
//            System.out.println("Equals!!!");
//         } else {
//            System.out.println("Not equals!!!");
//              }
//
//        if (phrase1.equalsIgnoreCase(phrase2)) {
//            System.out.println("Equals!!!");
//        } else {
//            System.out.println("Not equals!!!");
//        }
//
//        if (phrase1.replace(" ", "").equals(phrase2.replace(" ",""))) {
//            System.out.println("Equals!!!");
//        } else {
//            System.out.println("Not equals!!!");
//        }

    }
}
