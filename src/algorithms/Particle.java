/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * Particle.java - An abstract of particle.
 */
package algorithms;
/**
 * An abstract class of particle 
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since GA framework 1.0
 */
public abstract class Particle implements Cloneable{
	
	/** get the size of particle */
	public abstract int size();
	
	/** print method */
	public abstract void print();
	
	/** compare */
	public abstract boolean equals(Particle particle);
	
	/** deep copy */
	@Override
	public abstract Particle clone();
	
	/** copyTo, copies the inner instance to another particle, the difference with clone() is
	 * that, clone creates a new instance of current particle, but copyTo just copies 
	 * the content to the target particle
	 */
	public abstract void copyTo(Particle target);

}
