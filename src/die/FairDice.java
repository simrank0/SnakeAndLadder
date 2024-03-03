package die;

/**
 * Implements a fair dice roller, where each face (1 to 6) has an equal probability of occurring.
 */
public class FairDice implements DiceRoller {
    /**
     * Rolls the dice (simulated using Math.random) and returns the result.
     *
     * @return An integer representing the dice roll result (1-6).
     */
    @Override
    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }
}