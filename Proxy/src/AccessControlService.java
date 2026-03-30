import java.util.HashSet;
import java.util.Set;

public class AccessControlService {

    private static AccessControlService instance;

    // Set of allowed (username:documentId)
    private final Set<String> accessList = new HashSet<>();

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String username, String documentId) {
        accessList.add(username + ":" + documentId);
    }

    public boolean isAllowed(String username, String documentId) {
        return accessList.contains(username + ":" + documentId);
    }
}