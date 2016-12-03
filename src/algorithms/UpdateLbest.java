/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * UpdateLbest.java - An Interface of updating local best.
 */

package algorithms;
/**
 * Update local best, in order to be substitutable with UpdateGbest,
 * we extends both of them from UpdateGLbest. 
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */

public interface UpdateLbest extends UpdateGLbest{
	
    /**
     * update the Local best according to local particles fitness
     * 
     * 
     * @param pBestVar 2D-array of personal best variables.
     * @param pBestFit an array of personal best fitness values.
     * @param lBestVar 2D-array of local best variables
     * @param lBestFit an array of local best fitness values
     * @param optimization 0 denotes minimization, 1 denotes maximization
     * @param generation which generation it is.
     */	
	public void update(
						Particle[] pBestVar, 
						double[] pBestFit, 
						Particle[] lBestVar,
						double[] lBestFit, 
						int optimization, 
						int generation
						);
}
