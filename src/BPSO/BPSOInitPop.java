/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * BPSOInitPop.java - A common initialization population method for BPSO.
 */
package BPSO;

import algorithms.InitPop;
import algorithms.StdRandom;
/**
 * BPSO initialization of population
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class BPSOInitPop implements InitPop{
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
	@Override
	public double[][] init(
						int popSize, 
						int maxVar, 
						double lbound, 
						double ubound
						) {
		
		double[][] realVar = new double[popSize][maxVar];

		// initialize population
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				// The uniform() will return an integer value
				realVar[i][j] = (double) StdRandom.uniform(lbound, ubound);
			}
		}
		return realVar;
	}
}
