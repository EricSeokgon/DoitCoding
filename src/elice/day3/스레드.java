package elice.day3;

public class 스레드 {
    public static void main(String[] args) {

        오른쪽으로달리기 수호 = new 오른쪽으로달리기("수호");
        오른쪽으로달리기 세훈 = new 오른쪽으로달리기("세훈");

        수호.start();
        세훈.start();

    }
}
