package handlers;

import app.Message;

public class ContactRequestHandler extends AbstractHandler {
    @Override
    public String handle(Message msg) {
        if (msg.type == Message.MessageType.CONTACT_REQUEST) {
            return "Contact request forwarded to customer service (" + msg.sendersEmail + "): \""
                    + msg.content + "\"";
        }
        return forward(msg);
    }
}

