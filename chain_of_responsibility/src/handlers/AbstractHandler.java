package handlers;

import app.Message;

public abstract class AbstractHandler implements Handler {
    private Handler next;

    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next; // chaining a.setNext(b).setNext(c)...
    }

    protected String forward(Message msg) {
        if (next != null) return next.handle(msg);
        return "No suitable handler for: " + msg.type + " (from " + msg.sendersEmail + ")";
    }
}
