import java.nio.file.Files;
import java.nio.file.Path;

public class BookStoreSmokeTest {
    public static void main(String[] args) throws Exception {
        BookStore store = new BookStore();
        store.addBook("Example", 12.5);
        store.addBook("example", 99);
        if (store.getBooks().size() != 1) throw new AssertionError("Duplicate book");
        store.addCustomer("demo", "test-only");
        Customer customer = store.loginCustomer("demo", "test-only");
        if (customer == null || !customer.getStatus().equals("Silver")) throw new AssertionError("Login/state");
        customer.addPoints(1200);
        if (!customer.getStatus().equals("Gold")) throw new AssertionError("Gold state");
        customer.redeemPoints(300);
        if (!customer.getStatus().equals("Silver") || customer.getPoints() != 900) throw new AssertionError("Redeem/state");
        Path books = Files.createTempFile("bookstore-books-", ".txt");
        Path customers = Files.createTempFile("bookstore-customers-", ".txt");
        try {
            DataStore.saveBooks(store.getBooks(), books.toString());
            DataStore.saveCustomers(store.getCustomers(), customers.toString());
            BookStore restored = new BookStore();
            DataStore.loadBooks(restored, books.toString());
            DataStore.loadCustomers(restored, customers.toString());
            if (restored.getBooks().size() != 1 || restored.getCustomers().size() != 1 || restored.getCustomers().get(0).getPoints() != 900)
                throw new AssertionError("Persistence");
        } finally {
            Files.deleteIfExists(books);
            Files.deleteIfExists(customers);
        }
        System.out.println("BookStore smoke checks passed.");
    }
}
