package agh.cs.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalGenes {
    //private List<Integer> genes = new ArrayList<Integer>();
    private static final int genes_no = 32;
    private static final int genes_kind_no = 8;
    private int[] genes = new int[genes_no];
    private Random rand = new Random();

    public AnimalGenes(){
        for (int index=0;index < genes_no;index++) {
            genes[index] = rand.nextInt(genes_kind_no);
        }
    }

    public int getNextMove(){
        return genes[rand.nextInt(genes_no)];
    }

    public int[] getGenesForBaby(){     // needs correction
        int[] baby_genes = new int[genes_no/2];
        List<Integer> selectedGenes = new ArrayList<>();

        for(int index=0;index<genes_no/2;index++){
            Integer selectedGene = rand.nextInt(genes_no);

            while(selectedGenes.contains(selectedGene)){
                selectedGene = rand.nextInt(genes_no);
            }

            selectedGenes.add(selectedGene);

            baby_genes[index] = genes[selectedGene];
        }

        return baby_genes;
    }


}
