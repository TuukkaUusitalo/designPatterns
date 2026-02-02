package AbstractFactory;

public abstract class Button {
    protected String text;

    public Button(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    abstract public void display();
}
