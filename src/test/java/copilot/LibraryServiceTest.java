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
        // Arrange
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = currentYear - 5;
        int issn = faker.random().nextInt(500, 1000);

        // Act
        AuthorBookPair actual = libraryService.createAuthorAndBook(firstName, lastName, age, title, year, issn);

        // Assert
        assertEquals(firstName, actual.getAuthor().getFirstName());
        assertEquals(lastName, actual.getAuthor().getLastName());
        assertEquals(age, actual.getAuthor().getAge());
        assertEquals(title, actual.getBook().getTitle());
        assertEquals(year, actual.getBook().getYear());
        assertEquals(issn, actual.getBook().getIssn());
    }

    @Test
    public void testCreateAuthorAndBookInvalidInput() {
        // Arrange
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = currentYear + 5;
        int issn = faker.random().nextInt(1, 100);

        // Act and Assert
        try {
            libraryService.createAuthorAndBook(firstName, lastName, age, title, year, issn);
        } catch (IllegalArgumentException e) {
            assertEquals("Year in the future", e.getMessage());
        }
    }

    @Test
    public void testCreateBook() {
        // Arrange
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = currentYear - 5;
        int issn = faker.random().nextInt(1, 100);
        Author author = libraryService.createAuthor(firstName, lastName, age);

        // Act
        Book actual = libraryService.createBook(title, author, year, issn);

        // Assert
        assertEquals(title, actual.getTitle());
        assertEquals(author, actual.getAuthor());
        assertEquals(year, actual.getYear());
        assertEquals(issn, actual.getIssn());
    }

    @Test
    public void testCreateBookInvalidYear() {
        // Arrange
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = currentYear + 5;
        int issn = faker.random().nextInt(1, 100);
        Author author = libraryService.createAuthor(firstName, lastName, age);

        // Act and Assert
        try {
            libraryService.createBook(title, author, year, issn);
        } catch (IllegalArgumentException e) {
            assertEquals("Year in the future", e.getMessage());
        }
    }

    @Test
    public void testCreateBookInvalidYearZero() {
        // Arrange
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(20, 80);
        String title = faker.name().title();
        int year = 0;
        int issn = faker.random().nextInt(1, 100);
        Author author = libraryService.createAuthor(firstName, lastName, age);

        // Act and Assert
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

        // Act
        Author actual = libraryService.createAuthor(firstName, lastName, age);

        // Assert
        assertEquals(firstName, actual.getFirstName());
        assertEquals(lastName, actual.getLastName());
        assertEquals(age, actual.getAge());
    }

    @Test
    public void testCreateAuthorInvalidAge() {
        // Arrange
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.random().nextInt(-80, 0);

        // Act and Assert
        try {
            libraryService.createAuthor(firstName, lastName, age);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid age", e.getMessage());
        }
    }

    @Test
    public void testCurrentYear() {
        // Act
        int actual = libraryService.currentYear();

        // Assert
        assertEquals(currentYear, actual);
    }


    






}