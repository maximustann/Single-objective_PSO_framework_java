package Rosenbrock;
import java.util.ArrayList;

import ProblemDefine.*;
import algorithms.*;
import dataCollector.DataCollector;
import psoFactory.*;

public class Experiment {
	public static void main(String[] arg) {
		ArrayList<FitnessFunction> funcList = new ArrayList<FitnessFunction>();
		double w = 0.6;
		double c1 = 2;
		double c2 = 2;
		double lbound = -30; // ranging in [-30, 30]
		double ubound = 30;
		double lboundW = 0.2;
		double uboundW = 0.8;
		double balance = 0.9;
		double clampFactor = 0.2; // clamp the velocity from [-clampFactor * (ubound - lbound), clampFactor * (ubound - lbound)]
		int optimization = 0; //minimize
		int popSize = 50;
		int maxGen = 1000;
		int d = 20; // number of dimensions
//		double threshold = 0.7;

		// Initialization !!!!
		FitnessFunction fitnessFunction = new TestFunctionFitness();
		funcList.add(fitnessFunction);

		// CPSO evaluation
		Evaluate evaluate = new TestFunctionEvaluate(funcList);

		// Rounding BPSO evaluation
//		Evaluate evaluate = new RoundingEvaluate(funcList, threshold);

		ProblemParameterSettings proSet = new TestFunctionParameterSettings(evaluate);
		ParameterSettings pars = new ParameterSettings(
										w, balance, c1, c2, 
										lbound, ubound, lboundW, uboundW,
										clampFactor, optimization, popSize, maxGen, d);
//		DataCollector collectorArray = new ArrayResultCollector();
		DataCollector collector = new ResultCollector();
		// initialize a continuous version of PSO

		// global version
		PSO myAlg = new CPSO(pars, proSet, new OriginalCPSOFactory(collector));

		// local version
//		PSO myAlg = new CPSOLocal(pars, proSet, new RingCPSOFactory(collectorArray));


		// initialize a binary version of PSO

		// global version
//		PSO myAlg = new BPSO(pars, proSet, new OriginalBPSOFactory(collector));


		myAlg.run(233); // parameter is a random seed
		((ResultCollector) collector).printResult();
//		((ResultCollector) collector).printParticle();
//		((ArrayResultCollector) collectorArray).printResult();
		System.out.println("Done!");
	}
}
