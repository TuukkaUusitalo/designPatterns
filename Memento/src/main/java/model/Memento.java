package model;

import javafx.scene.paint.Color;

public class Memento {

    private final Color c1, c2, c3;
    private final boolean checked;
    private final String timestamp;

    public Memento(Color c1, Color c2, Color c3, boolean checked) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.checked = checked;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public Color getColor1() {
        return c1;
    }
    public Color getColor2() {
        return c2;
    }
    public Color getColor3() {
        return c3;
    }
    public boolean isChecked() {
        return checked;
    }

    @Override
    public String toString() {
        return "Saved: " + timestamp;
    }
}