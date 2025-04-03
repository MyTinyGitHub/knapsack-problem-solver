package calculationTypes;

import knapSac.Item;

public class MaxPriceStrategy implements CalculationStrategy {
    @Override
    public int compare(Item o1, Item o2) {
        return -Double.compare(o1.getPrice(), o2.getPrice());
    }

    @Override
    public String toString() {
        return "MaxPriceStrategy";
    }
}
