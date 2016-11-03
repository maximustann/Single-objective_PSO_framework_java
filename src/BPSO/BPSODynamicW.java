/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * BPSODynamicW.java - Mei Yi's method of dynamically adjust the inertia in
 * 						a BPSO.
 */

package BPSO;

import algorithms.DynamicW;

/**
 * Dynamic adjustment of inertia coefficient w.
 * 
 * @author Yi Mei - Method author
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class BPSODynamicW implements DynamicW{
	private double balance, lbound, ubound, maxGen;
	public BPSODynamicW(double balance, int maxGen, double lbound, double ubound){
		this.balance = balance;
		this.maxGen = maxGen;
		this.lbound = lbound;
		this.ubound = ubound;
	}
	@Override
	public double update(int currentGen) {
		if(balance == 0) { return lbound; }
		else if(currentGen <= balance * maxGen){
			return (lbound + currentGen * (ubound - lbound)) / (balance * maxGen);
		} else {
			return ubound;
		}
	}
}
