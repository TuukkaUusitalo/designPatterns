import java.util.Random;

public class DiceGame extends Game {

    private int[] scores;
    private int roundsPlayed = 0;
    private final int totalRounds = 3;
    private Random rnd = new Random();
    private int players;

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.players = numberOfPlayers;
        scores = new int[numberOfPlayers];
        System.out.println("Game starts with " + numberOfPlayers + " players.");
    }

    @Override
    public boolean endOfGame() {
        return roundsPlayed >= totalRounds;
    }

    @Override
    public void playSingleTurn(int player) {

        int roll = rnd.nextInt(6) + 1;
        scores[player] += roll;

        System.out.println("Player " + player + " rolled " + roll +
                " -> total: " + scores[player]);

        // Every player played one round?
        if (player == players - 1) {
            roundsPlayed++;
            System.out.println("Round " + roundsPlayed + " finished");
        }
    }

    @Override
    public void displayWinner() {
        int winner = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[winner]) {
                winner = i;
            }
        }

        System.out.println("Winner is player " + winner + " with score " + scores[winner]);
    }
}