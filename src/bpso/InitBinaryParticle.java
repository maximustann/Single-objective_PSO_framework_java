/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * BPSOInitPop.java - A common initialization population method for BPSO.
 */
package bpso;

import commonOperators.InitIntParticle;
import commonRepresentation.IntParticle;
/**
 * BPSO initialization of population
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class InitBinaryParticle extends InitIntParticle{
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
						int popSize, 
						int maxVar, 
						double lbound, 
						double ubound
						) {
		lbound = 0;
		ubound = 2;
		return super.init(popSize, maxVar, lbound, ubound);	
	}
}
