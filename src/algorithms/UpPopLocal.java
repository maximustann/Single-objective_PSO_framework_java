/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * UpPopGlobal.java - An Interface of updating global_best-based population.
 */

package algorithms;

public interface UpPopLocal extends UpPop{
	
    /**
     * update the population based on personal best and local best
     * 
     * @param popVar population variables.
     * @param pBestFit personal best fitness values.
     * @param velocity velocity.
     * @param pBestVar personal best variables.
     * @param lBestVar local best variables.
     * @param w inertia.
     * @param c1 cognitive parameter
     * @param c2 social parameter
     * @param lbound the lower bound of a variable in a particle
     * @param ubound the upper bound of a variable in a particle
     */
	public void update(
					Particle[] popVar, 
					double [] pBestFit, 
					double[][] velocity,
					Particle[] pBestVar, 
					Particle[] lBestVar, 
					double w, 
					double c1, 
					double c2,
					double lbound,
					double ubound
					);
}
