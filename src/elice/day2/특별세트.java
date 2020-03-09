package elice.day2;

import elice.코딩별;

class 특별세트 extends 세면도구세트{
    int 면도기;

    특별세트(int 면도기, int 칫솔, int 치약, int 비누, int 샴푸, int 린스){
        super(칫솔, 치약, 비누, 샴푸, 린스);
        this.면도기 = 면도기;
    }

    void 출력하기 (String 세트이름){
        super.출력하기(세트이름);
        코딩별.출력(" 면도기: "+면도기);
    }

}
