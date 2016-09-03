package BPSO;

import algorithms.InitPop;
import algorithms.StdRandom;

public class BPSOInitPop implements InitPop{

	@Override
	public void init(double[][] popVar) {
		int popSize = popVar.length;
		int maxVar = popSize * popVar[0].length;

		// initialize population
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				popVar[i][j] = (double) StdRandom.uniform(0, 1);
			}
		}
	}
}
