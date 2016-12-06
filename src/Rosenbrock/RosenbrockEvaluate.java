/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO framework
 * Description:  PSO framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * RosenbrockEvaluate.java evaluation function
 */
package Rosenbrock;

import java.util.ArrayList;

import algorithms.Particle;
import algorithms.Evaluate;
import algorithms.FitnessFunc;
/**
 * Rosenbrock evaluation function
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class RosenbrockEvaluate implements Evaluate{
	private ArrayList<FitnessFunc> funcList;

	// constructor, initialize fitness function list
	public RosenbrockEvaluate(ArrayList<FitnessFunc> funcList){
		this.funcList = funcList;
	}

	// You can change the fitness function list
	public void setFuncList(ArrayList<FitnessFunc> funcList){
		this.funcList = funcList;
	}

	@Override
	/**
	 * 
	 * an implementation of the evaluate interface.
	 * Basically, the process should evaluate all particles in the popVar array and store
	 * fitness values in popFit.
	 * 
	 * I did not write this as a template because you might want to use weighted sum with multiple
	 * objectives or single objective. So here I provide a list things that you need to do.
	 * 
	 * There are a few steps need to be done.
	 * <ul>
	 * 	<li>execute fitness function, it will return a double[] </li>
	 *  <li>copy tempFit to fitness value</li>
	 * </ul>
	 */
	public void evaluate(Particle[] popVar, double[] popFit) {
		// get fitness function list, just in case you have multiple objective functions.
		FitnessFunc fitnessFunction = funcList.get(0);
		double[] tempFit = null;
		try {
			// execute the evaluation
			tempFit = fitnessFunction.execute(popVar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < tempFit.length; i++) {
			popFit[i] = tempFit[i];
		}
	}
}
