interface BookSearchService {
    Book findByTitle(String title);
}

interface BorrowingService {
    BorrowRecord borrow(Member member, Book book);
    BorrowRecord returnBook(String recordId);
}

interface FineCalculator {
    double calculate(BorrowRecord record);
}

interface FineReportFormatter {
    String format(FineReport report);
}