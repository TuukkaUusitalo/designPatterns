public class Main {
    public static void main(String[] args) {

        // recommendations
        Recommendation youngAdults = new Recommendation("Young Adults");
        Recommendation economics = new Recommendation("Entrepreneurs");

        // books
        youngAdults.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy"));
        youngAdults.addBook(new Book("Dune", "Frank Herbert", 1965, "Sci-Fi"));
        economics.addBook(new Book("Woltin tarina", "Boxberg Katja, Salminen Merina", 2025, "Economic literature"));

        System.out.println("Original recommendation:");
        System.out.println(youngAdults);

        Recommendation SciFi = youngAdults.clone();
        SciFi.setTargetAudience("Sci-Fi Fans");
        SciFi.addBook(new Book("Neuromancer", "William Gibson", 1984, "Cyberpunk"));

        Recommendation Economic = economics.clone();
        Economic.setTargetAudience("Economics Enthusiasts");

        System.out.println("\nCloned and modified recommendation:");
        System.out.println(SciFi);
        System.out.println();

        System.out.println("\nOriginal remains unchanged:");
        System.out.println(youngAdults);

        System.out.println();
        System.out.println(Economic);
    }
}