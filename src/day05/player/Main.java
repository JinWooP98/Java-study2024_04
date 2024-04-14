package day05.player;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Player parking = new Player("주차왕파킹");
        Player insultKing = new Player("욕설왕뻐킹");
        Player Rabbu = new Player("라뿌");

        System.out.println("insultKing = " + insultKing);
        System.out.println("parking = " + parking);

        insultKing.attack(parking);
        parking.attack(insultKing);
        parking.attack(insultKing);
        parking.attack(insultKing);
        Rabbu.attack(insultKing);


        Player p1 = new Player("하하호호");
        System.out.println(Rabbu.hp);
        System.out.println(Rabbu.nickName);
        System.out.println(Rabbu.level);

    }
}
