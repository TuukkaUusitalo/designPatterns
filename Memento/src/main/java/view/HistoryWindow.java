package view;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Memento;

import java.util.List;
import java.util.function.Consumer;

public class HistoryWindow {

    private final Stage stage = new Stage();

    public HistoryWindow(List<Memento> history, Consumer<Memento> onSelected) {
        ListView<Memento> listView = new ListView<>();
        listView.getItems().addAll(history);

        listView.setOnMouseClicked(e -> {
            Memento m = listView.getSelectionModel().getSelectedItem();
            if (m != null) {
                onSelected.accept(m);
                stage.close();
            }
        });

        VBox root = new VBox(listView);
        stage.setScene(new Scene(root, 300, 400));
    }

    public void show() {
        stage.show();
    }
}