public class DocumentProxy implements DocumentInterface {

    private final String id;
    private final String creationDate;

    private Document realDocument;  // loaded on demand
    private final AccessControlService access = AccessControlService.getInstance();

    private final boolean protectedDocument;
    private final String content;

    public DocumentProxy(String id, String creationDate, String content, boolean protectedDocument) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
        this.protectedDocument = protectedDocument;
    }

    private void loadRealDocument() {
        if (realDocument == null) {
            realDocument = new Document(id, creationDate, content);
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (protectedDocument && !access.isAllowed(user.getUsername(), id)) {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }

        loadRealDocument();
        return realDocument.getContent(user);
    }
}