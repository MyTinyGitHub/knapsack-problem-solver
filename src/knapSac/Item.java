package knapSac;

public class Item {
   private double price;
   private double weight;

   Item(double price, double weight) {
        this.price = price;
        this.weight = weight;
   }

   public double getPrice() {
       return this.price;
   }

   public double getWeight() {
       return this.weight;
   }

   public double getPriceToWeight()  { return this.price / this.weight; }

   public String toString() {
       return String.format("{ Item : [ Price : %s, Weight : %s ]}", this.price, this.weight);
   }
}
