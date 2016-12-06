/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO framework
 * Description:  PSO framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * Experiment.java 	The main function.
 * 
 */
package Rosenbrock;
import java.util.ArrayList;
import ProblemDefine.*;
import algorithms.Evaluate;
import algorithms.FitnessFunc;
import algorithms.PSO;
import dataCollector.DataCollector;
import psoFactory.CPSO;
import psoFactory.OriginalCPSOFactory;
/**
 * An example of the main function
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class Experiment {
	/**
	 * Initialize all parameters, set up evaluation function.
	 * Run algorithm.
	 * Print results.
	 */
	public static void main(String[] arg) {
		/** store your objective functions */
		ArrayList<FitnessFunc> funcList = new ArrayList<FitnessFunc>();

		/** inertia value */
		double w = 2;
		
		/** balance is used in dynamic inertia. It balance exploration and exploitation */
		double balance = 0;
		
		/** cognitive and social parameters */
		double c1 = 1.5;
		double c2 = 2;
		
		/** lower and upper bound of X */
		double lbound = -30; // ranging in [-30, 30]
		double ubound = 30;
		
		/** upper bound and lower bound of inertia weight */
		double lboundW = 0.4;
		double uboundW = 1.0;	
		
		/** clamp the velocity from 
		 * [-clampFactor * (ubound - lbound), clampFactor * (ubound - lbound)]
		 */
		double clampFactor = 0.8; 
		
		/** optimization direction 0 denotes minimization, 1 denotes maximization */
		int optimization = 0; //minimize
		
		/** population size */
		int popSize = 50;
		
		/** maximum generation number */
		int maxGen = 100;
		int d = 20; // number of dimensions

		/** Initialize fitness function */
		FitnessFunc fitnessFunction = new FitnessFunc(RosenbrockUnNormalizedFit.class);
		funcList.add(fitnessFunction);

		/** register fitness function into your evaluation function */
		Evaluate evaluate = new RosenbrockEvaluate(funcList);

		/** register evaluation in problem parameter settings*/
		ProblemParameterSettings proSet = new RosenbrockParameterSettings(evaluate);
		
		/** Initialize algorithm parameter settings */
		ParameterSettings pars = new ParameterSettings(
									w, balance, c1, c2, lbound,
									ubound, lboundW, uboundW, clampFactor, 
									optimization, popSize, maxGen, d);
		
		/** set up DataCollector */
		DataCollector collector = new ResultCollector();

		/** select a type of genetic algorithm, initialize it with a factory */
		PSO myAlg = new CPSO(pars, proSet, new OriginalCPSOFactory(collector));



		/** start to run */
//		myAlg.run(233333); // parameter is a random seed
		myAlg.runNtimes(23333, 30);
		
		/** print results */
		((ResultCollector) collector).printBestInRuns(maxGen);
		((ResultCollector) collector).printMeanTime();;

//		((ResultCollector) collector).printPop();
		System.out.println("Done!");
	}
}
