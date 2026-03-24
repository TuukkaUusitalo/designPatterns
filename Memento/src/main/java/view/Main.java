package view;

import controller.Caretaker;
import controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Model;

public class Main extends Application {

    private MainController controller;

    @Override
    public void start(Stage stage) {

        // model and caretaker
        Model model = new Model();
        Caretaker caretaker = new Caretaker();
        controller = new MainController(model, caretaker);

        // three colors
        Rectangle r1 = new Rectangle(200, 50, Color.LIGHTGRAY);
        Rectangle r2 = new Rectangle(200, 50, Color.LIGHTGRAY);
        Rectangle r3 = new Rectangle(200, 50, Color.LIGHTGRAY);

        CheckBox check = new CheckBox("Check");

        // buttons
        Button historyBtn = new Button("Show History");
        Button greenBtn = new Button("Make first green");
        Button redBtn   = new Button("Make second red");
        Button blueBtn  = new Button("Make third blue");

        // logic
        greenBtn.setOnAction(e -> {
            r1.setFill(Color.GREEN);
            model.setState(Color.GREEN, (Color) r2.getFill(), (Color) r3.getFill(), check.isSelected());
            controller.saveState();
        });

        redBtn.setOnAction(e -> {
            r2.setFill(Color.RED);
            model.setState((Color) r1.getFill(), Color.RED, (Color) r3.getFill(), check.isSelected());
            controller.saveState();
        });

        blueBtn.setOnAction(e -> {
            r3.setFill(Color.BLUE);
            model.setState((Color) r1.getFill(), (Color) r2.getFill(), Color.BLUE, check.isSelected());
            controller.saveState();
        });

        check.setOnAction(e -> {
            model.setState((Color) r1.getFill(), (Color) r2.getFill(), (Color) r3.getFill(), check.isSelected());
            controller.saveState();
        });

        historyBtn.setOnAction(e -> controller.showHistoryWindow((memento) -> {
            // returning the ui
            r1.setFill(memento.getColor1());
            r2.setFill(memento.getColor2());
            r3.setFill(memento.getColor3());
            check.setSelected(memento.isChecked());
        }));

        // Layout
        VBox root = new VBox(10, r1, r2, r3, check, greenBtn, redBtn, blueBtn, historyBtn);

        stage.setScene(new Scene(root, 300, 400));
        stage.setTitle("Memento History Demo");
        stage.show();

        // save initial state
        controller.saveState();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}