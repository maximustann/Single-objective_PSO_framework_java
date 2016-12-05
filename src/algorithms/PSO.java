/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * Normalize.java - An Interface of normalization function.
 */

package algorithms;


import algorithms.StdRandom;
import dataCollector.DataCollector;

/**
 * The abstraction of PSO
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */

public abstract class PSO{

	/** An InitPop object for initialization of population */
	protected InitPop initPop;
	
	/** An InitVelocity object for initialization of velocity */
	protected InitVelocity initVel;

	/** An Evaluation object for Evaluation of fitness */
	protected Evaluate evaluate;
	
	/** An UpdateGbest object for Updating global best */
	protected UpdateGbest upGbest;

	/** An UpdateLbest object for Updating local best */
	protected UpdateLbest upLbest;

	/** An UpdatePbest object for Updating Personal best */
	protected UpdatePbest upPbest;
	
	/** An UpPop object for Updating population variables */
	protected UpPop upPop;
	
	/** dynamic inertia method */
	protected DynamicW dynW;
	
	/** An DataCollector object for collect result */
	protected DataCollector collector;

	// algorithm related parameter settings

	/** an array of fitness value, size is the population size */
	protected double[] popFit;

	/** an array of personal best fitness value, size is the population size */
	protected double[] pBestFit;
	
	/** a 2D-array of velocity, the size of first dimension 
	 * is the population size, the size of second dimension is the number of 
	 * variable of a particle */
	protected double[][] velocity;

	/** a 2D-array of population variables, the size of first dimension 
	 * is the population size, the size of second dimension is the number of 
	 * variable  of a particle */
	protected Particle[] popVar;
	
	/** a 2D-array of personal best variables, the size of first dimension 
	 * is the population size, the size of second dimension is the number of 
	 * variable of a particle */	
	protected Particle[] pBestVar;
	
	/** an array of global best variables, 
	 * the size of second dimension is the number of variable of a particle */	
	protected Particle gBestVar;
	
	/** a 2D-array of local best variables, the size of first dimension 
	 * is the population size, the size of second dimension is the number of 
	 * variable of a particle*/		
	protected Particle[] lBestVar;
	
	
	/** an array of local best fitness values, the size is 
	 * the population size */	
	protected double[] lBestFit;
	
	/** the global best fitness value */
	protected double gBestFit;


	// Problem related parameter settings
	/** if optimization == 1, the algorithm maximize the fitness value 
	 *  else, the algorithm minimize the fitness value */
	protected int optimization;
	
	/** size of population */
	protected int popSize;
	
	/** size of maximum generation */
	protected int maxGen;

	/** size of variable */
	protected int maxVar;

	/** the lower boundary of a variable of a particle */
	protected double lbound;

	/** the upper boundary of a variable of a particle */
	protected double ubound;
	
	/** the lower boundary of a variable of the inertia */
	protected double lboundW;

	/** the upper boundary of a variable of the inertia */
	protected double uboundW;
	
	/** inertia weight */
	protected double w;
	
	/** inertia balance */
	protected double balance;
	
	/** c1 is cognitive parameter,
	 *  c2 is social parameter */
	protected double c1, c2;
	
	/** clampFactor is also called constriction factor */
	protected double clampFactor;

    /**
     * Instead of using a constructor, we use a prepare() which do the 
     * initialization of PSO including assignment of values, 
     * initialization of arrays.
     * This should be extended and accomplished in the subclass.
     */
	protected abstract void prepare();

    /**
     * Initialization of random generator.
     */
	public void initializeRand(int seed){
		StdRandom.setSeed(seed);
	}

    /**
     * The actual algorithm of PSO, but we do not implement
     * the process here. Because, we want to adapt both global and local
     * best for PSO. They are using different mechanism (different array)
     * to store the best results.
     */
	public abstract void run(int seed);
	/**
	 * Repeat experiments for N times
	 * 
	 * @param seedStart the random seeds start from this point, increase 1 by each time
	 * @param nTimes run experiments for nTimes
	 */
	public abstract void runNtimes(int seedStart, int nTimes);
}
