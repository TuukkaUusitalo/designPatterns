
package map;

import tiles.Tile;

public abstract class Map {
    protected final int width;
    protected final int height;
    protected final Tile[][] tiles;

    public Map(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width/height must be > 0");
        }
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];

        // Filling in the boxes – createTile() is the Factory Method
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                tiles[r][c] = createTile();
            }
        }
    }

    // Factory Method, subclasses implement this
    protected abstract Tile createTile();

    // asking the tiles the character to display
    public void display() {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                System.out.print(tiles[r][c].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    // The boxes
    public void displayBoxed() {
        for (int c = 0; c < width; c++) System.out.print("+---");
        System.out.println("+");
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                System.out.print("| " + tiles[r][c].getCharacter() + " ");
            }
            System.out.println("|");
            for (int c = 0; c < width; c++) System.out.print("+---");
            System.out.println("+");
        }
    }
}
