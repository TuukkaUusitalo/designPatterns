package app;

public class Message {

    public MessageType type;
    public String content;
    public String sendersEmail;

    public enum MessageType {
        COMPENSATION_CLAIM, CONTACT_REQUEST, DEVELOPMENT_SUGGESTION, GENERAL_FEEDBACK
    }
}
