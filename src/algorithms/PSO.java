package algorithms;

import algorithms.StdRandom;


public abstract class PSO{
	protected InitPop initPop;
	protected InitVelocity initVel;
	protected Evaluate evaluate;
	protected UpdateGbest upGbest;
	protected UpdateIbest upIbest;
	protected UpdatePbest upPbest;
	protected UpPop upPop;

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

	protected abstract void prepare();

	// Initialize random
	public void initializeRand(int seed){
		StdRandom.setSeed(seed);
	}

	// Run the algorithm
	public abstract void run(int seed);

}
