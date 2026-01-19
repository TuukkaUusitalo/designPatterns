abstract public class Checkbox {

    protected String text;

    public Checkbox(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    abstract public void display();
}
