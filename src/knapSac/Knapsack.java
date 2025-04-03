package knapSac;

import calculationTypes.CalculationStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Knapsack {
    List<Item> inKnapsack = new ArrayList<>();

    public Knapsack() {

    }

    public Knapsack(List<Item> list) {
        this.inKnapsack = list;
    }

    public List<Item> getKnapsack() {
        return inKnapsack;
    }

    public int getSize() {
        return inKnapsack.size();
    }

    public double getWeight() {
        return this.inKnapsack.stream().map(x->x.getWeight()).reduce(0.0, Double::sum);
    }

    public Knapsack sorted(CalculationStrategy calculationStrategy) {
        List<Item> sortedList = inKnapsack.stream().sorted(calculationStrategy).collect(Collectors.toList());
        return new Knapsack(sortedList);
    }

    public Item get(int index) {
        if(index >= this.inKnapsack.size()) return null;
        return this.inKnapsack.get(index);
    }

    public void remove(Item item) {
        this.inKnapsack.remove(item);
    }

    public void add(Item item) {
        this.inKnapsack.add(item);
    }

    public void fill(String priceFile, String weightFile) {
        try(Scanner prices = new Scanner(new File(priceFile));
            Scanner weights = new Scanner(new File(weightFile))) {

            while(prices.hasNext()) {
                Item item = new Item(prices.nextDouble(),weights.nextDouble());
                inKnapsack.add(item);
            }

        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Knapsack printKnapsackStatistics() {
        double weightSum = inKnapsack.stream().mapToDouble(Item::getWeight).sum();
        double priceSum = inKnapsack.stream().mapToDouble(Item::getPrice).sum();
        System.out.println(String.format("[ Knapsack { count: %s, weight: %s, price: %s, HU: %s}]\n", inKnapsack.size(), weightSum, priceSum, priceSum));
        return this;
    }

    public Knapsack saveKnapsack() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Knapsack.txt"))) {
            writer.write(this.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public Knapsack saveItemsToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("ItemsList.txt"))) {
            for (Item item : this.inKnapsack) {
                writer.write(item.toString() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    @Override
    public String toString() {
        double weightSum = inKnapsack.stream().mapToDouble(Item::getWeight).sum();
        double priceSum = inKnapsack.stream().mapToDouble(Item::getPrice).sum();
        return String.format("[ Knapsack { count: %s, weight: %s, price: %s, HU: %s}]\n", inKnapsack.size(), weightSum, priceSum, priceSum);
    }
}
