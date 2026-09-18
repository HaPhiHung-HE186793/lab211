package until;

import java.util.Scanner;

public class Validater1 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getInt(String msgInfo, String msgOutRange, String msgError, int min, int max){
        do{
            try{
                System.out.println(msgInfo);
                int number = SCANNER.nextInt();
                if (number >= min && number <= max){
                    return number;
                }
                System.out.println(msgOutRange);
            }catch (NumberFormatException e){
                System.out.println(msgError);
            }
        }
        while(true);
    }

}
