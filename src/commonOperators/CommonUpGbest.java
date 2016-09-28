/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * CommonUpGbest.java - A common way of updating a global best.
 */

package commonOperators;
import algorithms.UpdateGbest;

/**
 * Update Global best
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */

public class CommonUpGbest implements UpdateGbest{
    /**
     * update the Global best according to all the personal bests
     * 
     * @param pBestVar 2D-array of personal best variables.
     * @param pBestFit an array of personal best fitness values.
     * @param gBestVar an array of global best variables
     * @param gBestFit current global best fitness
     * @param optimization 0 denotes minimization, 1 denotes maximization
     * @param generation which generation it is.
     * @return global best fitness
     */	
	@Override
	public double update(double[][] pBestVar, double [] pBestFit, double[] gBestVar, double gBestFit, int optimization, int generation) {
		int popSize = pBestVar.length;
		int bestIndex = 0;

		if(generation == 0){
			gBestFit = pBestFit[0];
//			System.out.println(gBestFit);
			for(int i = 0; i < popSize; i++){
				// If minimize, smaller the better
				// If maximize, bigger the better
				if((gBestFit > pBestFit[i] && optimization == 0) || 
					(gBestFit < pBestFit[i] && optimization == 1)){
					gBestFit = pBestFit[i];
					bestIndex = i;
				}
			}
		} else {
			// Searching for the global best from pBest
			for(int i = 0; i < popSize; i++){
				// If minimize, smaller the better
				// If maximize, bigger the better
				if((gBestFit > pBestFit[i] && optimization == 0) || 
					(gBestFit < pBestFit[i] && optimization == 1)){
					gBestFit = pBestFit[i];
					bestIndex = i;
				}
			}
		}

		// Save the global best particle
		for(int i = 0; i < pBestVar[0].length; i++){
			gBestVar[i] = pBestVar[bestIndex][i];
		}
		return gBestFit;
	}
}
