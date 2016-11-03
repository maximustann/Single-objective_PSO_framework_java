package commonOperators;

import algorithms.DynamicW;

public class CommonDynamicW implements DynamicW {
	private double balance, lbound, ubound, maxGen;
	public CommonDynamicW(double balance, int maxGen, double lbound, double ubound){
		this.balance = balance;
		this.maxGen = maxGen;
		this.lbound = lbound;
		this.ubound = ubound;
	}
	@Override
	public double update(int currentGen) {
		if(balance == 0) { return lbound; }
		else if(currentGen <= balance * maxGen){
			return (lbound - currentGen * (ubound - lbound)) / (balance * maxGen);
		} else {
			return ubound;
		}
	}
}
