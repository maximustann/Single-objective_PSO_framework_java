/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * UpdateGbest.java - An Interface of updating global best.
 */

package algorithms;


/**
 * Update Global best, in order to be substitutable with UpdateLbest,
 * we implement both of them from UpdateGLbest interface. 
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */

public interface UpdateGbest extends UpdateGLbest{
	
    /**
     * update the Global best according to all the personal bests
     * 
     * 
     * @param pBestVar personal best variables.
     * @param pBestFit personal best fitness values.
     * @param gBestVar global best 
     * @param gBestFit global best fitness
     * @param optimization 0 denotes minimization, 1 denotes maximization
     * @param generation which generation it is.
     * @return global best fitness
     */	
	public double update(
						Particle[] pBestVar, 
						double[] pBestFit, 
						Particle gBestVar,
						double gBestFit, 
						int optimization, 
						int generation
						);
}
