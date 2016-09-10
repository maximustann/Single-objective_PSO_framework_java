package commonOperators;

import algorithms.InitPop;
import algorithms.StdRandom;
// Common operators are the operators of continuous PSO
public class CommonInitPop implements InitPop{

	@Override
	public double[][] init(int popSize, int maxVar, double lbound, double ubound) {
		double[][] realVar = new double[popSize][maxVar];

		// initialize population
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				realVar[i][j] = StdRandom.uniform(lbound, ubound);
			}
		}
		return realVar;
	}
}
