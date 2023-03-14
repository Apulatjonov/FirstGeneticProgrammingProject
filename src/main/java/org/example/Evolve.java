package org.example;

import static java.lang.Math.random;

public class Evolve {
    public int randomNum(int start, int end){
        int range = (end-start) + 1;
        int random = start + (int)(random() * range);
        return random;
    }

    public char mutatedGenes(){
        int len = Constants.GENES.length();
        int r = randomNum(0, len-1);
        return Constants.GENES.charAt(r);
    }

    public String createGnome(){
        int len = Constants.TARGET.length();
        String gnome = "";
        for (int i = 0; i < len; i++) {
            gnome += mutatedGenes();
        }
        return gnome;
    }
}
