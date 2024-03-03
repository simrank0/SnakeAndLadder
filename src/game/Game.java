package game;

import board.GameBoard;
import die.DiceRoller;
import player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game instance. Manages the game flow, players, dice rolls,
 * board interactions, and notifies listeners about game events.
 */
public class Game {
    private final GameBoard board;
    private final DiceRoller diceRoller;
    private final List<Player> players;
    private int currentPlayerIndex;
    private GameState state;
    private final List<GameEventListener> listeners;


    /**
     * Constructs a new game instance with the specified dice roller, game board, and players.
     *
     * @param board The game board to be used for the game.
     * @param diceRoller The dice roller to be used for the game.
     * @param players A list of players participating in the game.
     */
    public Game(GameBoard board, DiceRoller diceRoller, List<Player> players) {
        this.board = board;
        this.diceRoller = diceRoller;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.state = GameState.ROLLING_DICE;
        this.listeners = new ArrayList<>();
    }

    /**
     * Adds a listener to be notified about game events.
     *
     * @param listener The game.GameEventListener to be added.
     */
    public void addEventListener(GameEventListener listener) {
        listeners.add(listener);
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        while (true) {
            if (state == GameState.ROLLING_DICE) {
                int roll = diceRoller.roll();
                notifyDiceRoll(roll);
                Player currentPlayer = players.get(currentPlayerIndex);
                int newPosition = currentPlayer.getPosition() + roll;
                movePlayer(currentPlayer, newPosition);
            } else {
                break;
            }
        }
        notifyGameOver(findWinner());
    }

    /**
     * Handles player movement, checking for snakes and ladders, updating the player's position,
     * notifying listeners, and transitioning the game state if necessary.
     */
    private void movePlayer(Player player, int newPosition) {
        int finalPosition = Math.min(newPosition, board.getSize()); // Limit to board size

        // Check for snake or ladder
        int squareType = board.getSquareType(finalPosition);
        if (squareType == -1) {
            System.out.println(player.getName() + " landed on a snake at " + finalPosition);
            finalPosition = board.getSnakeTail(finalPosition);
        } else if (squareType == 1) {
            System.out.println(player.getName() + " climbed a ladder at " + finalPosition);
            finalPosition = board.getLadderTop(finalPosition);
        }

        player.setPosition(finalPosition);

        notifyPlayerMove(player.getName(), finalPosition);

        if (finalPosition == board.getSize()) {
            state = GameState.GAME_OVER;
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            state = GameState.ROLLING_DICE;
        }
    }

    /**
     * Finds the winner by iterating through the players and checking their positions.
     * @return Winner's name
     *         Null if there is no winner
     */
    private String findWinner() {
        for (Player player : players) {
            if (player.getPosition() == board.getSize()) {
                String winner = player.getName();
                System.out.println("Winner is: " + player.getName() + "\uD83C\uDF89");
                return winner;
            }
        }
        return null;
    }

    /**
     * Notifies all registered listeners about a die roll event.
     *
     * @param roll The outcome of the dice roll.
     */
    private void notifyDiceRoll(int roll) {
        for (GameEventListener listener : listeners) {
            listener.onDiceRoll(roll);
        }
    }

    /**
     * Notifies all registered listeners about a player movement event.
     *
     * @param playerName The name of the player who moved (String).
     * @param position The new position of the player on the board (integer).
     */
    private void notifyPlayerMove(String playerName, int position) {
        for (GameEventListener listener : listeners) {
            listener.onPlayerMove(playerName, position);
        }
    }

    /**
     * Notifies all registered listeners about the game ending.
     *
     * @param winner The name of the winning player (String), or null if there is no winner.
     */
    private void notifyGameOver(String winner) {
        for (GameEventListener listener : listeners) {
            listener.onGameOver(winner);
        }
    }

}
