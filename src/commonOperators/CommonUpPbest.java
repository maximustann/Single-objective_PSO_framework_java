package commonOperators;
import algorithms.UpdatePbest;

public class CommonUpPbest implements UpdatePbest{

	public void update(double[][] pBestVar, double[] pBestFit, double[][] popVar, double[] popFit, int optimization) {
		int popSize = pBestVar.length;
		int maxVar = pBestVar[0].length;

		// Go through whole population
		for(int i = 0; i < popSize; i++){

			// Check if the current fitness is better than previous pBest
			if((pBestFit[i] > popFit[i] && optimization == 0) || ( pBestFit[i] < popFit[i] && optimization == 1)){
				pBestFit[i] = popFit[i];
				// update each personal Best
				for(int j = 0; j < maxVar; j++){
					pBestVar[i][j] = popVar[i][j];
				}
			}
		}
	}

}
