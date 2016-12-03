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
	public abstract Particle clone();
	
	/** copyTo, copy the inner instance to another particle, the difference with clone() is
	 * that, clone create a new instance of current particle, but copyTo just copy 
	 * the content to the target particle
	 */
	public abstract void copyTo(Particle target);
}
