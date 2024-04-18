package day08.static_;

import util.SimpleInput;

import static day08.static_.Count.*;
import static java.lang.System.*;
import static util.SimpleInput.input;

public class Main {

    public static void main(String[] args) {


        x = 20;
        m1();
        Count c1 = new Count();
        c1.m2();
        Count c2 = new Count();

        c1.y = 10;
        c2.y = 20;

        x = 50;
        x = 99;

        out.println("c1.x = " + x);
        out.println("c2.x = " + x);
        out.println("==================");
        out.println("c1.y = " + c1.y);
        out.println("c2.y = " + c2.y);


        Calculator redCal = new Calculator();
        Calculator blueCal = new Calculator();

        Calculator.calcArea(5);

        redCal.paint("빨강");
        blueCal.paint("파랑");

//        String name = input(" 이름 : ");

        out.println();

        m1();
        String name = input("12312");
        String name1 = input("1234");

        out.println("======================");

        out.println(Person.nation);
        Person gap = new Person("갑돌잉", 20);
        out.println(gap.name);
        out.println(gap.age);
        out.println(gap.nation);
    }
}
