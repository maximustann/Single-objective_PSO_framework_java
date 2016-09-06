package BPSOAllocationProblem;

import algorithms.Normalize;

public class LinearScaling implements Normalize{
	private double max, min;
	public LinearScaling(double max, double min){
		this.max = max;
		this.min = min;
	}

	public double[] doNorm(double[] fitness){

		for(int i = 0; i < fitness.length; i++){
			fitness[i] = (fitness[i] - min) / (max - min);
		}
		return fitness;
	}
}
