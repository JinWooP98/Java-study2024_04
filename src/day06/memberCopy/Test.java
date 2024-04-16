package day06.memberCopy;

public class Test {

    public static void main(String[] args) {

        Member[] arr = new Member[5];

        Member m1 = new Member("abc@def.com", "1234", "김철수", "남성", 30);
        Member m2 = new Member("xyz@ghi.com", "4567", "김영희", "여성", 31);

        arr[0] = m1;
        arr[1] = m2;
        arr[2] = new Member("ad", "ad", "d", "d", 12);

        System.out.println("m1 = " + m1/*.toString이 생략되어 있음*/);
        System.out.println("m2 = " + m2);

        Member[] members = {m1, m2};

        System.out.println("================================================");

        MemberRepository mr = new MemberRepository();
        MemberView mv = new MemberView();

        Member newMember = new Member("ddd@ggg.com", "4321", "찰떡이", "남자", 42);

        mr.addNewMember(newMember);

        mv.showMembers();


    }
}
