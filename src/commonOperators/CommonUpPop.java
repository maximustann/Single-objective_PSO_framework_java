package commonOperators;
import algorithms.StdRandom;
import algorithms.UpPop;
public class CommonUpPop implements UpPop{

	@Override
	public void update(double[][] popVar, double[] pBestFit, double[][] velocity,
						double[][] pBestVar, double[] gBestVar, double w, double c1, double c2) {
		int popSize = popVar.length;
		int maxVar = popVar[0].length;

		// Go through whole population
		for(int i = 0; i < popSize; i++){
			// update each dimension
			for(int j = 0; j < maxVar; j++){
				velocity[i][j] = w * velocity[i][j] + c1 * StdRandom.uniform(0.0, 1.0) *
						(pBestVar[i][j] - popVar[i][j]) + c2 * StdRandom.uniform(0.0, 1.0) *
						(gBestVar[j] - popVar[i][j]);
			}
		}

		// Calculate new positions of particles
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				popVar[i][j] += velocity[i][j];
			}
		}
	}


}
