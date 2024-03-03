package board;

/**
 * Interface representing a game board for Snake and Ladders.
 */
public interface GameBoard {

    /**
     * Returns the total number of squares on the game board.
     *
     * @return The size of the game board (integer).
     */
    int getSize();

    /**
     * Checks the type of square at the specified position on the board.
     *
     * @param position The position on the board to check.
     * @return The type of square at the given position
     * This method returns:
     * - 1 if the square is a regular square.
     * - 1 if the square is the bottom of a ladder.
     */
    int getSquareType(int position);

    /**
     * Checks and finds a tail of snake at position.
     *
     * @param position The position to check for a snake head.
     * @return The position the player lands on after encountering a snake or -1 if position is
     * not a snake head.
     */
    int getSnakeTail(int position);

    /**
     * Checks and finds top of ladder at position.
     *
     * @param position The position to check for a ladder top.
     * @return The position the player lands on after climbing a ladder or -1 if position is
     * not a ladder base.
     */
    int getLadderTop(int position);
}
