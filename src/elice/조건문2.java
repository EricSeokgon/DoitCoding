package elice;

public class 조건문2 {

    public static void main(String[] args) {


        코딩별.출력("몇 학년인가요(1~6)?");
        double 학년 = 코딩별.숫자입력();

        if ((학년 >= 2) && (학년 <= 4)) {
            코딩별.출력("햄버거를 드세요.");
        } else {
            코딩별.출력("김밥을 드세요.");
        }

    }
}