package org.example;

public class PixelEditorModel {

    private static final int SIZE = 8;
    private final boolean[][] pixels = new boolean[SIZE][SIZE];
    private int cursorX = 0;
    private int cursorY = 0;

    public void moveCursor(int dx, int dy) {
        cursorX = Math.max(0, Math.min(SIZE - 1, cursorX + dx));
        cursorY = Math.max(0, Math.min(SIZE - 1, cursorY + dy));
    }

    public void togglePixel() {
        pixels[cursorY][cursorX] = !pixels[cursorY][cursorX];
    }

    public boolean[][] getPixels() {
        return pixels;
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }
}
