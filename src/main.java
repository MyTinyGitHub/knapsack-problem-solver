/*
    Zadanie semestrálnej práce
    Primárnou vsúvacou heuristikou riešite úlohu danú modelom (úloha
    o batohu s kapacitou K a obmedzeným počtom predmetov v batohu
    r). Riešte úlohu pre n=500, r=350, K=10500 a pre lokálne kritérium
    „Vlož prvok z dosiaľ nespracovaných prvkov, ktorý má najväčší
    koeficient cj, j=1..n (najväčšiu cenu)“. Východiskové riešenie položte
    rovné prázdnemu batohu. Súčasťou zadania sú súbory H2_a.txt
    a H2_c.txt, ktoré obsahujú n údajov koeficientov aj a cj pre j=1..n
    potrebných pre riešenie zadanej úlohy.
 */

import calculationTypes.Strategies;
import heuristics.DualHeuristic;
import knapSac.Knapsack;

public class main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.fill("resources/H3_a.txt", "resources/H3_c.txt");

        DualHeuristic heuristic = new DualHeuristic(knapsack, 350, 11500);

        heuristic.evaluate(Strategies.MAX_WEIGHT)
                .getKnapsack()
                .printKnapsackStatistics()
                .saveKnapsack()
                .saveItemsToFile();
    }
}
