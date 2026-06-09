import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

class BookSearchServiceImpl implements BookSearchService {
    private List<Book> books;
    BookSearchServiceImpl(List<Book> books) { this.books = books; }

    @Override
    public Book findByTitle(String title) {
        return books.stream()
            .filter(b -> b.title.equalsIgnoreCase(title))
            .findFirst().orElse(null);
    }
}

class BorrowingServiceImpl implements BorrowingService {
    private Map<String, BorrowRecord> records = new HashMap<>();

    @Override
    public BorrowRecord borrow(Member member, Book book) {
        BorrowRecord rec = new BorrowRecord(
            UUID.randomUUID().toString(), book, member, LocalDate.now().plusDays(7)
        );
        book.isAvailable = false;
        records.put(rec.recordId, rec);
        return rec;
    }

    @Override
    public BorrowRecord returnBook(String recordId) {
        BorrowRecord rec = records.get(recordId);
        rec.returnDate = LocalDate.now();
        rec.book.isAvailable = true;
        return rec;
    }
}

class StandardFineCalculator implements FineCalculator {
    @Override
    public double calculate(BorrowRecord record) {
        long days = ChronoUnit.DAYS.between(record.dueDate, record.returnDate);
        return days > 0 ? days * 1000.0 : 0;
    }
}

class PlainTextFormatter implements FineReportFormatter {
    @Override
    public String format(FineReport report) {
        return "Buku: " + report.record.book.title +
               " | Anggota: " + report.record.member.name +
               " | Denda: Rp" + report.totalFine;
    }
}