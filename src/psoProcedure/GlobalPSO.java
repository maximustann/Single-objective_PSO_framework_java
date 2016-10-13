/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * GlobalPSO.java - A abstract class of global version PSO procedure, prepare() is need to be implemented
 */
package psoProcedure;
import algorithms.PSO;
import algorithms.UpPopGlobal;


/**
 * Global PSO procedure
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public abstract class GlobalPSO extends PSO{

	/**
	 * The procedure of PSO
	 * 1. initialize population
	 * 2. initialize velocity
	 * From generation = 1 to max generation {
	 * 		Evaluate population
	 * 		update Personal Best
	 * 		Update Global best
	 * 		Update Population
	 * 		For Debug:  Collect Global best
	 * 					Collect Particle
	 * 	}
	 *
	 * @param seed random seed
	 *
	 */
	public void run(int seed){
		initializeRand(seed);
		popVar = initPop.init(popSize, maxVar, lbound, ubound);
		velocity = initVel.init(popSize, maxVar);


		for(int i = 0; i < maxGen; i++){
			evaluate.evaluate(popVar, popFit);
			upPbest.update(
							pBestVar,
							pBestFit,
							popVar,
							popFit,
							optimization,
							i);

			gBestFit = upGbest.update(
									pBestVar,
									pBestFit,
									gBestVar,
									gBestFit,
									optimization,
									i);

			((UpPopGlobal) upPop).update(popVar,
										pBestFit,
										velocity,
										pBestVar,
										gBestVar,
										w, c1, c2,
										lbound, ubound);
			collector.collect(gBestFit);
			collector.collectParticle(popVar);
		}
	}

	/**
	 * Equivalent to a constructor, you need to initialize all parameters in PSO
	 */
	@Override
	protected abstract void prepare();
}
