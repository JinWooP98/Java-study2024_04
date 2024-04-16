package day06.member;

// 역할: 회원 배열을 관리하는 역할 - 회원 데이터 저장소
public class MemberRepository {

    //필드
   static Member[] members;

    // 생성자
    MemberRepository() {
        this.members = new Member[3];
        members[0] = new Member("abc@def.com", "1234", "김철수", "남자", 50);
        members[1] = new Member("ghi@def.com", "5678", "김영희", "여성", 40);
        members[2] = new Member("xyz@def.com", "9101", "박한수", "남자", 30);
    }

    // 메서드

    // 회원정보 생성
    void addNewMember(Member newMember) {

        Member[] temp = new Member[members.length + 1];
        for (int i = 0; i < members.length; i++) {
            temp[i] = members[i];
        }
        temp[temp.length - 1] = newMember;
        members = temp;
    }
}
