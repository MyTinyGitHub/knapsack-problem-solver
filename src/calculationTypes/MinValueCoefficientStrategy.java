package calculationTypes;

import knapSac.Item;

public class MinValueCoefficientStrategy implements CalculationStrategy {
    @Override
    public int compare(Item o1, Item o2) {
        return Double.compare(o1.getPrice() / o1.getWeight(), o2.getPrice() / o2.getWeight());
    }

    @Override
    public String toString() {
        return "MinValueCoefficientStrategy";
    }
}
