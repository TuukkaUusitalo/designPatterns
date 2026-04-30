package org.example;

public class GenerateCodeCommand implements Command {

    private final PixelEditorModel model;

    public GenerateCodeCommand(PixelEditorModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        boolean[][] p = model.getPixels();

        System.out.println("int[][] pixelArt = {");
        for (int y = 0; y < p.length; y++) {
            System.out.print("    {");
            for (int x = 0; x < p[y].length; x++) {
                System.out.print(p[y][x] ? "1" : "0");
                if (x < p[y].length - 1) System.out.print(", ");
            }
            System.out.println("}" + (y < p.length - 1 ? "," : ""));
        }
        System.out.println("};");
    }
}
