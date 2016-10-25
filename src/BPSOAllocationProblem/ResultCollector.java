/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * ResultCollector.java - collect the results for Hai's paper
 */
package BPSOAllocationProblem;

import java.util.ArrayList;

import dataCollector.DataCollector;
/**
 * 
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class ResultCollector implements DataCollector {
	private ArrayList<Double> resultData;

	public ResultCollector(){
		resultData = new ArrayList<Double>();
	}
	
	/**
	 * add Double fitness value
	 */
	public void collect(Object data) {
		resultData.add((Double) data);
	}

	public ArrayList<Double> getResult(){
		return resultData;
	}

	/**
	 * print all fitness results
	 */
	public void printResult(){
		for(int i = 0; i < resultData.size(); i++){
			System.out.println(resultData.get(i));
		}
		System.out.println();
	}
	
	/**
	 * collect populations, have not finished
	 */
	public void collectParticle(double[][] particle) {
		// TODO Auto-generated method stub
		
	}

}
