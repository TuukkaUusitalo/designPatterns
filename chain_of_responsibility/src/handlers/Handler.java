package handlers;

import app.Message;

public interface Handler {
    Handler setNext(Handler next);
    String handle(Message msg);
}