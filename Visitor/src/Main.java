public class Main {

    public static void main(String[] args) {

        // directory structure
        Directory root = new Directory("root");

        root.add(new File("notes.txt", 2));
        root.add(new File("image.png", 5));

        Directory sub = new Directory("docs");
        sub.add(new File("report.pdf", 10));
        sub.add(new File("summary.txt", 1));

        root.add(sub);

        // Visitor 1: Calculate total size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("Total size = " + sizeVisitor.getTotalSize() + " MB");

        // Visitor 2: Search for ".txt"
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);

        System.out.println("Search results:");
        for (File f : searchVisitor.getResults()) {
            System.out.println("  " + f.getName());
        }
    }
}