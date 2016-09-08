package algorithms;

import algorithms.StdRandom;

import java.util.Arrays;

import ProblemDefine.*;

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

	// constructor, initialize whole the components
//	public PSO(ParameterSettings pars, ProblemParameterSettings proSet){
//		maxGen = pars.getMaxGen();
//		maxVar = pars.getMaxVar();
//		popSize = pars.getPopSize();
//		w = pars.getW();
//		c1 = pars.getC1();
//		c2 = pars.getC2();
////		lbound = pars.getLbound();
////		ubound = pars.getUbound();
//		optimization = pars.getOptimization();
//		popFit = new double[popSize];
//		pBestVar = new double[popSize][maxVar];
//		pBestFit = new double[popSize];
//		gBestVar = new double[maxVar];

//		prepare();

//		initPop = proSet.getInitPop();
//		initVel = proSet.getInitVel();
//		evaluate = proSet.getEvaluate();
//		upGbest = proSet.getUpGbest();
//		upPbest = proSet.getUpPbest();
//		upPop = proSet.getUpPop();

//		gBestFit = 1;
//		Arrays.fill(pBestFit, 1.0);
//	}

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
