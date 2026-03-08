package handlers;

import app.Message;

public class DevelopmentSuggestionHandler extends AbstractHandler {
    @Override
    public String handle(Message msg) {
        if (msg.type == Message.MessageType.DEVELOPMENT_SUGGESTION) {
            return "Development suggestion logged: \"" + msg.content + "\" (from "
                    + msg.sendersEmail + ")";
        }
        return forward(msg);
    }
}

