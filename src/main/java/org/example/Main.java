package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        int generation = 0;
        Stack<Individual> population = new Stack();
        int populationSize = 100;

        boolean found = false;
        for (int i = 0; i < populationSize; i++) {
            String gnome = new Evolve().createGnome();
            population.push(new Individual(gnome, generation));
        }

        while (!found) {
            population.sort(new Comparator<Individual>() {
                @Override
                public int compare(Individual o1, Individual o2) {
                    return o1.fitness - o2.fitness;
                }
            });

            Stack<Individual> newGeneration = new Stack<>();
            int s = (int) (0.1 * population.size());
            for (int i = 0; i < s; i++) {
                newGeneration.push(population.get(i));
            }
            s = (int) (0.9 * population.size());
            for (int i = 0; i < s; i++) {
                int len = population.size();
                int r = new Evolve().randomNum(0, population.size() - 1);
                Individual parent1 = population.get(r);
                r = new Evolve().randomNum(0, population.size() - 1);
                Individual parent2 = population.get(r);
                Individual offSpring = parent1.mate(parent2);
                newGeneration.push(offSpring);
            }

            population = newGeneration;
            System.out.println("Generation: " + population.get(0).generation + " String: " + population.get(0).chromosome + " Fitness: " + population.get(0).fitness);
            if (population.get(0).fitness <= 0) {
                found = true;
                break;
            }
        }
    }
}