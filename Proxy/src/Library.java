import java.util.HashMap;
import java.util.Map;

public class Library {

    private final Map<String, DocumentInterface> documents = new HashMap<>();

    // Factory: unprotected document
    public void addUnprotectedDocument(String id, String creationDate, String content) {
        documents.put(id, new Document(id, creationDate, content));
    }

    // Factory: protected document
    public void addProtectedDocument(String id, String creationDate, String content) {
        documents.put(id, new DocumentProxy(id, creationDate, content, true));
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}