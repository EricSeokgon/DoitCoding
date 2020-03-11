package elice.day3;

import elice.코딩별;

public class 배열 {

    public static void main(String[] args) {

        double 숫자[] = new double[3];

        for (int N = 0; N < 3; N++) {
            코딩별.출력(N + 1 + "번째 숫자를 입력하세요.");
            숫자[N] = 코딩별.숫자입력();
        }

        double 평균 = (숫자[0] + 숫자[1] + 숫자[2]) / 3;
        코딩별.출력("세 숫자의 평균값은 " + 평균 + "입니다.");
    }
}
