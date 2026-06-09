import java.time.LocalDate;

class Book {
    String id, title;
    boolean isAvailable = true;
    Book(String id, String title) { this.id = id; this.title = title; }
}

class Member {
    String memberId, name;
    Member(String memberId, String name) { this.memberId = memberId; this.name = name; }
}

class BorrowRecord {
    String recordId;
    Book book;
    Member member;
    LocalDate dueDate, returnDate;
    BorrowRecord(String id, Book b, Member m, LocalDate due) {
        this.recordId = id; this.book = b; this.member = m; this.dueDate = due;
    }
}

class FineReport {
    BorrowRecord record;
    double totalFine;
    FineReport(BorrowRecord r, double f) { this.record = r; this.totalFine = f; }
}