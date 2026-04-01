import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private final String keyword;
    private final List<File> results = new ArrayList<>();

    public SearchVisitor(String keyword) {
        this.keyword = keyword;
    }

    public List<File> getResults() {
        return results;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(keyword)) {
            results.add(file);
        }
    }

    @Override
    public void visit(Directory dir) {
        // nothing special here
    }
}