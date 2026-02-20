public interface State {
    String name();
    void showActions();
    void train(GameCharacter c);
    void meditate(GameCharacter c);
    void fight(GameCharacter c);
}