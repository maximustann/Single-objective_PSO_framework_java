/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * InitPop.java - An Interface of initialization of population.
 */
package algorithms;

/**
 * Initialization of population
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public interface InitPop {
	
    /**
     * Generate an 2D-array of population, 
     * first dimension is the size of population, 
     * second dimension is the number of variable of a particle
     * 
     * @param popSize population size
     * @param maxVar the number of variable of a particle
     * @param lbound the lower boundary of a variable of a particle
     * @param ubound the upper boundary of a variable of a particle
     * @return 2D-array of population variables
     */	
	public double[][] init(
							int popSize, 
							int maxVar, 
							double lbound, 
							double ubound
							);
}
