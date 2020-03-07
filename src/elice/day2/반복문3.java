package elice.day2;

import elice.코딩별;

public class 반복문3 {

    public static void main(String[] args) {

        코딩별.출력("별나무 줄 숫자를 입력하세요:");
        double 줄수 = 코딩별.숫자입력();

        String 별나무 = "";

        for (int 줄번호 = 1; 줄번호 <= 줄수; 줄번호++) {
            for (int 횟수 = 1; 횟수 <= 줄번호; 횟수++) {
                별나무 += "*";
            }
            if (줄번호 <= 줄수 - 1) {
                별나무 += "\n";
            }

        }

        코딩별.출력(별나무);
    }
}