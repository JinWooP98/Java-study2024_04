package day09.book;

import day03.Gender;


import static day09.book.LibraryRepository.bookLists;
import static day09.book.LibraryRepository.user;
import static util.SimpleInput.input;

// 역할: 도서관리 프로그램에서 입출력을 담당하는 객체
public class LibraryView {

    private LibraryRepository LR;

    public LibraryView ()  {
        LR = new LibraryRepository();
    }

    // 코드의 흐름을 캡슐화
    public void start() {
        userInfoInput();
        while(true) {
            String menuNum = libraryMenu();
            switch (menuNum) {
                case "1":
                    userInfo();
                    break;
                case "2":
                    checkBookList();
                    break;
                case "3":
                    searchBookByBookName();
                    break;
                case "4":
                    rentBook();
                    break;
                case "5":
                    searchBookByAuthor();
                    break;
                case "9":
                    System.out.println("# 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("# 올바른 메뉴번호를 입력하세요.");
            }
        }
    }

    // 회원 정보를 입력받는 기능
     private void userInfoInput () {
        System.out.println("# 회원 정보를 입력해주세요.");
        String userName = input("# 이름: ");
        String userAge = input("# 나이: ");
        Gender gender = userGender();

        // 입력된 데이터를 저장시켜야 함.
       BookUser nowUser = new BookUser(userName, Integer.parseInt(userAge), gender, 0);
        LR.nowUser(nowUser);

    }

    // 성별을 정확히 입력할때까지 무한히 입력받고
    // 정확히 입력하면 해당 성별 문자를 리턴
   private Gender userGender () {
        while (true) {
            String inputGender = input("# 성별(M/F): ").toUpperCase();
            if (inputGender.startsWith("M")) {
                return Gender.MALE;
            } else if (inputGender.equals("F")) {
                return Gender.FEMALE;
            } else {
                System.out.println("# 성별을 잘못 입력했습니다.");
            }
        }

    }

   String  libraryMenu () {
        System.out.println("========== 도서 메뉴 ==========");
        System.out.println("# 1. 마이페이지");
        System.out.println("# 2. 도서 전체 조회");
        System.out.println("# 3. 도서 제목으로 검색");
        System.out.println("# 4. 도서 대여하기");
        System.out.println("# 5. 도서 저자이름으로 검색");
        System.out.println("# 9. 마이페이지");
        String menuNum = input("- 메뉴 번호: ");
        return menuNum;
    }

    void userInfo () {
        System.out.println("***** 회원님 정보 *****");
        System.out.println("# 회원명: " + user.getName());
        System.out.println("# 나이: " + user.getAge());
        System.out.println("# 성별: " + user.getGenderToString());
        System.out.println("# 쿠폰개수: " + user.getCouponCount());
    }

    void checkBookList () {
        System.out.println("\n ========== 전체 도서 목록 ==========");
        for (Book book : bookLists.getbArr() ) {
            System.out.println(book.info());
        }
    }

    void searchBookByBookName() {
        String userSearch = input("# 검색어 : ");
        boolean isHere = false;
        for(Book book : bookLists.getbArr()) {
            if(book.getTitle().contains(userSearch)) {
                System.out.println(book.DetailsInfo());
               if(!isHere) isHere = true;
            }
        }
        if(!isHere) System.out.println("# 검색 결과가 없습니다.");
    }

    void rentBook() {
        System.out.println("========== 대여 가능한 도서 목록 ==========");
        for (int i = 0; i < bookLists.getbArr().length ; i++) {
            System.out.println((i + 1) + ". " + bookLists.getbArr()[i].DetailsInfo());
        }
        int bookNum = Integer.parseInt(input("# 대여할 도서 번호 입력: "));
        RentStatus status = LibraryRepository.rentBook(bookNum);

        if(status == RentStatus.RENT_SUCCESS_WITH_COUPON) {
            System.out.println("# 도서가 쿠폰과 함께 성공적으로 대여되었습니다.");
        } else if (status == RentStatus.RENT_SUCCESS) {
            System.out.println("# 도서가 성공적으로 대여되었습니다.");
        } else {
            System.out.println("# 도서 대여에 실패했습니다.");
        }
//        Book seletedBook = bookLists.getbArr()[bookNum -1];
//        System.out.println("# 대여할 책 정보 : " + seletedBook.DetailsInfo());
//        bookCondition(seletedBook);
    }

    private void bookCondition (Book seletedBook) {
        if(seletedBook instanceof CartoonBook) {
            if (user.getAge() < ((CartoonBook) seletedBook).getAccessAge()) {
                System.out.println("# 나이가 너무 어립니다.");
                System.out.println("# 도서 대여에 실패하였습니다.");
            } else {
                System.out.println("# (만화책)도서가 성공적으로 대여되었습니다.");
            }
        } else {
            if(((CookBook) seletedBook).isCoupon()) {
                user.setCouponCount(user.getCouponCount() + 1);
                System.out.println("# 성공적으로 요리책이 쿠폰과 발급과 함께 대여되었습니다.");
            } else {
                System.out.println("# 요리책이 성공적으로 대여되었습니다.");
            }
        }
    }

    void searchBookByAuthor () {
        String userSearch = input("# 검색어 : ");
        boolean isHere = false;
        for(Book book : bookLists.getbArr()) {
            if(book.getAuthor().contains(userSearch)) {
                System.out.println(book.DetailsInfo());
                isHere = true;
            }
        }
        if(!isHere) System.out.println("# 검색 결과가 없습니다.");
    }
}
