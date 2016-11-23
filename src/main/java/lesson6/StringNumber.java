package lesson6;

import java.util.Scanner;

/**
 * Created by valeria on 21.11.2016.
 */
public class StringNumber {

    public static void main(String[] args) {
        String myStr = removeAllExceptNumbers();
        System.out.print(myStr);
    }

    public static String removeAllExceptNumbers() {
        String myStr = "гж976ти34.рв32";
        char[] myArr = myStr.toCharArray();

        for (int i = 0; i < myArr.length; i++) {
            if (isNumber(myArr[i]) == false) {
                myArr[i] = ' ';
            }
        }
        String stringWithJustNumbers = new String(myArr);
        System.out.println(stringWithJustNumbers);
        String [] splitedString = stringWithJustNumbers.split(" ");

        StringBuffer stringBuffer = new StringBuffer();

        for(int i= 0; i< splitedString.length; i++){
            stringBuffer.append(splitedString[i]);
        }

        return  stringBuffer.toString();
    }

    public static boolean isNumber(char myChar) {

        if (myChar == '0' || myChar == '1' || myChar == '2' || myChar == '3' || myChar == '4' || myChar == '5' || myChar == '6' || myChar == '7' || myChar == '8' || myChar == '9') {
            return true;
        } else {
            return false;
        }
    }
    }

