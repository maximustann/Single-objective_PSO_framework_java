/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * DynamicW.java - Interface of a dynamic inertia method.
 */

package algorithms;
/**
 * DynamicW interface provides an interface of dynamic inertia
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public interface DynamicW {
	/**
	 * update the inertia value
	 * @param currentGen current generation
	 * @return an inertia value
	 */
	public double update(int currentGen);
}
