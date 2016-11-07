package lesson3cycle.HomeTask3Cykle;

import java.util.Scanner;

/**
 * Created by valeria on 06.10.2016.
 */
public class HomeTaskCycle {
    public static void main(String[] args) {
        //Slaid_22
        Scanner in = new Scanner(System.in);
        System.out.print("Введите цифру от 1 до 7:");
        int num = in.nextInt();
        switch (num){
            case 1:
                System.out.println("Пн");
                break;
            case 2:
                System.out.println("Вт");
                break;
            case 3:
                System.out.println("Ср");
                break;
            case 4:
                System.out.println("Чт");
                break;
            case 5:
                System.out.println("Пт");
                break;
            case 6:
                System.out.println("Сб");
                break;
            case 7:
                System.out.println("Вс");
                break;
            default:
                System.out.println("Вы ввели неверные данные");
        }
    }
    /*Task #1 что не так?
    int a =1;
    int b =2;
    int c =3;
    int d =4;
    public int minAB (int a, int b) {
        int minnunb;
        if (a<b) {
            minnunb = a;
        } else minnunb = b;
        return minnunb;
    }
    public int minCD (int c, int d) {
        int minnumb2;
        if (c>d) {
            minnumb2=d;
        } else minnumb2 = c;
        return minnumb2;
    }
    int num1 =  minAB(a, b);
    int num2 = minCD (c, d);
    int num3;
    if (num1<num2) {
        num3 = num1;
    } else num3 = num2;
    System.out.println(num3);*/

    //Task #1
    public static int min(int a, int b, int c, int d) {
        a = 1;
        b = 2;
        c = 3;
        d = 4;
        if (min(a,b) < min(c,d)) {  // вызываем по очереди min(e,f) с параметрами e = a, f = b и e = c, f = d
            return min(a,b);
        } else  {
            return min(c,d);
        }
    }

    public static int min(int e, int f) {
        if (e < f)
            return e;
        else
            return f;
    }

}
