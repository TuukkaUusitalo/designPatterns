public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String genre;

    public Book(String title, String author, int publicationyear, String genre) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publicationYear = publicationyear;
    }

    public Book clone() {
        return new Book(this.title, this.author, this.publicationYear, this.genre);
    }

    public String toString() {
        return title + " by " + author + " (" + publicationYear + ", " + genre + ")";
    }

}
