/*
 * Boxiong Tan (Maximus Tann)
 * Title:        GA framework
 * Description:  GA framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * BPSOHaiCostFitness.java - cost fitness from Hai's Paper
 */
package BPSOAllocationProblem;
import algorithms.*;
import commonRepresentation.IntParticle;
/**
 * AllocationParameterSettings for Hai's Paper
 *
 * @author Boxiong Tan (Maximus Tann)
 * @author Hai Huang
 * @since GA framework 1.0
 */
public class BPSOHaiCostFitness extends UnNormalizedFit{
	private static double[] costMatrix;

	
	public BPSOHaiCostFitness(Particle individual){
		super(individual);
	}

	/**
	 * 
	 * @param con a user defined constraint, in this case user define a max cost constraint
	 * @param costMatrix cost matrix, read from file, generate from normal distribution [20,100]
	 */
	public BPSOHaiCostFitness(double[] costMatrix){
		super(null);
		BPSOHaiCostFitness.costMatrix = costMatrix;
	}
	

	@Override
	public Object call() throws Exception {
		double fit = 0;
		int maxVar = individual.size();
		for(int j = 0; j < maxVar; j++){
			 fit += costMatrix[j] * ((IntParticle) individual).individual[j];
		}
		return fit;
	}


}
