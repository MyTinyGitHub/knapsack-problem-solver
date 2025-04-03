package heuristics;

import calculationTypes.CalculationStrategy;
import knapSac.Item;
import knapSac.Knapsack;

public class DualHeuristic {
    Knapsack knapsack = null;
    int itemLimit = 0;
    double weightLimit = 0;

    public DualHeuristic(Knapsack knapsack, int itemLimit, double weightLimit) {
        this.knapsack = knapsack;
        this.itemLimit = itemLimit;
        this.weightLimit = weightLimit;
    }

    public DualHeuristic evaluate(CalculationStrategy calculationStrategy) {
        knapsack = knapsack.sorted(calculationStrategy);;

        while(knapsack.getSize() > itemLimit || knapsack.getWeight() > weightLimit) {
            Item item = knapsack.get(0);
            knapsack.remove(item);
        }

        return this;
    }

    public Knapsack getKnapsack() {
        return this.knapsack;
    }
}
