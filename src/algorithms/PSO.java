package algorithms;
import java.util.List;

import algorithms.StdRandom;
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
	private double lbound, ubound;
	private double w;
	private double c1, c2;

	// constructor
	public PSO(ParameterSettings pars, ProblemParameterSettings proSet){
		maxGen = pars.getMaxGen();
		maxVar = pars.getMaxVar();
		popSize = pars.getPopSize();
		w = pars.getW();
		c1 = pars.getC1();
		c2 = pars.getC2();
		lbound = pars.getLbound();
		ubound = pars.getUbound();
		optimization = pars.getOptimization();
		velocity = new double[popSize][maxVar];
		popVar = new double[popSize][maxVar];
		pBestVar = new double[popSize][maxVar];
		gBestVar = new double[maxVar];


		initPop = proSet.getInitPop();
		initVel = proSet.getInitVel();


	}


	// Initialize random
	private void initializeRand(int seed){
		StdRandom.setSeed(seed);
	}

	// Run the algorithm
	public void run(int seed){
		initializeRand(seed);
		initPop.init(pBestVar);
		initVel.init(velocity);

		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				System.out.print(popVar[i][j] + ", ");
			}
			System.out.println();
		}

		for(int i = 0; i < maxGen; i++){
			evaluate.evaluate(popVar, popFit);
			upPbest.update(pBestVar, pBestFit, popVar, popFit, optimization);
			gBestFit = upGbest.update(pBestVar, pBestFit, gBestVar, gBestFit, optimization);
			upPop.update(popVar, pBestFit, velocity, pBestVar, gBestVar, w, c1, c2);
		}
	}

}
