
package map;

import tiles.ForestTile;
import tiles.SwampTile;
import tiles.Tile;
import tiles.WaterTile;

import java.util.concurrent.ThreadLocalRandom;

public class WildernessMap extends Map {

    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int r = ThreadLocalRandom.current().nextInt(3); // 0..2
        switch (r) {
            case 0:
                return new ForestTile();
            case 1:
                return new SwampTile();
            default:
                return new WaterTile();
        }
    }
}
