package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class Validator1 {
    private static final Scanner SCANNER1 = new Scanner(System.in);

    public static int getInt(String msgInfo, String msgOutOfRange, String msgError, int min, int max){
        do{
            try{
                System.out.println(msgInfo);
                int number = Integer.parseInt(SCANNER1.nextLine());
                if( max >= number && number >= min){
                    return number;
                }
                System.out.println(msgOutOfRange);
            }catch (NumberFormatException e){
                System.out.println(msgError);
            }
        }
        while(true);
    }


}