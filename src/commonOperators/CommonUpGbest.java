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
import algorithms.Particle;
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
     * 1. If it is the first generation, update global best with the best personal best
     * 2. If it is not the first generation, compare the current global best with all personal bests
     *
     *
     *
     * @param pBestVar personal best variables.
     * @param pBestFit an array of personal best fitness values.
     * @param gBestVar global best
     * @param gBestFit current global best fitness
     * @param optimization 0 denotes minimization, 1 denotes maximization
     * @param generation which generation it is.
     * @return global best fitness
     */
	@Override
	public double update(
					Particle[] 	pBestVar,
					double [] 	pBestFit,
					Particle 	gBestVar,
					double 		gBestFit,
					int 			optimization,
					int 			generation
					) {
		int popSize = pBestVar.length;
		int bestIndex = 0;

		if(generation == 0){
			gBestFit = pBestFit[0];
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
		pBestVar[bestIndex].copyTo(gBestVar);
		return gBestFit;
	}
// end
}
