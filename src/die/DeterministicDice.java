package die;

/**
 * Implements a deterministic dice roller, with custom die roll results.
 */
public class DeterministicDice implements DiceRoller {
    private final int[] rolls;

    /**
     * Constructs a `die.DeterministicDice` object with a specified roll outcomes.
     *
     * @param rolls An array of integers representing the outcomes of dice rolls.
     */
    public DeterministicDice(int[] rolls) {
        this.rolls = rolls;
    }

    /**
     * Returns the next roll.
     *
     * @return An integer representing the dice roll result from the possible outcomes.
     */
    @Override
    public int roll() {
        int rollIndex = (int)(Math.random() * rolls.length);
        return rolls[rollIndex];
    }
}