/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * CommonUpGlobalPop.java - A method to update population variables for a global-based PSO.
 */
package commonOperators;
import algorithms.Particle;
import algorithms.StdRandom;
import algorithms.UpPopGlobal;
import algorithms.VelocityClamping;
import commonRepresentation.RealParticle;

/**
 * Update of population variables for a global-based PSO
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class RealUpGlobalPop implements UpPopGlobal{
	/** An VelocityClamping object for clamping velocity */
	private VelocityClamping clamper;

	/** 
	 * constructor, initialize the clamper
	 * @param clamper a velocity clamper
	 */
	public RealUpGlobalPop(VelocityClamping clamper){
		this.clamper = clamper;
	}

    /**
     * update the population based on personal best and global best
     *
     * Steps:
     * <ul>
     * <li> 1. update velocity 			</li>
     * <li> 2. Do velocity clamping 		</li>
     * <li> 3. Update particle positions	</li>
     * </ul>
     * @param popVar population variables.
     * @param pBestFit an array of personal best fitness values.
     * @param velocity 2D-array of velocity.
     * @param pBestVar personal best variables.
     * @param gBestVar global best variables.
     * @param w inertia.
     * @param c1 cognitive parameter
     * @param c2 social parameter
     * @param lbound lower bound of variable
     * @param ubound upper bound of variable
     */
	@Override
	public void update(
					Particle[] 		popVar,
					double[] 		pBestFit,
					double[][] 		velocity,
					Particle[] 		pBestVar,
					Particle 		gBestVar,
					double 			w,
					double 			c1,
					double 			c2,
					double 			lbound,
					double			ubound
					) {
		int popSize = popVar.length;
		int maxVar  = popVar[0].size();

		// Go through whole population
		for(int i = 0; i < popSize; i++){
			// update each dimension
			for(int j = 0; j < maxVar; j++){
				velocity[i][j] =
						w * velocity[i][j] 
						+ c1 * StdRandom.uniform(0.0, 1.0) * (((RealParticle) pBestVar[i]).individual[j] 
						- ((RealParticle) popVar[i]).individual[j]) 
						+ c2 * StdRandom.uniform(0.0, 1.0) * (((RealParticle) gBestVar).individual[j] 
					    - ((RealParticle) popVar[i]).individual[j]);
			}
		}

		// do clamping
		clamper.clamping(velocity, lbound, ubound);

		// Calculate new positions of particles
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				((RealParticle) popVar[i]).individual[j] += velocity[i][j];
			}
		}
	}


}
