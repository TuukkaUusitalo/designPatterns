package map;

public class Printer {

    int width = 5;
    int height = 5;



    public void printMap(int width, int height){
        for (int i = 0; i < width; i++) {
            System.out.print("+-----");
        }
        System.out.println("+");
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                System.out.print("|  W  ");
            }
            System.out.println("|");

            for (int j = 0; j < width; j++) {
                System.out.print("+-----");
            }
            System.out.println("+");
        }
    }

//    public static void main(String[] args) {
//        Printer p = new Printer();
//        for (int y = 0; y < 1; y++) {
//            p.printMap(p.width,  p.height);
//        }
//
//    }



}
