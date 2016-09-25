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
	
	/** An DataCollector object for collect result */
	protected DataCollector collector;

	/** An VelocityClamping object for clamping velocity */
	protected VelocityClamping clamper;

	// algorithm related parameter settings
	protected double[] popFit;
	protected double[] pBestFit;
	protected double[][] velocity;

	protected double[][] popVar;
	protected double[][] pBestVar;
	protected double[] gBestVar;
	protected double[][] iBestVar;

	protected double[] iBestFit;
	protected double gBestFit;


	// Problem related parameter settings
	protected int optimization;
	protected int popSize;
	protected int maxGen;
	protected int maxVar;

	protected double lbound;
	protected double ubound;
	protected double w;
	protected double c1, c2;
	protected double clampFactor;

	protected abstract void prepare();

	// Initialize random
	public void initializeRand(int seed){
		StdRandom.setSeed(seed);
	}

	// Run the algorithm
	public abstract void run(int seed);
}
