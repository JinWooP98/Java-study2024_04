package day06.memberCopy;

import util.SimpleInput;

// 역할: 사용자의 메뉴 입력을 분기하는 역할
public class MemberController {

    MemberView mv;
    MemberRepository mr;
    SimpleInput si;
    MemberController() {
        this.mv = new MemberView();
        this.mr = new MemberRepository();
        this.si = new SimpleInput();
    }

    // 메뉴 입력 분기에 따라 할 일을 나눠주는 기능
    void run() {

        while (true) {
            String menuNum = mv.showProgramMenu();

            switch (menuNum) {
                case "1":
                    mv.inputNewMember();
                    break;
                case "2":
                    // 이메일을 입력받아서 회원을 개별조회 해주는 코드
                    mv.findMember();
                    break;
                case "3":
                    mv.showMembers();
                    break;
                case "4":
                    mv.modifyMember();
                    break;
                case "5":
                    if(MemberRepository.members.length == 0) return;
                    mv.removeMember();
                    break;
                case "6":
                    mv.restoreMember();
                    break;
                case "7":
                    boolean flag = mv.exitProgram();
                    if(flag) return;
            } // end switch

            si.stopInput();
        } // end while
    }
}
