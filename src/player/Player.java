package player;

/**
 * Represents a player in the Snake and Ladders game.
 */
public class Player {
    private final String name;
    private int position;

    /**
     * Constructs a new player.Player object with the specified name.
     *
     * @param name The player's name.
     */
    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    /**
     * Returns the player's name.
     *
     * @return The player's name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's current position on the board.
     *
     * @return The player's current position as an integer.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the player's position on the board.
     *
     * @param position The new position for the player.
     */
    public void setPosition(int position) {
        this.position = position;
    }
}