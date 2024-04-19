package day09.book;


// 역할 : 도서관리 앱에서 사용하는 데이터들을 관리하는 객체
// 관리할 데이터: 우리 회원이 누구? 우리는 어떤책들을 갖고 있는가?
public class LibraryRepository {
    static BookList bookLists; // 책은 여러개
    static BookUser user; // 회원은 한명

    // 정적 초기화자 : static 필드 초기값 설정
    static {
        bookLists = new BookList();

        bookLists.addBookList(new CookBook("기적의 집밥책", "김해진", "청림라이프", true));
        bookLists.addBookList(new CartoonBook("떨어지면 끝장맨", "스에노부 케이코", "대원씨아이", 18));
        bookLists.addBookList( new CartoonBook("원펀맨", "One", "대원씨아이", 15));
        bookLists.addBookList(new CookBook("삐뽀삐뽀 119 이유식", "하정훈", "유니책방", false));
        bookLists.addBookList(new CookBook("오늘은 아무래도 덮밥", "이마이 료", "참돌", true));
        bookLists.addBookList( new CartoonBook("이세계로 전이했으니 치트를 살려 마법검사가 되기로 했다", "Shinkoshoto", "대원씨아이", 12));
    }

    public static RentStatus rentBook(int bookNum) {

        // 1. 책번호에 해당하는 책 가져오기
        Book wishBook = bookLists.getbArr()[bookNum - 1];
        // 2. 이 책을 대여할 수 있는지 검증
        // 2-1. 요리책일 경우
        if(wishBook instanceof CookBook) {

            CookBook cookBook = (CookBook) wishBook;
            if (cookBook.isCoupon()) {
                // 3. 쿠폰 유무를 확인
                user.setCouponCount(user.getCouponCount() + 1);
                return RentStatus.RENT_SUCCESS_WITH_COUPON;
            } else {
                return RentStatus.RENT_SUCCESS;
            }
        }
        // 2-2. 만화책일 경우
        else if (wishBook instanceof CartoonBook) {

            CartoonBook cartoonBook = (CartoonBook) wishBook;
            if(user.getAge() >= cartoonBook.getAccessAge()) {
                return RentStatus.RENT_SUCCESS;
            } else {
                return RentStatus.RENT_FAIL;
            }
        }
        return RentStatus.RENT_FAIL;
    }


    public void nowUser (BookUser user) {
        LibraryRepository.user = user;
    }

}
