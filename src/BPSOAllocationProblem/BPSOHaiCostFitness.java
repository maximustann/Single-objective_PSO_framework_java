/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * BPSOHaiCostFitness.java - cost fitness from Hai's Paper
 */
package BPSOAllocationProblem;
/**
 * AllocationParameterSettings for Hai's Paper
 *
 * @author Boxiong Tan (Maximus Tann)
 * @author Hai Huang
 * @since PSO framework 1.0
 */
import algorithms.*;
public class BPSOHaiCostFitness extends FitnessFunc{
	private double[] costMatrix;
	Constraint con;

	/**
	 * 
	 * @param normalize a user defined normalization method
	 * @param con a user defined constraint, in this case user define a max cost constraint
	 * @param costMatrix cost matrix, read from file, generate from normal distribution [20,100]
	 */
	public BPSOHaiCostFitness(Normalize normalize, Constraint con, double[] costMatrix){
		super(normalize);
		this.con = con;
		this.costMatrix = costMatrix;
	}

	/**
	 * Simply sum all the deployed services
	 */
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

	/**
	 * 
	 * Steps:
	 * <ul>
	 * 	<li>1. calculate fitness values</li>
	 * 	<li>2. normalize fitness values</li>
	 * 	<li>3. punish fitness values</li>
	 * </ul>
	 */
	public double[] normalizedFit(double[][] popVar){
		double[] fitness = unNormalizedFit(popVar);
		normalize.doNorm(fitness);
		fitness = con.punish(popVar, fitness);		
		for(int i = 0; i < popVar.length; i++){
			if(fitness[i] < 0)
				System.out.println("detected: " + i + ", fitness = " + fitness[i]);
		}
//		System.out.println();
		return fitness;

	}
}
