package Day02;

import javax.lang.model.SourceVersion;
import java.util.Scanner;

public class ScannerPractice {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("**** 상품 재고 총액 구하기 ****");
        System.out.print("- 상품의 가격 : ");
        int price = Integer.parseInt(scan.nextLine());
        System.out.print("- 상품의 수량 : ");
        int num = Integer.parseInt(scan.nextLine());

    }
}
