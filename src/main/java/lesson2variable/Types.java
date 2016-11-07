package lesson2variable;

/**
 * Created by valeria on 30.09.2016.
 */
public class Types {
    public static void main(String[] args) {
        //Правильное преведение типов которое автоматически делается
        byte b = 123;
        short s = 1234;
        int i = 1223445;
        long l = 12345678;

        //float f = 3.788E+38f;
        double d = 1.65748+76578d;

        //64>32>16>8
        l=i=s=b;
        //64>32
     //   d=f;

        //Явное риведение типов
        int i5 = 605434;
        long lo = i;
        short s4 = (short) lo;

        //как указать какому числу соответствует символ
        char ch = 'j';
        int intCh = (int) ch;
        System.out.println("args = [hjhhj]");//если не проинициализировать примитивные типы, они =0

       /* double b = 2.6;
        int c = (int)(0.5+b); // можно применять к целым выражениям
        System.out.println(c); //выдает 3
        System.out.println(c); //выдает 3 // ctrl+d копировать строчку*/


        //Классы оболочки
        Integer i2 = new Integer(100);
        Character c1 = new Character('c');
        Boolean b1 = new Boolean(true);

       /* Float x = new Float("3.8656");
        xint = x.intValue();*/



    }
}
