package spherical;
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
		double lbound = -100; // ranging in [-100, 100]
		double ubound = 100;
		double clampFactor = 0.8; // clamp the velocity from [-clampFactor * (ubound - lbound), clampFactor * (ubound - lbound)]
		int optimization = 0; //minimize
		int popSize = 30;
		int maxGen = 10;
		int d = 20; // number of dimensions
		double threshold = 0.5;

		// Initialization !!!!
		FitnessFunction fitnessFunction = new TestFunctionFitness();
		funcList.add(fitnessFunction);
		
		// CPSO evaluation
//		Evaluate evaluate = new TestFunctionEvaluate(funcList);

		// Rounding BPSO evaluation
		Evaluate evaluate = new RoundingEvaluate(funcList, threshold);

		ProblemParameterSettings proSet = new TestFunctionParameterSettings(evaluate);
		ParameterSettings pars = new ParameterSettings(w, c1, c2, lbound, ubound, clampFactor,
														optimization, popSize, maxGen, d);
//		DataCollector collectorArray = new ArrayResultCollector();
		DataCollector collector = new ResultCollector();
//		DistanceMeasure euclidean = new EuclideanDistance();
		// initialize a continuous version of PSO
		
		// global version
		PSO myAlg = new CPSO(pars, proSet, new OriginalCPSOFactory(collector));
		
		// local version
//		PSO myAlg = new CPSOLocal(pars, proSet, new RingCPSOFactory(euclidean, collectorArray));
		
		
		// initialize a binary version of PSO
		// global version
//		PSO myAlg = new BPSO(pars, proSet, new OriginalBPSOFactory(collector));
		
		
		myAlg.run(111); // parameter is a random seed
		((ResultCollector) collector).printResult();
		((ResultCollector) collector).printParticle();
//		((ArrayResultCollector) collectorArray).printResult();
		System.out.println("Done!");
	}
}
