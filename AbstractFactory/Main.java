package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory a_factory = new AFactory();
        UIFactory b_factory = new BFactory();

        Button buttonB = b_factory.createButton("Button B");
        buttonB.display();

        Checkbox checkBoxA = b_factory.createCheckbox("Checkbox B");
        checkBoxA.display();

        TextField textFieldA = a_factory.createTextField("TextField A");
        textFieldA.display();
    }
}
