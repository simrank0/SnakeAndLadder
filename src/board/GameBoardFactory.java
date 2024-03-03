package board;

import java.util.Scanner;

/**
 * Utility class for creating different types of game boards.
 */
public class GameBoardFactory {

    /**
     * Creates a game board based on the provided type.
     *
     * @return A {@link GameBoard} object implementing the requested type of game board.
     * @throws IllegalArgumentException If an invalid game board type is provided.
     */
    public GameBoard createGameBoard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose board configuration:");
        System.out.println("1. Classic Snake and Ladders");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: Please enter 1 or the corresponding number for other options.");
        }

        switch (choice) {
            case 1:
                return new ClassicBoard();
            // TODO: Add custom board choice
            default:
                throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }

}
