package algorithms;

import algorithms.StdRandom;

import java.util.Arrays;

import ProblemDefine.*;

public class PSO {
	private InitPop initPop;
	private InitVelocity initVel;
	private Evaluate evaluate;
	private UpdateGbest upGbest;
	private UpdatePbest upPbest;
	private UpPop upPop;

	// algorithm related parameter settings
	private double[] popFit;
	private double[] pBestFit;
	private double[][] velocity;

	private double[][] popVar;
	private double[][] pBestVar;
	private double[] gBestVar;

	private double gBestFit;


	// Problem related parameter settings
	private int optimization;
	private int popSize;
	private int maxGen;
	private int maxVar;

//	private double lbound, ubound;
	private double w;
	private double c1, c2;

	// constructor, initialize whole the components
	public PSO(ParameterSettings pars, ProblemParameterSettings proSet){
		maxGen = pars.getMaxGen();
		maxVar = pars.getMaxVar();
		popSize = pars.getPopSize();
		w = pars.getW();
		c1 = pars.getC1();
		c2 = pars.getC2();
//		lbound = pars.getLbound();
//		ubound = pars.getUbound();
		optimization = pars.getOptimization();
		popFit = new double[popSize];
		pBestVar = new double[popSize][maxVar];
		pBestFit = new double[popSize];
		gBestVar = new double[maxVar];


		initPop = proSet.getInitPop();
		initVel = proSet.getInitVel();
		evaluate = proSet.getEvaluate();
		upGbest = proSet.getUpGbest();
		upPbest = proSet.getUpPbest();
		upPop = proSet.getUpPop();

		gBestFit = 1;
		Arrays.fill(pBestFit, 1.0);

	}


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
