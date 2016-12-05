/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * FitnessFunc.java - An abstract of common fitness function.
 */

package algorithms;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * FitnessFunc abstract class provides a number of protocol for 
 * evaluating fitness functions
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class FitnessFunc{
	
	@SuppressWarnings("rawtypes")
	private Class childType;
	@SuppressWarnings("rawtypes")
	/**
	 * If your unNormalized fitness function does not implement the UnNormalizedFit interface,
	 * an exception will be raised. 
	 * @param unNorFit the class type of your unNormalized function
	 */
	public FitnessFunc(Class unNorFit){
		if(!UnNormalizedFit.class.isAssignableFrom(unNorFit)){
			throw new IllegalArgumentException("Class: " + unNorFit.getName() + " must "
					+ "implement UnNormalizedFit interface");
		}
		childType = unNorFit;
	}
	
    /**
     * execute method is a function that calls you defined unNormalized fitness function and
     * then return a fitness value list 
     * Steps:
     * <ul>
     * 	<li>Initialize a thread pool with the number of cpus of this machine </li>
     * 	<li>Use reflection to create popSize of the unNormalized fitness evaluation tasks.</li>
     * 	<li>Add these tasks into the execution pool </li>
     *  <li>execute all tasks and collect fitness values</li>
     * </ul>
     * @param popVar population variables
     * @return an double[] type of fitness values
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public double[] execute(Particle [] popVar) {
		int popSize = popVar.length;
		ExecutorService exec = Executors.newFixedThreadPool(
								Runtime.getRuntime().availableProcessors());
		ArrayList tasks = new ArrayList();
		for(int i = 0; i < popSize; i++){
			try {
				tasks.add(childType.getConstructor(Particle.class)
						 .newInstance(popVar[i])
						 );
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		ArrayList<Future> results = null;
		try {
			results = (ArrayList<Future>) exec.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.shutdown();
		
		double[] fitness = new double[popSize];
		int counter = 0;
		for(Future f: results){
			try {
				fitness[counter] = (double) f.get();
				counter++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return fitness;
	}
}
