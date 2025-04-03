package calculationTypes;

public class Strategies {
    public static CalculationStrategy MAX_PRICE = new MaxPriceStrategy();
    public static CalculationStrategy MIN_PRICE = new MinPriceStrategy();
    public static CalculationStrategy MAX_WEIGHT = new MaxWeightStrategy();
    public static CalculationStrategy MIN_WEIGHT = new MinWeightStrategy();
    public static CalculationStrategy MAX_VALUE_COEFFICIENT = new MaxValueCoefficientStrategy();
    public static CalculationStrategy MIN_VALUE_COEFFICIENT = new MinValueCoefficientStrategy();
}
