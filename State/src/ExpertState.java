public class ExpertState implements State {

    @Override
    public String name() { return "Expert"; }

    @Override
    public void showActions() {
        System.out.println("These are the activities: [T]rain, [M]editate, [F]ight");
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("* Practicing as a master (Expert).");
        c.gainXp(30);
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("* Meditating strongly (Expert).");
        c.changeHp(+10);
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("* To fight! (Expert).");
        int damage = 20;
        int xpGain = 50;
        c.changeHp(-damage);   // voi pudota nollaan
        if (c.isDead()) {
            System.out.println("You have passed out..");
        }
        c.gainXp(xpGain);
    }
}