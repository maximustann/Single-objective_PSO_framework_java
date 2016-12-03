/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * UpdatePbest.java - An Interface of updating personal best.
 */

package algorithms;
/**
 * Update personal best
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */

public interface UpdatePbest {

    /**
     * update the Local best according to local particles fitness
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
					);
}
