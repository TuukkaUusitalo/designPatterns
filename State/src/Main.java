import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.ROOT);

        System.out.print("Give a character's name: ");
        String name = in.nextLine().trim();
        if (name.isEmpty()) name = "Tester";

        GameCharacter c = new GameCharacter(name);

        System.out.println("\nWelcome, " + name + "!");
        System.out.println("Reach to the MASTER-level by gaining experience.\n");

        boolean running = true;
        while (running) {
            System.out.println("--------------------");
            System.out.println(c.statusLine());
            c.getState().showActions();
            System.out.println("[Q]uit");
            System.out.print("Choose action: ");
            String line = in.nextLine().trim().toLowerCase(Locale.ROOT);

            if (line.isEmpty()) continue;
            char ch = line.charAt(0);

            switch (ch) {
                case 't':
                    c.train();
                    break;
                case 'm':
                    c.meditate();
                    break;
                case 'f':
                    c.fight();
                    break;
                case 'q':
                    running = false;
                    break;
                default:
                    System.out.println("Unknoen command.");
            }

            if (c.isDead()) {
                System.out.println("\n*** Your character has passed out. Game finished. ***");
                break;
            }
            if (c.isMaster()) {
                System.out.println("\n*** Congrats! MASTER‑level. Game finished. ***");
                break;
            }
        }

        System.out.println("Thank you for the game!");
    }
}
