package day06.memberCopy;

import util.SimpleInput;

// 역할: 회원 데이터 관리를 위해 입력 출력을 담당함
public class MemberView {

    // 객체의 협력
    //필드
    MemberRepository mr;
    SimpleInput si;

    // 생성자
    MemberView() {
        this.mr = new MemberRepository();
        this.si = new SimpleInput();
    }

    // 메서드
    // 모든 회원의 정보를 출력하는 기능
    void showMembers () {
        System.out.printf("======= 현재 회원 목록 (총%d명) =======\n", MemberRepository.members.length);
        for(Member m : MemberRepository.members) {
            System.out.println(m);
        }
    }

    // 회원정보 생성을 위해 입력을 처리
    void inputNewMember() {
        String email = null;
        while(true) {
            email = si.input("- 이메일: ");
            if(!mr.isDuplicateEmail(email)) {
                break;
            }
            System.out.println("중복된 이메일입니다.");
        }

        String name = si.input("- 이름: ");
        String password = si.input("- 패스워드: ");
        String gender = null;
        while(true) {
            gender = si.input("- 성별[M/F]: ");
            if(gender.equals("m") || gender.equals("M") || gender.equals("남자")) {
                gender = "남자";
                break;
            } else if(gender.equals("f") || gender.equals("F") || gender.equals("여자")) {
                gender = "여자";
                break;
            } else {
                System.out.println("정확한 성별을 입력해 주세요.");
            }
        }
        int age = Integer.parseInt(si.input("- 나이: "));

        // 입력데이터를 기반으로 한 명의 회원 객체를 생성
        Member newMember = new Member(email, name, password, gender, age);

        // 위임 - 관심사의 분리
        mr.addNewMember(newMember);

        System.out.println("# 회원가입 성공!!");
    }

    // 사용자에게 보여줄 전체 메뉴 화면 출력
    String showProgramMenu () {
        System.out.println("\n##### 회원 관리 시스템 #####");
        System.out.println("* 1. 회원 정보 등록하기");
        System.out.println("* 2. 개별회원 정보 조회하기");
        System.out.println("* 3. 전체회원 정보 조회하기");
        System.out.println("* 4. 회원 정보 수정하기");
        if(MemberRepository.members.length != 0) System.out.println("* 5. 회원 정보 삭제하기");
        System.out.println("* 6. 프로그램 종료");
        System.out.println("============================");

        String menuNumber = si.input(">> ");
        return menuNumber;
    }

    // 프로그램 종료를 판단하는 입출력
    boolean exitProgram() {
        String exit = si.input("- 프로그램을 종료합니까? [y/n]\n>>");
        if (exit.equals("y")) {
            System.out.println("프로그램을 종료합니다!");
            return true;
        } else {
            System.out.println("프로그램 종료를 취소합니다.");
            return false;
        }
    }

    /**
     *  사용자가 입력한 이메일을 가지고 있는 회원 정보를 출력하는 함수
     *  사용자가 입력한 이메일이 있는지 없는지 먼저 판단
     *  없다면, 조회된 회원이 없다는 문구 출력
     *  있다면, 그 이메일을 가지고 있는 회원 정보 출력
     */
    void findMember () {
        System.out.println("조회를 시작합니다.");
        String targetEmail = si.input("# 이메일: ");
//        if(!mr.isDuplicateEmail(targetEmail)) {
//            System.out.println("# 조회된 회원이 없습니다.");
//        } else {
//            System.out.println("======= 조회 결과 =======");
//            int index = mr.findTargetMember(targetEmail);
//            System.out.println("# 이름: " + MemberRepository.members[index].memberName);
//            System.out.println("# 비밀번호: " + MemberRepository.members[index].password);
//            System.out.println("# 성별: " + MemberRepository.members[index].gender);
//            System.out.println("# 나이: " + MemberRepository.members[index].age);
//        }
        Member foundMember = mr.findMemberByEmail(targetEmail);
        if(foundMember == null) {
            System.out.println("\n# 조회된 회원이 없습니다.");
        } else {
            System.out.println("======= 조회 결과 =======");
            System.out.println("# 이름: " + foundMember.memberName);
            System.out.println("# 비밀번호: " + foundMember.password);
            System.out.println("# 성별: " + foundMember.gender);
            System.out.println("# 나이: " + foundMember.age);
            System.out.println();
        }
    }

    void modifyMember () {
        String targetEmail = si.input("수정할 회원의 이메일을 입력하세요: ");
        Member foundMember = mr.findMemberByEmail(targetEmail);
        if(foundMember == null) {
            System.out.println("\n# 조회된 회원이 없습니다.");
        } else {
            // 비번 수정
            System.out.printf("# %s님의 비밀번호를 변경합니다.\n", foundMember.memberName);
            String newPassword = si.input("# 새 비밀번호: ");

            // 회원정보 실제로 수정
            foundMember.changePassWord(newPassword);
            System.out.println("# 비밀번호 변경이 완료되었습니다.");
        }
    }

    void removeMember () {
        String targetEmail = si.input("# 삭제할 멤버의 이메일: ");
        Member targetMember = mr.findMemberByEmail(targetEmail);
        if(targetMember == null) {
            System.out.println("# 조회된 회원이 없습니다.");
        } else {
            // 삭제 진행
            // y or n 값을 받기
           String isYes = si.input(targetMember.memberName + "님의 정보를 정말 삭제합니까?[y/n]\n>>");
           if(isYes.equals("n")) {
               System.out.println("정보를 삭제하지 않습니다.");
           } else {
               mr.removeMemberByEmail(targetMember);
               System.out.printf("# %s님의 회원저보가 삭제되었습니다\n", targetMember.memberName);
           }
        }
    }

}
