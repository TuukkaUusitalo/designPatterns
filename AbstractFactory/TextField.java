package AbstractFactory;

abstract public class TextField {

    protected String text;

    public TextField(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    abstract public void display();
}
