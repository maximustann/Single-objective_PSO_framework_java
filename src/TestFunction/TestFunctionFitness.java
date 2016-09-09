package TestFunction;

import algorithms.*;
public class TestFunctionFitness implements FitnessFunction{

	public double[] unNormalizedFit(double[][] popVar){
		double[] fitness = new double[popVar.length];
		for(int i = 0; i < popVar.length; i++){
			for(int j = 0; j < popVar[0].length - 1; j++){
				fitness[i] += 100 * (popVar[i][j] * popVar[i][j] - popVar[i][j + 1]) *
						(popVar[i][j] * popVar[i][j] - popVar[i][j + 1]) + (popVar[i][j] - 1) * (popVar[i][j] - 1);
			}
		}
		return fitness;
	}

	public double[] normalizedFit(double[][] popVar){
		double[] fitness = unNormalizedFit(popVar);
		return fitness;

	}
}
