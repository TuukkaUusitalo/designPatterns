import map.CityMap;
import map.WildernessMap;
import map.Map;

import java.util.Scanner;

public class Game {

    public static Map createMap() {
        Scanner mapType = new Scanner(System.in);

        System.out.println("Create a City Map or a Wilderness Map.");
        System.out.println("C = City Map");
        System.out.println("W = Wilderness Map");
        System.out.print("Your choice: ");

        String input = mapType.nextLine().toUpperCase();

        int width = 10;
        int height = 10;

        if (input.equals("C")) {
            System.out.println("City map selected");
            return new CityMap(width, height);
        } else if (input.equals("W")) {
            System.out.println("Wilderness map selected");
            return new WildernessMap(width, height);
        } else {
            System.out.println("Invalid map type selected. Defaulting to Wilderness Map.");
        }
        return new WildernessMap(width, height);
    }


    public static void main(String[] args) {
        System.out.println("Map tile game!");

        Map map = createMap();
        //map.display();
        map.displayBoxed();
    }
}


