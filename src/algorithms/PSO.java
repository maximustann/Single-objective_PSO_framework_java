package algorithms;

import algorithms.StdRandom;


public abstract class PSO {
	protected InitPop initPop;
	protected InitVelocity initVel;
	protected Evaluate evaluate;
	protected UpdateGbest upGbest;
	protected UpdatePbest upPbest;
	protected UpPop upPop;

	// algorithm related parameter settings
	protected double[] popFit;
	protected double[] pBestFit;
	protected double[][] velocity;

	protected double[][] popVar;
	protected double[][] pBestVar;
	protected double[] gBestVar;

	protected double gBestFit;


	// Problem related parameter settings
	protected int optimization;
	protected int popSize;
	protected int maxGen;
	protected int maxVar;

//	private double lbound, ubound;
	protected double w;
	protected double c1, c2;

	protected abstract void prepare();

	// Initialize random
	private void initializeRand(int seed){
		StdRandom.setSeed(seed);
	}

	// Run the algorithm
	public void run(int seed){
		initializeRand(seed);
		popVar = initPop.init(popSize, maxVar);
		velocity = initVel.init(popSize, maxVar);


		for(int i = 0; i < maxGen; i++){
			evaluate.evaluate(popVar, popFit);
			upPbest.update(pBestVar, pBestFit, popVar, popFit, optimization);
			gBestFit = upGbest.update(pBestVar, pBestFit, gBestVar, gBestFit, optimization);
			upPop.update(popVar, pBestFit, velocity, pBestVar, gBestVar, w, c1, c2);
			System.out.println(gBestFit);
		}
	}

}
