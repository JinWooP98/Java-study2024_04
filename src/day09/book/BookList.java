package day09.book;

public class BookList extends Book{

    private Book[] bArr;

    public BookList () {
        this.bArr = new Book[0];
    }

    public void addBookList(Book book) {
        Book[] temp = new Book[bArr.length + 1];
        for (int i = 0; i < bArr.length; i++) {
            temp[i] = bArr[i];
        }
        temp[temp.length -1] = book;
        bArr = temp;
    }

    public Book[] getbArr() {
        return bArr;
    }

//    public Book[] get(int index) {
//            return bArr[index];
//    }
}
