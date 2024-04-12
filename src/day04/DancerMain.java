package day04;

public class DancerMain {

    // 자바의 클래스는 실행용 클래스와 설계용 클래스가 나뉘어져 있음
    // 실행용 클래스 : 객체를 생성해서 객체의 기능을 실행시키는 곳
    // --> main이 필요
    public static void main(String[] args) {

        // 설계도(클래스)를 통해 객체를 찍어냄(생성)
        Dancer kim = new Dancer();

        // 객체의 속성 부여
        kim.dancerName = "김철수";
        kim.crewName = "치즈치즈";
        kim.genre = "스트릿";
        kim.danceLevel = 1;

        kim.introduce();
        kim.dance();

        Dancer park = new Dancer();

        park.dancerName = "박철수";
        park.crewName = "전쟁이야";
        park.genre = "코레오";
        park.danceLevel = 2;

        park.dance();
        // 생성자 호출
        Dancer hong = new Dancer();
        hong.dance();

        Dancer choi = new Dancer("최폭풍");
        choi.dance();
        choi.introduce();

        Dancer nanana = new Dancer("냐냐냥", "시골크루");
        nanana.dance();
        nanana.introduce();

        Dancer rock = new  Dancer("메로롱", "폭식맨", "락킹");
        rock.introduce();
    }
}
