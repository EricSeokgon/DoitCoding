package elice;

public class 조건문3 {

    public static void main(String[] args) {

        코딩별.출력("피자 가게가 열렸나요(y/n)?");
        char 피자가게 = 코딩별.문자형입력();

        코딩별.출력("치킨 가게가 열렸나요(y/n)?");
        char 치킨가게 = 코딩별.문자형입력();

        if (피자가게 == 'y') {
            코딩별.출력("피자 가게로 가자");
        } else if (치킨가게 == 'y') {
            코딩별.출력("치킨 가게로 가자");
        } else {
            코딩별.출력("편의점에서 라면 먹자");
        }
    }
}