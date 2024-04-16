package day06.memberCopy;

// 역할: 회원 배열을 관리하는 역할 - 회원 데이터 저장소
public class MemberRepository {

    //필드
   static Member[] members;
   static Member[] restoreList;
    /**
     * 이메일을 통해 회원의 모든 정보(객체)를 가져오는 메서드
     * @param inputEmail - 사용자가 입력한 이메일값
     * @return - 해당 이메일을 통해 찾아낸 회원 객체,
     *           만약 찾지 못하면 null을 리턴
     */
    public Member findMemberByEmail(String inputEmail) {
        for (Member m : members) {
            if(inputEmail.equals(m.email)) {
                return m;
            }
        }
        return null;
    }

    public Member findRemovedMemberByEmail(String inputEmail) {
        for (Member m : restoreList) {
            if(inputEmail.equals(m.email)) {
                return m;
            }
        }
        return null;
    }

    // 생성자
    MemberRepository() {
        this.members = new Member[0];
        this.restoreList = new Member[0];
    }

    // 메서드

    // 회원정보 생성

    /**
     * 생성된 회원정보를 회원 배열의 끝에 추가하는 기능
     * @param newMember - 사용자의 입력으로 전달된 회원 정보 객체
     */
    void addNewMember(Member newMember) {


        Member[] temp = new Member[members.length + 1];
        for (int i = 0; i < members.length; i++) {
            temp[i] = members[i];
        }
        temp[temp.length - 1] = newMember;
        members = temp;
    }

    void addRemoveMember(Member newMember) {


        Member[] temp = new Member[restoreList.length + 1];
        for (int i = 0; i < restoreList.length; i++) {
            temp[i] = restoreList[i];
        }
        temp[temp.length - 1] = newMember;
        restoreList = temp;
    }

    void removeMemberByEmail(Member targetMember) {
        int index = findTargetIndex(targetMember);
        if(index == -1) return;
        Member[] temp = new Member[members.length - 1];
        for (int i = index; i < members.length - 1; i++) {
            members[i] = members[i+1];
        }
        for (int i = 0; i < temp.length ; i++) {
            temp[i] = members[i];
        }
        members = temp;
    }

    void removeMemberInRestore(Member targetMember) {
        int index = findTargetIndex(targetMember);
        if(index == -1) return;
        Member[] temp = new Member[restoreList.length - 1];
        for (int i = index; i < restoreList.length - 1; i++) {
            restoreList[i] = restoreList[i+1];
        }
        for (int i = 0; i < temp.length ; i++) {
            temp[i] = restoreList[i];
        }
        restoreList = temp;
    }

    // 이메일 중복을 확인하는 기능
    // (/** + enter)
    /**
     *
     * @param targetEmail - 검사할 사용자의 입력 이메일 값
     * @return - 이메일이 이미 존재한다면 true,
     *           존재하지 않는 사용가능한 이메일이면 false
     * @author - 박진우
     * @since  - 2024.04.16
     *
     */
    boolean isDuplicateEmail(String targetEmail) {
        for(Member m : members) {
            if(targetEmail.equals(m.email)) {
                return true;
            }

        }
        return false;
    }

    /**
     *
     * @param targetEmail = 사용자가 입력한 이메일
     * @return 인덱스번호를 반환 (이 함수 사용 전 타겟 이메일을 가지고 있는지 확인하는 함수가 실행되었으므로
     * 일치하는 회원의 이메일이 없을경우 그냥 -1 반환)
     */
    int findTargetIndex(Member targetMember) {
        for (int i = 0; i < members.length; i++) {
            if (targetMember.equals(members[i])) return i;
        }
        return -1;
    }
}
