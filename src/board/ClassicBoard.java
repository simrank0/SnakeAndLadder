package board;

import java.util.HashMap;

/**
 * Implements a classic Snake and Ladders game board with pre-defined snake and ladder positions.
 */
public class ClassicBoard implements GameBoard {
    // Implementation for classic board configuration

    private static final int BOARD_SIZE = 100;
    private static HashMap<Integer, Integer> SNAKES;
    private static HashMap<Integer, Integer> LADDERS;

    /**
     * Initializes the classic board with pre-defined snake and ladder positions.
     */
    public ClassicBoard() {
        // Add snake config
        SNAKES = new HashMap<>();
        SNAKES.put(16, 6);
        SNAKES.put(46, 25);
        SNAKES.put(49, 11);
        SNAKES.put(56, 53);
        SNAKES.put(62, 19);
        SNAKES.put(64, 60);
        SNAKES.put(74, 52);
        SNAKES.put(89, 68);
        SNAKES.put(95, 75);
        SNAKES.put(99, 81);

        // Add ladder config
        LADDERS = new HashMap<>();
        LADDERS.put(1, 38);
        LADDERS.put(4, 14);
        LADDERS.put(9, 31);
        LADDERS.put(21, 42);
        LADDERS.put(28, 84);
        LADDERS.put(36, 44);
        LADDERS.put(51, 67);
        LADDERS.put(71, 91);
        LADDERS.put(80, 100);
    }

    /**
     * Returns the total number of squares on the board (typically 100).
     *
     * @return An integer representing the total number of squares on the board.
     */
    @Override
    public int getSize() {
        return BOARD_SIZE;
    }

    /**
     * Retrieves the type of element (snake, ladder, or normal square) for a given position on the board.
     *
     * @param position An integer representing the position on the board (1-100).
     * @return An integer representing the element type:
     *     -1 for snake head,
     *      1 for ladder bottom,
     *      0 for normal square.
     */
    @Override
    public int getSquareType(int position) {
        if (position <= 0 || position > BOARD_SIZE) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        if (SNAKES.containsKey(position)) {
            return -1; // Snake head
        }

        if (LADDERS.containsKey(position)) {
            return 1; // Snake head
        }

        return 0; // Normal square
    }

    /**
     * Retrieves the ending position (tail) of a snake, given its starting position (head).
     *
     * @param head The starting position of the snake on the board.
     * @return An integer representing the ending position (tail) of the snake,
     *         or -1 if the position is not a snake head.
     */
    @Override
    public int getSnakeTail(int head) {
        if (SNAKES.containsKey(head)) {
            return SNAKES.get(head);
        }

        return -1; // Not a snake head
    }

    /**
     * Retrieves the ending position (top) of a ladder, given its starting position (base).
     *
     * @param base The starting position of the ladder on the board.
     * @return An integer representing the ending position (top) of the ladder,
     *         or -1 if the position is not a ladder base.
     */
    @Override
    public int getLadderTop(int base) {
        if (LADDERS.containsKey(base)) {
            return LADDERS.get(base);
        }

        return -1; // Not a ladder base
    }
}
