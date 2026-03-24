package controller;

import model.Model;
import model.Memento;
import view.HistoryWindow;

import java.util.function.Consumer;

public class MainController {

    private final Model model;
    private final Caretaker caretaker;

    public MainController(Model model, Caretaker caretaker) {
        this.model = model;
        this.caretaker = caretaker;
    }

    public void saveState() {
        caretaker.add(model.saveStateToMemento());
    }

    public void showHistoryWindow(Consumer<Memento> onSelected) {
        HistoryWindow hw = new HistoryWindow(caretaker.getHistory(), onSelected);
        hw.show();
    }
}