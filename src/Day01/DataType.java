package Day01;

public class DataType {

    public static void main(String[] args) {

        // 1byte == 8bit
        // 1bit = 숫자 0이나 1을 저장할 수 있음
        // 0 1111111 = >128 + 64 + 32 + 16 + 8 + 4 + 2 + 1 = 127
        // 맨 처음비트 = 부호를 정해주는 비트 1이면 -, 0이면 +
        byte a = 127;  // 1byte
        short b = 32767; // 2byte

        int c = 2147483647; // 4byte
        // long으로 변수를 지정하면 900경까지 저장이 가능하지만, 저장하는 숫자를 보관하는 곳은 int를 따름
        // 따라서 값의 접미사에 l을 붙여주면 int보다 높은 숫자를 저장 가능하게 한다.
        long d = 2147483647546464546l; // 8byte
        System.out.println(d);

        // 컴퓨터는 정수와 실수를 따로따로 저장함
        float e = 3.144654564654564f; // 4byte
        double f = 3.1456125646566; // 8byte
        double g = 100; // 정수 저장도 가능, 실수는 정수보다 큰? 값인가 뭔갈 가짐 하지만, 결과가  소수점도 나옴
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);

        boolean flag1 = true;
        boolean flag2 = (5 > 10);
        System.out.println("flag1 = " + flag1);
        System.out.println("flag2 = " + flag2);

        // Ctrl + Alt + "v" == 자동으로 변수 선언을 값의 타입에 맞게 지정해준다.

        double random = Math.random();

        int x = 200;
        System.out.println(x + a);
        System.out.println(b * x);

        // 문자형 char : 2byte 할당 0 ~ 66636
        char text = 58794; // 글자 1글자를 저장할 때 쓰는것
        System.out.println("text = " + text);

        // 문자열 : 문자 배열
        char[] hello = {'안', '녕', '하', '세', '요'};
        System.out.println("hello = " + new String(hello));

        // 기본 타입이 아닌 것들은 용량이 정해져 있지 않다.
        // byte short int long float double boolean char 8개의 기본 타입
        String Hello2 = "안녕하세요";
    }
}
