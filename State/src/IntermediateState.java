public class IntermediateState implements State {

    @Override
    public String name() { return "Intermediate"; }

    @Override
    public void showActions() {
        System.out.println("All activities: [T]rain, [M]editate");
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("* Practicing (Intermediate).");
        c.gainXp(25);
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("* Meditating (Intermediate).");
        c.changeHp(+15);
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("Can't fight on this level (Intermediate).");
    }
}
