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

package bpso;

import algorithms.DynamicW;

/**
 * Dynamic adjustment of inertia coefficient w.
 * @see <a href="http://ieeexplore.ieee.org/stamp/stamp.jsp?arnumber=7350141">Adaptive inertia</a>
 * @author Yi Mei - Method author
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class BPSODynamicW implements DynamicW{
	private double balance, lboundW, uboundW, maxGen;
	/**
	 * 
	 * @param balance a parameter balance exploration and exploitation
	 * @param maxGen 	maximum generations
	 * @param lboundW 	lower boundary of inertia
	 * @param uboundW	upper boundary of inertia
	 */
	public BPSODynamicW(double balance, int maxGen, double lboundW, double uboundW){
		this.balance = balance;
		this.maxGen = maxGen;
		this.lboundW = lboundW;
		this.uboundW = uboundW;
	}
	@Override
	public double update(int currentGen) {
		if(balance == 0) { return lboundW; }
		else if(currentGen <= balance * maxGen){
			return (lboundW + currentGen * (uboundW - lboundW)) / (balance * maxGen);
		} else {
			return uboundW;
		}
	}
}
