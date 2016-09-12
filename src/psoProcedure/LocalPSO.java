package psoProcedure;
import algorithms.PSO;
import algorithms.UpPopLocal;
public abstract class LocalPSO extends PSO{
	public void run(int seed){
		initializeRand(seed);
		popVar = initPop.init(popSize, maxVar, lbound, ubound);
		velocity = initVel.init(popSize, maxVar);


		for(int i = 0; i < maxGen; i++){
			evaluate.evaluate(popVar, popFit);
			upPbest.update(pBestVar, pBestFit, popVar, popFit, optimization, i);
			upIbest.update(pBestVar, pBestFit, iBestVar, iBestFit, optimization, i);
			((UpPopLocal) upPop).update(popVar, pBestFit, velocity, pBestVar, iBestVar, w, c1, c2);
			for(int j = 0; j < popSize; j++) System.out.println(iBestFit[j] + " ");
			System.out.println();
		}
	}

	@Override
	protected abstract void prepare();
}
