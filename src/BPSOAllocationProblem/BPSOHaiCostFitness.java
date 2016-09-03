package BPSOAllocationProblem;

import algorithms.*;
public class BPSOHaiCostFitness extends FitnessFunc{

	public BPSOHaiCostFitness(Normalize normalize, double max, double min){
		super(normalize, max, min);
	}

	public double[] unNormalizedFit(double[][] popVar){
		double [] fitness = new double[popVar.length];
	// TO DO
		return fitness;
	}
}
