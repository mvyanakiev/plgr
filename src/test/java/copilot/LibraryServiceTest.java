package copilot;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

class LibraryServiceTest {

    private static final Faker faker = new Faker();

    private LibraryService libraryService;
    private int currentYear;

    @BeforeEach
    public void setUp() {
        libraryService = new LibraryService();
        currentYear = LocalDate.now().getYear();
    }

    @Test
    public void testCreateAuthorAndBook() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = currentYear - 5;
        int issn = faker.random().nextInt(500, 1000);

        AuthorBookPair actual = libraryService.createAuthorAndBook(firstName, lastName, age, title, year, issn);

        assertEquals(firstName, actual.getAuthor().getFirstName());
        assertEquals(lastName, actual.getAuthor().getLastName());
        assertEquals(age, actual.getAuthor().getAge());
        assertEquals(title, actual.getBook().getTitle());
        assertEquals(year, actual.getBook().getYear());
        assertEquals(issn, actual.getBook().getIssn());
    }

    @Test
    public void testCreateAuthorAndBookInvalidInput() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = currentYear + 5;
        int issn = faker.random().nextInt(1, 100);

        try {
            libraryService.createAuthorAndBook(firstName, lastName, age, title, year, issn);
        } catch (IllegalArgumentException e) {
            assertEquals("Year in the future", e.getMessage());
        }
    }

    @Test
    public void testCreateBook() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = currentYear - 5;
        int issn = faker.random().nextInt(1, 100);
        Author author = libraryService.createAuthor(firstName, lastName, age);

        Book actual = libraryService.createBook(title, author, year, issn);

        assertEquals(title, actual.getTitle());
        assertEquals(author, actual.getAuthor());
        assertEquals(year, actual.getYear());
        assertEquals(issn, actual.getIssn());
    }

    @Test
    public void testCreateBookInvalidYear() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = currentYear + 5;
        int issn = faker.random().nextInt(1, 100);
        Author author = libraryService.createAuthor(firstName, lastName, age);

        try {
            libraryService.createBook(title, author, year, issn);
        } catch (IllegalArgumentException e) {
            assertEquals("Year in the future", e.getMessage());
        }
    }

    @Test
    public void testCreateBookInvalidYearZero() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = 0;
        int issn = faker.random().nextInt(1, 100);
        Author author = libraryService.createAuthor(firstName, lastName, age);

        try {
            libraryService.createBook(title, author, year, issn);
        } catch (IllegalArgumentException e) {
            assertEquals("Negative or zero year", e.getMessage());
        }
    }

    @Test
    public void testCreateAuthor() {
        // Arrange
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);

        Author actual = libraryService.createAuthor(firstName, lastName, age);

        assertEquals(firstName, actual.getFirstName());
        assertEquals(lastName, actual.getLastName());
        assertEquals(age, actual.getAge());
    }

    @Test
    public void testCreateAuthorInvalidAge() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(-80, 0);

        try {
            libraryService.createAuthor(firstName, lastName, age);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid age", e.getMessage());
        }
    }

    @Test
    public void testCurrentYear() {
        int actual = libraryService.currentYear();
        assertEquals(currentYear, actual);
    }


    






}