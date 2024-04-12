package day04;

public class FieldAndLocal {
    // 필드는 값을 초기화 하지 않아도
    // 각 타입의 기본값으로 자동 세팅
    // 정수 : 0, 실수 : 0.0, 논리 : false, char : '', 나머지 : null
    int aaa; // in Heap

    // ccc: 매개 변수(parameter) - 메서드 호출시 반드시 필요한 인자값
    // 지역변수에 가까움
    void foo(int ccc) {
        int bbb = 20; // in stack // 영역이 좁아 쓸거면 쓰고, 아님 쓰지 마 자동으로 값 할당 X

        System.out.println("aaa = " + aaa);
        System.out.println("bbb = " + bbb);
        System.out.println("ccc = " + ccc);
    }
}
