package game;

public class CustomGameEventListener implements GameEventListener {
    @Override
    public void onDiceRoll(int roll) {
        System.out.println("Dice roll: " + roll);
    }

    @Override
    public void onPlayerMove(String playerName, int position) {
        System.out.println(playerName + " moved to position " + position);
    }

    @Override
    public void onGameOver(String winner) {
        if (winner != null) {
            System.out.println("Game over! Winner: " + winner);
        } else {
            System.out.println("Game over! No winner.");
        }
    }
}