package TestFunction;
import java.util.ArrayList;

import ProblemDefine.*;
import algorithms.*;
import dataCollector.DataCollector;
import distanceMeasure.DistanceMeasure;
import distanceMeasure.EuclideanDistance;
import psoFactory.*;

public class Experiment {
	public static void main(String[] arg) {
		ArrayList<FitnessFunction> funcList = new ArrayList<FitnessFunction>();
		double w = 2;
		double c1 = 2;
		double c2 = 2;
		double lbound = -30; // ranging in [-30, 30]
		double ubound = 30;
		int optimization = 0; //minimize
		int popSize = 50;
		int maxGen = 10000;
		int d = 20;

		// Initialization !!!!
		FitnessFunction fitnessFunction = new TestFunctionFitness();
		funcList.add(fitnessFunction);
		Evaluate evaluate = new TestFunctionEvaluate(funcList);


		ProblemParameterSettings proSet = new TestFunctionParameterSettings(evaluate);
		ParameterSettings pars = new ParameterSettings(w, c1, c2, lbound, ubound, optimization, popSize,
														maxGen, d);
		DataCollector collector = new ResultCollector();
		DistanceMeasure euclidean = new EuclideanDistance();
		// initialize a continuous version of PSO
//		PSO myAlg = new CPSO(pars, proSet, new OriginalCPSOFactory());
		PSO myAlg = new CPSOLocal(pars, proSet, new RingCPSOFactory(euclidean, collector));
		myAlg.run(11111); // parameter is a random seed
		((ResultCollector) collector).printResult();
		System.out.println("Done!");
	}
}
