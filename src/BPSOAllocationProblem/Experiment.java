package BPSOAllocationProblem;
import java.util.ArrayList;

import ProblemDefine.*;
import algorithms.*;
import dataCollector.DataCollector;
import psoFactory.*;

public class Experiment {
	public static void main(String[] arg) {
		ArrayList<FitnessFunction> funcList = new ArrayList<FitnessFunction>();
		double[] weights = new double[2];
		double w = 0.689;
		double balance = 0.9;
//		double w = 1;
		double c1 = 1.427;
		double c2 = 1.427;
		double lbound = 0;
		double ubound = 2;
		double lboundW = 0.4;
		double uboundW = 1;
		double clampFactor = 8;
		int optimization = 0; //minimize
		int popSize = 100;
		int maxGen = 250;
		weights[0] = weights[1] = 0.5;

		double[] costMatrix;
		double[] freqMatrix;
		double[] latencyMatrix;

		int testCase = 2;
		int noService;
		int noLocation;
		double Cmax, Cmin, Tmax, Tmin;
		String base = "/Users/maximustann/Documents/workspace/HaiProjData/testCase" + testCase;
		String configAddr = base + "/config.csv";
		String costAddr = base + "/cost.csv";
		String latencyAddr = base + "/latency.csv";
		String freqAddr = base + "/freq.csv";
		String costRangeAddr = base + "/costRange.csv";
		String timeRangeAddr = base + "/timeRange.csv";

		ReadFileHai readFiles = new ReadFileHai(
												configAddr, 
												costAddr, 
												latencyAddr, 
												freqAddr, 
												costRangeAddr, 
												timeRangeAddr
												);
		costMatrix = readFiles.getCostMatrix();
		latencyMatrix = readFiles.getLatencyMatrix();


		freqMatrix = readFiles.getFreqMatrix();
		noService = readFiles.getNoService();
		noLocation = readFiles.getNoLocation();
		Cmax = readFiles.getCmax();
		Cmin = readFiles.getCmin();
		Tmax = readFiles.getTmax();
		Tmin = readFiles.getTmin();

		// Initialization !!!!
		Constraint costCon = new Constraint(noService);
		Constraint timeCon = new Constraint(noService);
		Normalize costLinear = new LinearScaling(Cmax, Cmin);
		Normalize timeLinear = new LinearScaling(Tmax, Tmin);
		FitnessFunction cost = new BPSOHaiCostFitness(costLinear, costCon, costMatrix);
		FitnessFunction time = new BPSOHaiTimeFitness(timeLinear, timeCon, latencyMatrix, freqMatrix, 
													noService, noLocation);
		funcList.add(cost);
		funcList.add(time);
		Evaluate evaluate = new BPSOHaiEvaluate(funcList, weights);
		DataCollector collector = new ResultCollector();


		ProblemParameterSettings proSet = new AllocationParameterSettings(evaluate, costMatrix, freqMatrix, latencyMatrix);
		ParameterSettings pars = new ParameterSettings(
										w, balance, c1, c2, 
										lbound, ubound, lboundW, uboundW,
										clampFactor,optimization, popSize,
										maxGen, noService * noLocation);
		PSO myAlg = new BPSO(pars, proSet, new OriginalBPSOFactory(collector));
//		myAlg.run(11111)
		myAlg.runNtimes(2333, 3);
		((ResultCollector) collector).printResult();
		((ResultCollector) collector).mean(3);
		((ResultCollector) collector).printMeanTime();
		System.out.println("Done!");
	}
}
