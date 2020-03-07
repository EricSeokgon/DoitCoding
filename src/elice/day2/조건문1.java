package elice.day2;

import elice.코딩별;

public class 조건문1 {

    public static void main(String[] args) {

        코딩별.출력("몇 등인가요(1 또는 2)?");
        double 등수 = 코딩별.숫자입력();

        if (등수 == 1) {
            코딩별.출력("TV를 보며 편하게 쉬세요.");
        } else {
            코딩별.출력("설거지 당첨!");
        }
    }
}
