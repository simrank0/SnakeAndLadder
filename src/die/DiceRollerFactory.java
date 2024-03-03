package die;

import java.util.Scanner;

/**
 * Utility class for creating different types of dice rollers.
 */
public class DiceRollerFactory {

    /**
     * Creates a die roller based on the provided type.
     *
     * @return A {@link DiceRoller} object implementing the requested type of dice rolling.
     *      1 - Fair Die
     *      2 - Deterministic Die
     * @throws IllegalArgumentException If an invalid dice roller type is provided.
     */
    public DiceRoller createDiceRoller() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose dice roller type:");
        System.out.println("1. Fair Dice");
        System.out.println("2. Deterministic Dice");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: Please enter 1 or 2.");
        }

        switch (choice) {
            case 1:
                return new FairDice();
            case 2:
                System.out.print("Enter the possible output of dice rolls (comma-separated): ");
                String input = scanner.nextLine();
                String[] rollStrings = input.split(",");
                int[] rolls = new int[rollStrings.length];
                for (int i = 0; i < rollStrings.length; i++) {
                    try {
                        rolls[i] = Integer.parseInt(rollStrings[i].trim());
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid roll value: " + rollStrings[i]);
                    }
                }
                return new DeterministicDice(rolls);
            default:
                throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }

}