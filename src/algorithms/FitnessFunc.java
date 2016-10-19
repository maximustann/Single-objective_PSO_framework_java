/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * FitnessFunc.java - An abstract of common fitness function.
 */

package algorithms;


/**
 *  For writing any Fitness Functions this class should be extend.
 */
public abstract class FitnessFunc implements FitnessFunction{
	
	/** A normalization method */
	public Normalize normalize;

    /**
     * Creates a new FitnessFunc object.
     * @param normalize
     */
	public FitnessFunc(Normalize normalize){
		this.normalize = normalize;
	}
	
	
	
    /**
     * Generate an array of normalized fitness values
     * Steps:
     * <ul>
     * 		<li> 1. apply fitness function on popVar </li>
     * 		<li> 2. apply normalization function on fitness values </li>
     * </ul>
     * @param popVar population variables
     * @return array of normalized fitness values
     */
	@Override
	public double[] normalizedFit(double[][] popVar) {
		double [] fitness = unNormalizedFit(popVar);
		normalize.doNorm(fitness);
		return fitness;
	}
	
	
    /**
     * Generate an array of unnormalized fitness values
     * Apply fitness function on popVar
     *
     * @param popVar population variables
     * @return array of unnormalized fitness values, which is often used 
     * 			by normalizedFit()
     */
	public abstract double[] unNormalizedFit(double[][] popVar);

}
