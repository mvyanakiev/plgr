package copilot;

import java.time.LocalDate;

public class LibraryService {

    public AuthorBookPair createAuthorAndBook(String firstName, String lastName, int age, String title, int year, int issn) {
        Author author = createAuthor(firstName, lastName, age);
        Book book = createBook(title, author, year, issn);
        return new AuthorBookPair(author, book);
    }

    public Book createBook(String title, Author author, int year, int issn) {
        int currentYear = currentYear();
        if (year <= 0) {
            throw new IllegalArgumentException("Negative or zero year");
        }
        if (year > currentYear) {
            throw new IllegalArgumentException("Year in the future");
        }

        return new Book(title, author, year, issn);
    }

    public Author createAuthor(String firstName, String lastName, int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        return new Author(firstName, lastName, age);
    }

    protected int currentYear() {
        return LocalDate.now().getYear();
    }
}
