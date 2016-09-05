package BPSOAllocationProblem;

import algorithms.*;
public class BPSOHaiCostFitness extends FitnessFunc{
	private double[] costMatrix;
	Constraint con;

	public BPSOHaiCostFitness(Normalize normalize, Constraint con, double[] costMatrix){
		super(normalize);
		this.con = con;
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

	public double[] normalizedFit(double[][] popVar){
		double[] fitness = unNormalizedFit(popVar);
		normalize.doNorm(fitness);
		fitness = con.punish(popVar, fitness);
		return fitness;

	}
}
