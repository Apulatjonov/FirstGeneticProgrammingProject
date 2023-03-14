# First Simple Genetic Programming Project

This program uses genetic algorithm to find the most fittest sequence of characters to the TARGET string among the characters in the string GENES. This is based on the following foundational criteria of the GA analogy:
- Individual in population compete for resources and mate
- Thos individuals who are successful (fittest) then mate to create more offspring than others
- Genes from "fittest" parent propagate throughout the generation, that is sometimes parents create offspring which is better than either parent.
- Thus each successive generation is more suited for their environment


<strong>Search space</strong>

The population of individuals are maintained within search space. Each individual represents a solution in search space for given problem. Each individual is coded as a finite length vector (analogous to chromosome) of components. These variable components are analogous to Genes. Thus a chromosome (individual) is composed of several genes (variable components). 


<strong>Fitness Score</strong>

A Fitness Score is given to each individual which shows the ability of an individual to “compete”. The individual having optimal fitness score (or near optimal) are sought. 

The GAs maintains the population of n individuals (chromosome/solutions) along with their fitness scores.The individuals having better fitness scores are given more chance to reproduce than others. The individuals with better fitness scores are selected who mate and produce better offspring by combining chromosomes of parents. The population size is static so the room has to be created for new arrivals. So, some individuals die and get replaced by new arrivals eventually creating new generation when all the mating opportunity of the old population is exhausted. It is hoped that over successive generations better solutions will arrive while least fit die. 

Each new generation has on average more “better genes” than the individual (solution) of previous generations. Thus each new generations have better “partial solutions” than previous generations. Once the offspring produced having no significant difference from offspring produced by previous populations, the population is converged. The algorithm is said to be converged to a set of solutions for the problem.


<strong>Operators of Genetic Algorithms</strong>

Once the initial generation is created, the algorithm evolves the generation using following operators – 
1) Selection Operator: The idea is to give preference to the individuals with good fitness scores and allow them to pass their genes to successive generations. 
2) Crossover Operator: This represents mating between individuals. Two individuals are selected using selection operator and crossover sites are chosen randomly. Then the genes at these crossover sites are exchanged thus creating a completely new individual (offspring). For example

Parent 1 -> $${\color{green}[A][B][C][D][E][F][G][H]}$$
Parent 2 > $${\color{blue}[F][G][H][A][D][B][E][A]}$$

Offspring -> $${\color{blue}[F][G][H]\color{green}[B][C][D][E]\color{blue}[A]}$$


3) Mutation Operator: The key idea is to insert random genes in offspring to maintain the diversity in the population to avoid premature convergence. For example – 

Before Mutation -> $${\color{green}[F][G][H][B][C][D][E][A]}$$
After Mutation -> $${\color{green}[F][G]\color{red}[M]\color{green}[B][C][D][E]\color{red}[N]}$$


<strong>Note:</strong> Every-time algorithm start with random strings, so output may differ

As we can see from the output, our algorithm sometimes stuck at a local optimum solution, this can be further improved by updating fitness score calculation algorithm or by tweaking mutation and crossover operators.

