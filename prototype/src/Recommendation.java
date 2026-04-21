import java.util.ArrayList;
import java.util.List;

public class Recommendation {

    private String targetAudience;
    private List<Book> recommendedBooks;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.recommendedBooks = new ArrayList<>();
    }

    public Recommendation clone() {
        Recommendation cloned = new Recommendation(this.targetAudience);
        for (Book book : this.recommendedBooks) {
            cloned.recommendedBooks.add(book.clone()); // for deep copy
        }
        return cloned;
    }

    public void addBook(Book book) {
        recommendedBooks.add(book);
    }

    public void removeBook(Book book) {
        recommendedBooks.remove(book);
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getRecommendedBooks() {
        return recommendedBooks;
    }

    @Override
    public String toString() {
        return "Target audience: " + targetAudience + "\nBooks: " + recommendedBooks;
    }
}
