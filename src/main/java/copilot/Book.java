package copilot;

public class Book {
    private String title;
    private Author author;
    private int year;
    private int issn;

    public Book(String title, Author author, int year, int issn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.issn = issn;
    }

    public Book() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }
}
