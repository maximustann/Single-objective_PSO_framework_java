package spherical;

import algorithms.*;
public class TestFunctionFitness implements FitnessFunction{

	public double[] unNormalizedFit(double[][] popVar){
		double[] fitness = new double[popVar.length];
		for(int i = 0; i < popVar.length; i++){
			for(int j = 0; j < popVar[0].length; j++){
				fitness[i] += popVar[i][j] * popVar[i][j];
			}
		}
		return fitness;
	}

	public double[] normalizedFit(double[][] popVar){
		return unNormalizedFit(popVar);
	}
}
