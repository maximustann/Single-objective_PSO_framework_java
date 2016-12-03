/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * LocalPSO.java - A abstract class of local version PSO procedure, prepare() is need to be implemented
 */
package psoProcedure;
import algorithms.PSO;
import algorithms.UpPopLocal;
import algorithms.Particle;
/**
 * Local PSO procedure
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public abstract class LocalPSO extends PSO{
	/**
	 * The procedure of PSO
	 * <ul>
	 * <li>start timer</li>
	 * <li>1. initialize population</li>
	 * <li>2. initialize velocity</li>
	 * <ul>
	 * 	<li>From generation = 1 to max generation {</li>
	 * 		<li>Evaluate population</li>
	 * 		<li>update Personal Best</li>
	 * 		<li>Update Local best</li>
	 * 		<li>Update Population</li>
	 * 		<li>For Debug:  Collect Global best
	 * 					Collect Particle</li>
	 * 	<li>}</li>
	 * </ul>
	 * <li>end timer</li>
	 * </ul>
	 * @param seed random seed
	 *
	 */
	public void run(int seed){
		collector.collectTime(0);
		initializeRand(seed);
		popVar = initPop.init(popSize, maxVar, lbound, ubound);
		velocity = initVel.init(popSize, maxVar);


		for(int i = 0; i < maxGen; i++){
			evaluate.evaluate(popVar, popFit);
			w = dynW.update(i);
			upPbest.update(
							pBestVar,
							pBestFit,
							popVar,
							popFit,
							optimization,
							i
						   );
			upLbest.update(
							pBestVar,
							pBestFit,
							lBestVar,
							lBestFit,
							optimization,
							i
						   );
			((UpPopLocal) upPop).update(
							popVar,
							pBestFit,
							velocity,
							pBestVar,
							lBestVar,
							w, c1, c2,
							lbound, ubound
						   );
			collector.collect(lBestFit);
		}
		collector.collectTime(1);
	}

	@Override
	protected abstract void prepare();
	public void runNtimes(int seedStart, int nTimes){
		for(int i = 0; i < nTimes; i++){
			run(seedStart + i);
		}
	}
}
