/*
 * Boxiong Tan (Maximus Tann)
 * Title:        Single-objective PSO framework
 * Description:  Single-objective PSO framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * UnNormalizedFit.java - An interface of unnormalized fitness function
 */
package algorithms;

import java.util.concurrent.Callable;

/**
 * UnNormalizedFit is the core calculation unit. You should implement it as your fitness function.
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since GA framework 1.0
 */
@SuppressWarnings("rawtypes")
public abstract class UnNormalizedFit implements Callable{
	protected Particle individual;
	public UnNormalizedFit(Particle individual){
		this.individual = individual;
	}
}
