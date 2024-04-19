package day09.poly;

import java.util.concurrent.Callable;

class A {}
class B extends A {}
class C extends A {}
class D extends B{}
class E extends C {}

/*
          Object
            |
            A
       /        \
      B          C
      |          |
      D          E
 */

public class Basic {

    void test () {

        // 다형성: 객체가 여러 타입을 사용할 수 있다.
        // - 부모의 타입을 사용 가능
        A x1 = new A();
        A x2 = new B();
        A x3 = new C();

        A x4 = new D();
        A x5 = new E();

        int a = 10;
        double b = (double) a;

        C c = new C();
        A d = (A) c;
    }

}
