public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // create documents
        library.addUnprotectedDocument("doc1", "2024-01-01", "Public content");
        library.addProtectedDocument("doc2", "2024-01-02", "Secret content");

        // create users
        User user1 = new User("user1");
        User user2 = new User("user2");

        // give user1 access to doc2, not user2
        AccessControlService.getInstance().allowAccess("user1", "doc2");

        try {
            System.out.println("User1 reads doc1: " +
                    library.getDocument("doc1").getContent(user1));

            System.out.println("User1 reads doc2: " +
                    library.getDocument("doc2").getContent(user1));

            System.out.println("User2 reads doc1: " +
                    library.getDocument("doc1").getContent(user2));

            System.out.println("User2 reads doc2: " +
                    library.getDocument("doc2").getContent(user2));

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}