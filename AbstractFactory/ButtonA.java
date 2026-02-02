package AbstractFactory;

public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }
    public void display() {
        System.out.println("--------------");
        System.out.println("|  Button A  |");
        System.out.println("--------------");
    }
}
