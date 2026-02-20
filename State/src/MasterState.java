public class MasterState implements State {

    @Override
    public String name() { return "Master"; }

    @Override
    public void showActions() {
        System.out.println("Game over. You are master now.");
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You are a master now. No need to train more.");
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("You are a master. No need to meditate.");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("You are a master. No need to fight.");
    }
}