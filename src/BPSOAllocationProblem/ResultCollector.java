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

import algorithms.Particle;
import dataCollector.DataCollector;
/**
 * 
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class ResultCollector extends DataCollector {
	private long start, end;

	/**
	 * add Double fitness value
	 */
	@Override
	public void collect(Object data) {
		resultData.add((Double) data);
	}

	/**
	 * @return resultData result data
	 */
	public ArrayList<Double> getResult(){
		return resultData;
	}
	
	/**
	 * get the last fitness value of many runs
	 */
	public ArrayList<Double> getLastResult(int runs, int maxGen){
		ArrayList<Double> lastResults = new ArrayList<Double>();
		for(int i = 1; i <= runs; i++){
			lastResults.add(resultData.get(maxGen * i - 1));
		}
		return lastResults;
	}
	
	/**
	 * start recording
	 */
	@Override
	public void collectTime(int gen){
		if(gen == 0) start = System.nanoTime();
		else { 
			end = System.nanoTime();
			timeData.add(new Double(Math.floor((end - start) / 10000000.0)) / 100.0);
		}
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
	
	public void mean(int runs){
		int size = resultData.size();
		int gen = size / runs;
		double best = 0;
		for(int i = 1; i <= runs; i++) {
			best += resultData.get(i * gen - 1);
		}
		System.out.println(best / runs);
	}

	@Override
	public void collectParticle(Particle[] particle) {
		// TODO Auto-generated method stub
		
	}

}
