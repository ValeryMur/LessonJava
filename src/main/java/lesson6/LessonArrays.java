package lesson6;

/**
 * Created by valeria on 17.10.2016.
 */
public class LessonArrays {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }

}
