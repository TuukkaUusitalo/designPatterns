public class NoviceState implements State {

    @Override
    public String name() { return "Novice"; }

    @Override
    public void showActions() {
        System.out.println("Activities available: [T]rain");
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("* Training (Novice).");
        c.gainXp(20);
        // HP doesn't change
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("Cannot meditate (Novice).");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("Cannot fight (Novice).");
    }
}