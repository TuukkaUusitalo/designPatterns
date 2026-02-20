public class GameCharacter {
    private final String name;
    private int xp;
    private int hp;
    private final int maxHp;
    private State state;

    // XP limits
    public static final int XP_TO_INTERMEDIATE = 100;
    public static final int XP_TO_EXPERT = 300;
    public static final int XP_TO_MASTER = 600;

    public GameCharacter(String name) {
        this.name = name;
        this.xp = 0;
        this.maxHp = 100;
        this.hp = 80; // start with less than max HP to show healing
        this.state = new NoviceState();
    }

    // Deleging to state
    public void train() { state.train(this); }
    public void meditate() { state.meditate(this); }
    public void fight() { state.fight(this); }

    // Methods to modify character's attributes
    public void gainXp(int amount) {
        if (amount <= 0) return;
        this.xp += amount;
        System.out.println("You will get " + amount + " XP. (XP: " + this.xp + ")");
        checkLevelUp();
    }

    public void changeHp(int delta) {
        int before = this.hp;
        this.hp += delta;
        if (this.hp < 0) this.hp = 0;
        if (this.hp > maxHp) this.hp = maxHp;
        int actual = this.hp - before;
        if (actual != 0) {
            System.out.println("HP " + (actual > 0 ? "+" : "") + actual + " → " + this.hp + "/" + maxHp);
        } else {
            System.out.println("HP stays: " + this.hp + "/" + maxHp);
        }
    }

    public void setState(State newState) {
        if (this.state.getClass() == newState.getClass()) return;
        System.out.println("--- Level changing: " + this.state.name() + " → " + newState.name());
        this.state = newState;
    }

    public void checkLevelUp() {
        if (xp >= XP_TO_MASTER && !(state instanceof MasterState)) {
            setState(new MasterState());
        } else if (xp >= XP_TO_EXPERT && !(state instanceof ExpertState || state instanceof MasterState)) {
            setState(new ExpertState());
        } else if (xp >= XP_TO_INTERMEDIATE && !(state instanceof IntermediateState || state instanceof ExpertState || state instanceof MasterState)) {
            setState(new IntermediateState());
        }
    }

    public boolean isMaster() {
        return state instanceof MasterState;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public String statusLine() {
        return String.format("Name: %s | Level: %s | XP: %d | HP: %d/%d",
                name, state.name(), xp, hp, maxHp);
    }

    public State getState() { return state; }
}
