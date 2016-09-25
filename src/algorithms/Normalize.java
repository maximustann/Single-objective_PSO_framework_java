/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * Normalize.java - An Interface of normalization function.
 */

package algorithms;
/**
 * Normalization function
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */

public interface Normalize {
    /**
     * Normalize the given fitness values 
     * 
     * @param fitness the array of fitness values
     * @return an array of normalized fitness values
     */	
	public double[] doNorm(double[] fitness);
}
