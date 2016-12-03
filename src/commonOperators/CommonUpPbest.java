/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * CommonUpPbest.java - A common way of updating personal best population.
 */
package commonOperators;
import algorithms.Particle;
import algorithms.UpdatePbest;
/**
 * Update personal best
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class CommonUpPbest implements UpdatePbest{
    /**
     * update the Local best according to local particles fitness
     * 
     * 1. Store the fitness value if it is the first generation
     * 2. If it is not the first generation, compare with previous fitness value, if better
     * 	  update.
     * 
     * @param pBestVar 2D-array of personal best variables.
     * @param pBestFit an array of personal best fitness values.
     * @param popVar 2D-array of population variables
     * @param popFit an array of population fitness values
     * @param optimization 0 denotes minimization, 1 denotes maximization
     * @param generation which generation it is.
     */	
	public void update(
					Particle[] pBestVar, 
					double[] pBestFit, 
					Particle[] popVar, 
					double[] popFit, 
					int optimization, 
					int generation
					) {
		int popSize = pBestVar.length;
		int maxVar = pBestVar[0].size();

		if(generation == 0){
			for(int i = 0; i < popSize; i++){
				pBestFit[i] = popFit[i];
				popVar[i].copyTo(pBestVar[i]);
			}
		} else{
			// Go through whole population
			for(int i = 0; i < popSize; i++){
				// Check if the current fitness is better than previous pBest
				if((pBestFit[i] > popFit[i] && optimization == 0) || 
				  ( pBestFit[i] < popFit[i] && optimization == 1)){
					pBestFit[i] = popFit[i];

					// update each personal Best
					popVar[i].copyTo(pBestVar[i]);
				}
			}
		}
	}

}
