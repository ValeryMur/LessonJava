package lesson3cycle;

/**
 * Created by valeria on 03.10.2016.
 */
public class LogicOperator {
    public static void main(String[] args) {
        int a =4;
        int b =5;
        boolean result;
        result = a ==b;
        result = a>b || a<b; //  или
        result = a>b && a<b; //  и
        result = a !=b; // не равно
        result = !result; // логическое не false

        //отличее == и equels
        //equels - сравниваем строки
        // == сравниваем только примаетивные типы
        int c = 4;
        int d = 8;
        System.out.println(c == d? "c и b равны!": "a и b не равны");

        //break, return - обрывает цикл



    }
}
