package elice;

import java.util.Scanner;

public class 코딩별{

    public static void 출력(String msg){
        System.out.println(msg);
    }

    public static String 문자열입력(){
        String returnValue = "";

        Scanner sc = new Scanner(System.in);
        returnValue = sc.next();

        return returnValue;
    }

    public static double 숫자입력(){

        double number = 0;
        boolean NG = true;

        while (NG){

            try{
                number = Double.parseDouble(문자열입력());
                NG=false;

            }catch(Exception e){
                System.out.println("숫자를 입력하세요");
                NG=true;
            }
        }

        return number;

    }


    public static int 정수숫자입력(){

        int number = 0;
        boolean NG = true;

        while (NG){

            try{
                number = Integer.parseInt(문자열입력());
                NG=false;

            }catch(Exception e){
                System.out.println("정수형 숫자를 입력하세요");
                NG=true;
            }
        }

        return number;

    }

    public static char 문자형입력(){
        String returnValue = "";

        Scanner sc = new Scanner(System.in);
        returnValue = sc.next();

        char strArray [] = returnValue.toCharArray();

        return strArray[0];
    }

}