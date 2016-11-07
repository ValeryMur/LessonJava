package lesson2variable;

/**
 * Created by valeria on 30.09.2016.
 */
public class Wrapp {
    public static void main(String[] args) {

        int i =5;
        int j =10;
        int result = 5 + 10;

        System.out.println(result);

        result = 5-10;
        System.out.println(result);

        result = 5*10;
        System.out.println(result);

        result = 6/3;
        System.out.println(result);

        result = 7%3; //по модулю
        System.out.println(result);

        int k = 8;
         k +=2;
        k = k +2; // одинаковвые эти две стсроки

        System.out.println(k);

        k /=2;
        k -=2;
        k *=2;
    }
}
