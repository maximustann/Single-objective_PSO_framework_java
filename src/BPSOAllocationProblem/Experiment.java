package BPSOAllocationProblem;
import java.util.ArrayList;

import BPSO.*;
import ProblemDefine.*;
import algorithms.*;

public class Experiment {
	public static void main(String[] arg) {
		ArrayList<FitnessFunction> funcList = new ArrayList<FitnessFunction>();
		double[] weights = new double[2];
		double w = 0.4;
		double c1 = 2;
		double c2 = 2;
		double lbound = 0;
		double ubound = 1;
		int optimization = 0;
		int popSize = 50;
		int maxGen = 100;
		weights[0] = weights[1] = 0.5;
		

		// Initialization !!!!
		InitPop initPop = new BPSOInitPop();
		InitVelocity initVel = new BPSOInitVel();
		UpdatePbest upPbest = new BPSOupPbest();
		UpdateGbest upGbest = new BPSOupGbest();
		UpPop upPop = new BPSOupPop();
		Normalize costLinear = new LinearScaling(Cmax, Cmin);
		Normalize timeLinear = new LinearScaling(Tmax, Tmin);
		FitnessFunction cost = new BPSOHaiCostFitness(costLinear, costMatrix);
		FitnessFunction time = new BPSOHaiTimeFitness(timeLinear, latencyMatrix, noService);
		funcList.add(cost);
		funcList.add(time);
		Evaluate evaluate = new BPSOHaiEvaluate(funcList, weights);

		ProblemParameterSettings proSet = new ProblemParameterSettings(initPop, initVel, upGbest, 
											upPbest, evaluate, upPop, 0, 0, 0, 0, 0, weights, weights, weights);
		ParameterSettings pars = new ParameterSettings(w, c1, c2, lbound, ubound, optimization, popSize, maxGen, 0);
		PSO myAlg = new PSO(pars, proSet);
		myAlg.run(1);
	}
}
