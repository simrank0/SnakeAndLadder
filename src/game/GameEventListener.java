package game;

/**
 * Interface defining a listener for game events.
 */
public interface GameEventListener {

    /**
     * Called when a player rolls the dice.
     *
     * @param roll The outcome of the dice roll.
     */
    void onDiceRoll(int roll);

    /**
     * Called when a player moves on the game board.
     *
     * @param playerName The name of the player who moved.
     * @param position The new position of the player on the board.
     */
    void onPlayerMove(String playerName, int position);

    /**
     * Called when the game ends.
     *
     * @param winner The name of the winning player, or null if there is no winner.
     */
    void onGameOver(String winner);
}