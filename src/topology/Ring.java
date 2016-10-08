package topology;

import java.util.ArrayList;
import java.util.Arrays;

import algorithms.UpdateLbest;
import distanceMeasure.DistanceMeasure;

public class Ring implements UpdateLbest{
	private DistanceMeasure distMeasure;
	public Ring(DistanceMeasure distMeasure){
		this.distMeasure = distMeasure;
	}
	@Override
	public void update(double[][] popVar, double[] popFit, double[][] iBestVar,
						double[] iBestFit, int optimization, int generation) {
		int popSize = popVar.length;
		int maxVar = popVar[0].length;

		for(int i = 0; i < popSize; i++){
			int index;
			if(optimization == 0){
				if(i == 0) {
					iBestFit[0] = (double) lowestFit(popFit[popSize - 1], popFit[0], popFit[1]).get(1);
					index = (int) lowestFit(popFit[popSize - 1], popFit[0], popFit[1]).get(0);
					if(index == -1) index = popSize - 1;
				} else if (i == popSize - 1){
					iBestFit[popSize - 1] = (double) lowestFit(popFit[popSize - 2], popFit[popSize - 1], popFit[0]).get(1);
					index = (int) lowestFit(popFit[popSize - 2], popFit[popSize - 1], popFit[0]).get(0);
					if(index == 1) index = 0;
					else index = i + index;
				} else {
					iBestFit[i] = (double) lowestFit(popFit[i - 1], popFit[i], popFit[i + 1]).get(1);
					index = (int) lowestFit(popFit[i - 1], popFit[i], popFit[i + 1]).get(0) + i;
				}

				for(int j = 0; j < maxVar; j++){
					iBestVar[i][j] = popVar[index][j];
				}
			} else {
				if(i == 0) {
					iBestFit[0] = (double) greatestFit(popFit[popSize - 1], popFit[0], popFit[1]).get(1);
					index = (int) greatestFit(popFit[popSize - 1], popFit[0], popFit[1]).get(0);
				} else if (i == popSize - 1){
					iBestFit[popSize - 1] = (double) greatestFit(popFit[popSize - 2], popFit[popSize - 1], popFit[0]).get(1);
					index = (int) greatestFit(popFit[popSize - 2], popFit[popSize - 1], popFit[0]).get(0);
				} else {
					iBestFit[i] = (double) greatestFit(popFit[i - 1], popFit[i], popFit[i + 1]).get(1);
					index = (int) greatestFit(popFit[i - 1], popFit[i], popFit[i + 1]).get(0);
				}

				for(int j = 0; j < maxVar; j++){
					iBestVar[i][j] = popVar[index][j];
				}
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
