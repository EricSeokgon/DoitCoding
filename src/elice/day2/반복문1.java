package elice.day2;

import elice.코딩별;

public class 반복문1 {

    public static void main(String[] args) {

        코딩별.출력("식권이 몇 장 필요한가요?");
        double 장수 = 코딩별.숫자입력();

        for ( int 출력횟수 = 1; 출력횟수 <= 장수; 출력횟수 = 출력횟수 + 1)

        {
            코딩별.출력("[식권] #" + 출력횟수);
        }
    }
}