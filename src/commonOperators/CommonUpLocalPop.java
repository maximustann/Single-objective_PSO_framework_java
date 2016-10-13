/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * CommonUpLocalPop.java - A common way of updating local-based population.
 */

package commonOperators;
import algorithms.StdRandom;
import algorithms.UpPopLocal;
import algorithms.VelocityClamping;
public class CommonUpLocalPop implements UpPopLocal {
	/** An VelocityClamping object for clamping velocity */
	private VelocityClamping clamper;

	/** constructor, initialize the clamper
	 * @param clamper a velocity clamper
	 */		
	public CommonUpLocalPop(VelocityClamping clamper){
		this.clamper = clamper;
	}

	
    /**
     * update the population based on personal best and local best
     *
     * 1. update velocity
     * 2. Do velocity clamping
     * 3. Update particle positions
     *
     * 
     * @param popVar 2D-array of population variables.
     * @param pBestFit an array of personal best fitness values.
     * @param velocity 2D-array of velocity.
     * @param pBestVar 2D-array of personal best variables.
     * @param lBestVar 2D-array of local best variables.
     * @param w inertia.
     * @param c1 cognitive parameter
     * @param c2 social parameter
     * @param lbound the lower bound of variable
     * @param ubound the upper bound of variable
     */
	@Override
	public void update(
					double[][] popVar, 
					double[] pBestFit, 
					double[][] velocity,
					double[][] pBestVar, 
					double[][] lBestVar, 
					double w, 
					double c1, 
					double c2,
					double lbound,
					double ubound
					) {
		int popSize = popVar.length;
		int maxVar = popVar[0].length;

		// Go through whole population
		for(int i = 0; i < popSize; i++){
			// update each dimension
			for(int j = 0; j < maxVar; j++){
				velocity[i][j] = w * velocity[i][j] + c1 * StdRandom.uniform(0.0, 1.0) *
						(pBestVar[i][j] - popVar[i][j]) + c2 * StdRandom.uniform(0.0, 1.0) *
						(lBestVar[i][j] - popVar[i][j]);
			}
		}
		
		// do clamping
		clamper.clamping(velocity, lbound, ubound);

		// Calculate new positions of particles
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				popVar[i][j] += velocity[i][j];
			}
		}
	}


}
