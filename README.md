
# Snake and Ladders Game:
Welcome to the Snake and Ladders game!

This project implements the classic board game of Snake and Ladders in Java. It demonstrates various programming concepts and potential design patterns.

## Design Patterns Used:
### 1. Observer Pattern: 
The GameEventListener interface and its implementations allow for decoupled communication between the Game class and other components that want to be notified of game events (dice rolls, player movements, game over).
### Factory Pattern:
This pattern is used to create different types of game boards and dice.
### Strategy Pattern:
This pattern is implemented for different dice rolling mechanisms (e.g., fair dice, custom dice).

## How to Play:
### Setup:
1. Create a board with classic config or a desired size (number of squares) and configure snake and ladder positions. 
    - Choose 1 when asked to choose board configuration to use classic configurations.
    - Choose 2 to add custom configurations for a board.
2. Define players.
   - Enter number of players.
   - Keep on adding names for the players.
3. Optionally, create and register custom listeners implementing GameEventListener to receive game event notifications.

### Gameplay:
Players take turns rolling a die.
The player moves their piece forward the number of spaces indicated by the die roll.
If the player lands on the head of a ladder, they climb up to the ladder's top square.
If the player lands on the head of a snake, they slide down to the snake's tail square.
The first player to reach the final square (the last square of board) wins the game.

### Running the Game:
1. Ensure you have Java (21) installed on your system.
2. Clone or download the project repository.
3. Run `SnakeAndLadders.java`

## UML
<img width="1229" alt="Screenshot 2024-03-03 at 5 53 19 PM" src="https://github.com/simrank0/SnakeAndLadder/assets/56548348/5f8574be-3eed-4657-a8b4-7e5f1d462ddf">
