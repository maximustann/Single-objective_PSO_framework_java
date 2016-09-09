package TestFunction;
import java.util.ArrayList;

import ProblemDefine.*;
import algorithms.*;
import psoFactory.*;

public class Experiment {
	public static void main(String[] arg) {
		ArrayList<FitnessFunction> funcList = new ArrayList<FitnessFunction>();
		double w = 0.689;
		double c1 = 1.427;
		double c2 = 1.427;
		double lbound = 1;
		double ubound = 100;
		int optimization = 0; //minimize
		int popSize = 50;
		int maxGen = 50;
		int d = 20;

		// Initialization !!!!

		FitnessFunction fitnessFunction = new TestFunctionFitness();
		funcList.add(fitnessFunction);
		Evaluate evaluate = new TestFunctionEvaluate(funcList);

		ProblemParameterSettings proSet = new TestFunctionParameterSettings(evaluate);
		ParameterSettings pars = new ParameterSettings(w, c1, c2, lbound, ubound, optimization, popSize,
														maxGen, d);
		PSO myAlg = new CPSO(pars, proSet, new OriginalCPSOFactory());
		myAlg.run(11111);
		System.out.println("Done!");
	}
}
