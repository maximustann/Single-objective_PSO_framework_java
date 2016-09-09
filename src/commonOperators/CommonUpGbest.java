package commonOperators;
import algorithms.UpdateGbest;
public class CommonUpGbest implements UpdateGbest{

	@Override
	public double update(double[][] pBestVar, double [] pBestFit, double[] gBestVar, double gBestFit, int optimization, int generation) {
		int popSize = pBestVar.length;
		int bestIndex = 0;

		if(generation == 0){
			gBestFit = pBestFit[0];
//			System.out.println(gBestFit);
			for(int i = 0; i < popSize; i++){
				// If minimize, smaller the better
				// If maximize, bigger the better
				if((gBestFit > pBestFit[i] && optimization == 0) || (gBestFit < pBestFit[i] && optimization == 1)){
					gBestFit = pBestFit[i];
					bestIndex = i;
				}
			}
		} else {
			// Searching for the global best from pBest
			for(int i = 0; i < popSize; i++){
				// If minimize, smaller the better
				// If maximize, bigger the better
				if((gBestFit > pBestFit[i] && optimization == 0) || (gBestFit < pBestFit[i] && optimization == 1)){
					gBestFit = pBestFit[i];
					bestIndex = i;
				}
			}
		}

		// Save the global best particle
		for(int i = 0; i < pBestVar[0].length; i++){
			gBestVar[i] = pBestVar[bestIndex][i];
		}
		return gBestFit;
	}
}
