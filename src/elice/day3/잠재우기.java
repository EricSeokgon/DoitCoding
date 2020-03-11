package elice.day3;

import elice.코딩별;

public class 잠재우기 {
    public static void main(String[] args) {
        String 구구단한단 = "";

        for(int 앞수=1; 앞수<=9; 앞수++){
            for(int 뒷수=1; 뒷수<=9; 뒷수++){
                구구단한단 = 구구단한단 + 앞수 + " x " + 뒷수 + " = " + (앞수*뒷수) + "\n";
            }
            코딩별.출력(구구단한단);
            구구단한단 = "";

            try{
                Thread.sleep(1000);
            }catch (Exception e){
            }

        }
    }
}