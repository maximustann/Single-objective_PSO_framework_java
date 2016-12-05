/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * VelocityClamping.java - An Interface of updating global_best-based population.
 */

package algorithms;
/**
 * Clamping for Velocity
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public interface VelocityClamping {
	
    /**
     * @param velocity velocity
     * @param lbound the lower boundary of a variable of a particle
     * @param ubound the upper boundary of a variable of a particle
     */		
	public void clamping(
					double[][] velocity, 
					double lbound, 
					double ubound
					);
}
