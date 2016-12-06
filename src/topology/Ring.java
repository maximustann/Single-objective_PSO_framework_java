/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * Ring.java - A ring topology for local best-based PSO
 */
package topology;

import java.util.ArrayList;

import algorithms.Particle;
import algorithms.UpdateLbest;
/**
 * A fixed neighbor Ring topology
 * Ring topology is essentially a local best updating rule
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class Ring implements UpdateLbest{

	/**
	 * update local best
	 * If it is the 0 particle, then find the maximum or minimum fitness value among the last particle, current particle and the second
	 * particle
	 *
	 * If it is the last particle, then find the maximum or minimum among the first particle, current particle and the second last particle
	 *
	 * @param popVar population
	 * @param popFit fitness
	 * @param lBestVar local best variables
	 * @param lBestFit local best fitness values
	 * @param optimization maximize (1) or minimize (0)
	 * @param generation current generation
	 */
	@Override
	public void update(
				Particle[] 		popVar,
				double[] 		popFit,
				Particle[] 		lBestVar,
				double[] 		lBestFit,
				int 				optimization,
				int 				generation
				) {
		int popSize = popVar.length;

		for(int i = 0; i < popSize; i++){
			int index;
			if(optimization == 0){
				if(i == 0) {
					lBestFit[0] = (double) lowestFit(popFit[popSize - 1], popFit[i], popFit[1]).get(1);
					index = (int) lowestFit(popFit[popSize - 1], popFit[i], popFit[1]).get(0);
					if(index == -1) index = popSize - 1;
				} else if (i == popSize - 1){
					lBestFit[i] = (double) lowestFit(popFit[i - 1], popFit[i], popFit[0]).get(1);
					index = (int) lowestFit(popFit[i - 1], popFit[i], popFit[0]).get(0);
					if(index == 1) index = 0;
					else index = i + index;
				} else {
					lBestFit[i] = (double) lowestFit(popFit[i - 1], popFit[i], popFit[i + 1]).get(1);
					index = (int) lowestFit(popFit[i - 1], popFit[i], popFit[i + 1]).get(0) + i;
				}

				popVar[index].copyTo(lBestVar[i]);
			} else {
				if(i == 0) {
					lBestFit[0] = (double) greatestFit(popFit[popSize - 1], popFit[i], popFit[1]).get(1);
					index = (int) greatestFit(popFit[popSize - 1], popFit[i], popFit[1]).get(0);
				} else if (i == popSize - 1){
					lBestFit[i] = (double) greatestFit(popFit[i - 1], popFit[i], popFit[0]).get(1);
					index = (int) greatestFit(popFit[i - 1], popFit[i], popFit[0]).get(0);
				} else {
					lBestFit[i] = (double) greatestFit(popFit[i - 1], popFit[i], popFit[i + 1]).get(1);
					index = (int) greatestFit(popFit[i - 1], popFit[i], popFit[i + 1]).get(0);
				}

				popVar[index].copyTo(lBestVar[i]);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList lowestFit(double left, double middle, double right){
		ArrayList list = new ArrayList();
		if(left < middle) {
			if(left < right){
				list.add(-1);
				list.add(left);
			} else{
				list.add(1);
				list.add(right);
			}
		} else {
			if(middle < right){
				list.add(0);
				list.add(middle);
			} else {
				list.add(1);
				list.add(middle);
			}
		}
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList greatestFit(double left, double middle, double right){
		ArrayList list = new ArrayList();
		if(left > middle) {
			if(left > right){
				list.add(-1);
				list.add(left);
			} else{
				list.add(1);
				list.add(right);
			}
		} else {
			if(middle > right){
				list.add(0);
				list.add(middle);
			} else {
				list.add(1);
				list.add(middle);
			}
		}
		return list;
	}
}
