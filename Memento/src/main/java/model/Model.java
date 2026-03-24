package model;

import javafx.scene.paint.Color;

public class Model {

    private Color c1, c2, c3;
    private boolean checked;

    public void setState(Color a, Color b, Color c, boolean check) {
        this.c1 = a;
        this.c2 = b;
        this.c3 = c;
        this.checked = check;
    }

    public Memento saveStateToMemento() {
        return new Memento(c1, c2, c3, checked);
    }
}