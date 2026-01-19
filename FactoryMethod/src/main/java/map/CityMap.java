package map;

import tiles.BuildingTile;
import tiles.ForestTile;
import tiles.RoadTile;
import tiles.Tile;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CityMap extends Map {

    public CityMap(int width, int height) {
        super(width, height);
    }


    @Override
    protected Tile createTile() {
        int r = ThreadLocalRandom.current().nextInt(3); // 0..2
        switch (r) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            default:
                return new BuildingTile();
        }
    }
}
