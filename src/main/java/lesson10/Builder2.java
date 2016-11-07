package lesson10;

/**
 * Created by valeria on 31.10.2016.
 */
public class Builder2 {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        int count = 100;
        for (int i=0; i<count; i++)
            output.append("Some text");
        System.out.println(output);
    }
}
