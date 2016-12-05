/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * Evaluate.java - Interface of a Evaluation method.
 */

package algorithms;
/**
 * Defines the common method of evaluation
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */

public interface Evaluate {
	/**
	 * @param popVar a population of variables
	 * @param fitness the fitness values of the population
	 */
	public void evaluate(Particle[] popVar, double[] fitness);
}
