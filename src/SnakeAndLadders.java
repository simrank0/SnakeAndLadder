import board.GameBoard;
import board.GameBoardFactory;
import die.DiceRoller;
import die.DiceRollerFactory;
import game.Game;
import player.Player;
import player.PlayerManager;

import java.util.*;

/**
 * Snake and Ladders game entry point.
 */
public class SnakeAndLadders {
    public static void main(String[] args) {
        System.out.println("Welcome to the game of Snake\uD83D\uDC0D & Ladders\uD83E\uDE9C");

        GameBoardFactory gameFactory = new GameBoardFactory();
        DiceRollerFactory diceRollerFactory = new DiceRollerFactory();

        //Create game board
        GameBoard board = gameFactory.createGameBoard();

        //Create Dice Roller
        DiceRoller diceRoller = diceRollerFactory.createDiceRoller();

        //Add players
        PlayerManager playerManager = new PlayerManager();
        List<Player> players = playerManager.createPlayers();

        // Start the game
        Game game = new Game(board, diceRoller, players);
        game.startGame();
    }

}
