public class LibraryManager {
    private final BookSearchService   search;
    private final BorrowingService    borrowing;
    private final FineCalculator      calculator;
    private final FineReportFormatter formatter;

    LibraryManager(BookSearchService s, BorrowingService b,
                   FineCalculator c, FineReportFormatter f) {
        this.search = s; this.borrowing = b; this.calculator = c; this.formatter = f;
    }

    public Book searchBook(String title)             { return search.findByTitle(title); }
    public BorrowRecord borrowBook(Member m, Book b) { return borrowing.borrow(m, b); }

    public String processReturn(String recordId) {
        BorrowRecord rec = borrowing.returnBook(recordId);
        return formatter.format(new FineReport(rec, calculator.calculate(rec)));
    }
}