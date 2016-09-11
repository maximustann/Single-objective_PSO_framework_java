package psoProcedure;
import algorithms.PSO;
public abstract class GlobalPSO extends PSO{
	public void run(int seed){
		initializeRand(seed);
		popVar = initPop.init(popSize, maxVar, lbound, ubound);
		velocity = initVel.init(popSize, maxVar);


		for(int i = 0; i < maxGen; i++){
			evaluate.evaluate(popVar, popFit);
			upPbest.update(pBestVar, pBestFit, popVar, popFit, optimization, i);
			gBestFit = upGbest.update(pBestVar, pBestFit, gBestVar, gBestFit, optimization, i);
			upPop.update(popVar, pBestFit, velocity, pBestVar, gBestVar, w, c1, c2);
			System.out.println(gBestFit);
		}	
	}

	@Override
	protected abstract void prepare();
}
