import app.Message;
import handlers.Handler;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Handler chain = new handlers.CompensationClaimHandler();
        chain.setNext(new handlers.ContactRequestHandler())
                .setNext(new handlers.DevelopmentSuggestionHandler())
                .setNext(new handlers.GeneralFeedbackHandler());

        // exaple messages, different types
        Message m1 = new Message();
        m1.type = Message.MessageType.COMPENSATION_CLAIM;
        m1.content = "Food was cold, requesting compensation.";
        m1.sendersEmail = "a@a.com";

        Message m2 = new Message();
        m2.type = Message.MessageType.CONTACT_REQUEST;
        m2.content = "Please call me back";
        m2.sendersEmail = "b@b.com";

        Message m3 = new Message();
        m3.type = Message.MessageType.DEVELOPMENT_SUGGESTION;
        m3.content = "Add dark mode to the app.";
        m3.sendersEmail = "c@c.com";

        Message m4 = new Message();
        m4.type = Message.MessageType.GENERAL_FEEDBACK;
        m4.content = "Great service!";
        m4.sendersEmail = "d@d.com";

        // sending messages through the chain, printing results
        List<Message> all = List.of(m1, m2, m3, m4);
        for (Message msg : all) {
            String result = chain.handle(msg);
            System.out.println(result);
        }
    }
}