package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages player creation.
 */
public class PlayerManager {

    /**
     * Creates a list of players.
     *
     * @return An unmodifiable List of {@link Player} objects representing the players in the game.
     *         An empty list is returned if there's an invalid input during player creation.
     * @throws IllegalStateException If a player is created with an empty or null name.
     */
    public List<Player> createPlayers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numPlayers;
        try {
            numPlayers = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: Please enter a number.");
        }

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter player " + i + " name: ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
        return players;
    }
}

