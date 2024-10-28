package copilot;

public class AuthorBookPair {

    private Author author;
    private Book book;

    public AuthorBookPair(Author author, Book book) {
        this.author = author;
        this.book = book;
    }

    public AuthorBookPair() {}

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
