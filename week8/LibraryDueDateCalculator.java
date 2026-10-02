import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    LibraryItem(String title) { this.title = title; }
    abstract int getBorrowDays();
    String getTitle() { return title; }
    LocalDate getDueDate(LocalDate today) { return today.plusDays(getBorrowDays()); }
}

class Book extends LibraryItem {
    Book(String t) { super(t); }
    int getBorrowDays() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String t) { super(t); }
    int getBorrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String t) { super(t); }
    int getBorrowDays() { return 3; }
}

public class LibraryDueDateCalculator {
    static LibraryItem create(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK": return new Book(title);
            case "DVD": return new DVD(title);
            default: return new Magazine(title);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.of(2023, 10, 26);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int idx = line.indexOf(' ');
            String type = line.substring(0, idx);
            String title = line.substring(idx + 1).trim().replaceAll("^\"|\"$", "");
            items.add(create(type, title));
        }
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate(today));
        }
        sc.close();
    }
}