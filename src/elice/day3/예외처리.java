package elice.day3;

import elice.코딩별;

public class 예외처리 {
    public static void main(String[] args) {

        boolean 입력전 = true;
        double 숫자;

        while (입력전 == true) {
            try {
                코딩별.출력("숫자를 입력하세요.");
                String 문자형숫자 = 코딩별.문자열입력();
                숫자 = Double.parseDouble(문자형숫자);

                입력전 = false; // 숫자 입력이 끝남.
                코딩별.출력("숫자 입력이 완료되었습니다." + 숫자);
            } catch (Exception e) {
                코딩별.출력("입력한 숫자가 아닙니다.");
            }
        }
    }
}