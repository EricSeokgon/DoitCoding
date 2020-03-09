package elice.day2;

import elice.코딩별;

class 세면도구세트 {
    int 칫솔;
    int 치약;
    int 비누;
    int 샴푸;
    int 린스;

    /*세면도구세트(int A, int B, int C, int D, int E){
        칫솔 = A;
        치약 = B;
        비누 = C;
        샴푸 = D;
        린스 = E;
    }*/

    세면도구세트(int 칫솔, int 치약, int 비누, int 샴푸, int 린스) {
        this.칫솔 = 칫솔;
        this.치약 = 치약;
        this.비누 = 비누;
        this.샴푸 = 샴푸;
        this.린스 = 린스;
    }

    void 출력하기(String 세트이름) {
        코딩별.출력("*** " + 세트이름 + " 내용물 ***");
        코딩별.출력(" 칫솔: " + 칫솔);
        코딩별.출력(" 치약: " + 치약);
        코딩별.출력(" 비누: " + 비누);
        코딩별.출력(" 샴푸: " + 샴푸);
        코딩별.출력(" 린스: " + 린스);
    }

    public 세면도구세트() {

    }
}