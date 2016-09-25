/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * FitnessFunction.java - An Interface of fitness function.
 */
package algorithms;

/**
 * Defines the common method of fitness functions
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public interface FitnessFunction {
	
    /**
     * Generate an array of normalized fitness values
     * Two steps: 1. apply fitness function on popVar
     * 			  2. apply normalization function on fitness values
     *
     * @param popVar population variables
     * @return array of normalized fitness values
     */
	public double[] normalizedFit(double[][] popVar);
	
    /**
     * Generate an array of unnormalized fitness values
     * Apply fitness function on popVar
     *
     * @param popVar population variables
     * @return array of unnormalized fitness values, which is often used 
     * 			by normalizedFit()
     */
	public double[] unNormalizedFit(double[][] popVar);
}
