import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> books = List.of(new Book("1", "Clean Code"));

        LibraryManager manager = new LibraryManager(
            new BookSearchServiceImpl(books),
            new BorrowingServiceImpl(),
            new StandardFineCalculator(),
            new PlainTextFormatter()
        );

        Member member    = new Member("M01", "Yosafat");
        Book book        = manager.searchBook("Clean Code");
        BorrowRecord rec = manager.borrowBook(member, book);
        System.out.println(manager.processReturn(rec.recordId));
    }
}