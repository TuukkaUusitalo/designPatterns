package controller;

import model.Memento;
import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private final List<Memento> history = new ArrayList<>();

    public void add(Memento m) {
        history.add(m);
    }

    public List<Memento> getHistory() {
        return history;
    }
}