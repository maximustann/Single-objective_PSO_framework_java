package BPSOAllocationProblem;

import algorithms.*;
public class BPSOHaiCostFitness extends FitnessFunc{
	private double[] costMatrix;

	public BPSOHaiCostFitness(Normalize normalize, double[] costMatrix){
		super(normalize);
		this.costMatrix = costMatrix;
	}

	public double[] unNormalizedFit(double[][] popVar){
		int popSize = popVar.length;
		int maxVar = popVar[0].length;
		double [] fitness = new double[popSize];
		for(int i= 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				fitness[i] += costMatrix[j] * popVar[i][j];
			}
		}
		return fitness;
	}
}
