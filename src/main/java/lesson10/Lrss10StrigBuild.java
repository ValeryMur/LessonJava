package lesson10;

/**
 * Created by valeria on 31.10.2016.
 */
public class Lrss10StrigBuild {
    public static void main(String[] args) {


        char[] charArrayToString = {'a', 'b', 'c', 'd'};
        StringBuilder builder = new StringBuilder();

        for (char value : charArrayToString) {
            builder.append(value);
        }
    }
}
