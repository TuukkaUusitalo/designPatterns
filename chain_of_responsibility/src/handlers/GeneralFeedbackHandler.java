package handlers;

import app.Message;

public class GeneralFeedbackHandler extends AbstractHandler {
    @Override
    public String handle(Message msg) {
        if (msg.type == Message.MessageType.GENERAL_FEEDBACK) {
            return "General feedback stored and queued for analysis: \""
                    + msg.content + "\" (from " + msg.sendersEmail + ")";
        }
        return forward(msg);
    }
}