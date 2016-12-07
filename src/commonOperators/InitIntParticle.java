/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * InitIntPop.java - A common initialization population method for discrete PSO.
 */
package commonOperators;

import algorithms.InitPop;
import algorithms.StdRandom;
import commonRepresentation.IntParticle;
/**
 * BPSO initialization of population
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class InitIntParticle implements InitPop{
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
	public IntParticle[] init(
						int 		popSize, 
						int 		maxVar, 
						double 	lbound, 
						double 	ubound
						) {
		
		IntParticle[] popVar = new IntParticle[popSize];
		// initialize population
		for(int i = 0; i < popSize; i++){
			popVar[i] = new IntParticle(maxVar);
			for(int j = 0; j < maxVar; j++){
				popVar[i].individual[j] = StdRandom.uniform((int) lbound, (int) ubound);
			}
		}
		return popVar;
	}
}
