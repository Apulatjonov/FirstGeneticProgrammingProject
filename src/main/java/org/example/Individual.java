package org.example;

public class Individual {
    public String chromosome;
    int fitness;
    int generation;

    public Individual(String chromosome, int generation){
        this.chromosome = chromosome;
        this.generation = generation;
        this.fitness = calFitness();
    }

    public Individual mate(Individual par){
        String childChromosome = "";
        int len = chromosome.length();

        for(int i = 0; i < len; i++){
            float p = new Evolve().randomNum(0, 100)/100;

            if(p < 0.45){
                childChromosome += chromosome.charAt(i);
            }else if(p < 0.90){
                childChromosome += par.chromosome.charAt(i);
            }else{
                childChromosome += new Evolve().mutatedGenes();
            }
        }
        int generation = Math.max(par.generation, this.generation) + 1;
        return new Individual(childChromosome, generation);
    }

    public int calFitness(){
        int len = Constants.TARGET.length();
        int fitness = 0;
        for (int i = 0; i < len; i++) {
            if (chromosome.charAt(i) != Constants.TARGET.charAt(i)){
                fitness++;
            }
        }
        return fitness;
    }
}
