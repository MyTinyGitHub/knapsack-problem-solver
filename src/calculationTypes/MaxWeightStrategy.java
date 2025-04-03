package calculationTypes;

import knapSac.Item;

public class MaxWeightStrategy implements CalculationStrategy {
    @Override
    public int compare(Item o1, Item o2) {
        return -Double.compare(o1.getWeight(), o2.getWeight());
    }

    @Override
    public String toString() {
        return "MaxWeightStrategy";
    }
}