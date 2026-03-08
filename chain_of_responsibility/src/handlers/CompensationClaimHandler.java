package handlers;

import app.Message;

public class CompensationClaimHandler extends AbstractHandler {
    @Override
    public String handle(Message msg) {
        if (msg.type == Message.MessageType.COMPENSATION_CLAIM) {
            return "Compensation claim: " + msg.sendersEmail
                    + ": \"" + msg.content + "\" --> moved to claims review.";
        }
        return forward(msg);
    }
}

