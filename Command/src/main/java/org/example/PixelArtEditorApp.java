package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditorApp extends Application {

    private final PixelEditorModel model = new PixelEditorModel();
    private final Rectangle[][] cells = new Rectangle[8][8];

    @Override
    public void start(Stage stage) {
        GridPane grid = createGrid();

        Button generateCodeButton = new Button("Create Code");
        generateCodeButton.setOnAction(e ->
                new GenerateCodeCommand(model).execute()
        );

        BorderPane root = new BorderPane();
        root.setCenter(grid);
        root.setBottom(generateCodeButton);

        Scene scene = new Scene(root, 320, 360);
        scene.setOnKeyPressed(e -> {
            Command command = switch (e.getCode()) {
                case UP -> () -> model.moveCursor(0, -1);
                case DOWN -> () -> model.moveCursor(0, 1);
                case LEFT -> () -> model.moveCursor(-1, 0);
                case RIGHT -> () -> model.moveCursor(1, 0);
                case SPACE -> new TogglePixelCommand(model);
                default -> null;
            };

            if (command != null) {
                command.execute();
                redraw();
            }
        });

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        redraw();
        root.requestFocus();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rect = new Rectangle(35, 35);
                rect.setStroke(Color.LIGHTGRAY);
                rect.setFill(Color.WHITE);

                cells[y][x] = rect;
                grid.add(new StackPane(rect), x, y);
            }
        }
        return grid;
    }

    private void redraw() {
        boolean[][] pixels = model.getPixels();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle r = cells[y][x];
                r.setFill(pixels[y][x] ? Color.BLACK : Color.WHITE);
                r.setStroke(Color.LIGHTGRAY);
            }
        }

        // Visuaalinen kursori
        cells[model.getCursorY()][model.getCursorX()]
                .setStroke(Color.RED);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
