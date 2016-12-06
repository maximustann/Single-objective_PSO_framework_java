/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO framework
 * Description:  PSO framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * RosenbrockUnNormalizedFit.java an implementation of unNormalizedFit
 */
package Rosenbrock;

import algorithms.Particle;
import algorithms.UnNormalizedFit;
import commonRepresentation.RealParticle;
/**
 * An example of unNormalizedFit
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class RosenbrockUnNormalizedFit extends UnNormalizedFit{
	/**
	 * @param individual the particle that you want to evaluate.
	 */
	public RosenbrockUnNormalizedFit(Particle individual){
		super(individual);
	}
	
	
	@Override
	/**
	 * a call() function need to be implemented, because unNormalizedFit 
	 * implement the Callable interface.
	 */
	public Object call() throws Exception {
		int maxVar = individual.size();
		
		double fit = 0.0;
		for(int j = 0; j < maxVar - 1; j++){
			double firstTerm, secondTerm;
			firstTerm = ((RealParticle) individual).individual[j + 1] - 
					Math.pow(((RealParticle) individual).individual[j], 2);
			secondTerm = Math.pow(((RealParticle) individual).individual[j] - 1, 2);
			fit += 100 * (firstTerm * firstTerm) + secondTerm;
		}
		// just initialize the ranking with 0, because this call() will be executed in thread, 
		// therefore it is hard to initialize ranking here.
		
		return fit;
	}
}
