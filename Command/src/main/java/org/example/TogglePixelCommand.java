package org.example;

public class TogglePixelCommand implements Command {

    private final PixelEditorModel model;

    public TogglePixelCommand(PixelEditorModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.togglePixel();
    }
}
