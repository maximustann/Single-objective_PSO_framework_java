/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * InitRealPop.java - A common initialization of population for continuous PSO
 */
package commonOperators;

import algorithms.InitPop;
import algorithms.StdRandom;
import commonRepresentation.RealParticle;

/**
 * Initialization of population for continuous PSO
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class InitRealParticle implements InitPop{
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
	public RealParticle[] init(
						int 		popSize, 
						int 		maxVar, 
						double 	lbound, 
						double 	ubound
						) {
		RealParticle[] popVar = new RealParticle[popSize];
		// initialize population
		for(int i = 0; i < popSize; i++){
			popVar[i] = new RealParticle(maxVar);
			for(int j = 0; j < maxVar; j++){
				popVar[i].individual[j] = StdRandom.uniform(lbound, ubound);
			}
		}
		return popVar;
	}
}
