package elice.day2;

public class 메서드추가 {

    public static void main(String[] args) {

        세면도구세트 세01호 = new 세면도구세트(2, 7, 3, 1, 1);
        세면도구세트 세03호 = new 세면도구세트(0, 4, 2, 1, 1);

        세01호.출력하기("세면도구세트 01호");
        세03호.출력하기("세면도구세트 03호");
    }
}