package heuristics;

import calculationTypes.CalculationStrategy;
import knapSac.Item;
import knapSac.Knapsack;

public class PrimaryHeuristic {
    public static Knapsack evaluate(Knapsack knapsack,CalculationStrategy calculationStrategy, int itemLimit, double weightLimit) {
        Knapsack newKnapsack = new Knapsack();
        Knapsack sortedKnapsack = knapsack.sorted(calculationStrategy);

        while (newKnapsack.getSize() < itemLimit && knapsack.getSize() > 0) {
            Item item = sortedKnapsack.get(0);
            if (weightLimit - item.getWeight() > 0) {
                sortedKnapsack.remove(item);
                newKnapsack.add(item);
                weightLimit -= item.getWeight();
            } else {
                break;
            }
        }

        return newKnapsack;
    }
}
