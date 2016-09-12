package topology;

import algorithms.UpdateIbest;
import distanceMeasure.DistanceMeasure;

public class Ring implements UpdateIbest{
	private DistanceMeasure distMeasure;
	public Ring(DistanceMeasure distMeasure){
		this.distMeasure = distMeasure;
	}
	@Override
	public void update(double[][] popVar, double[] popFit, double[][] iBestVar, double[] iBestFit, int optimization,
			int generation) {
		int popSize = popVar.length;
		int maxVar = popVar[0].length;
		int[][] nearestIndex = searchForNeighbours(popVar, popSize);
		for(int i = 0; i < popSize; i++){
			int bestIndex = 0;
			if((popFit[nearestIndex[i][0]] < popFit[nearestIndex[i][1]] && optimization == 0) ||
					(popFit[nearestIndex[i][0]] > popFit[nearestIndex[i][1]] && optimization == 1)) {

				iBestFit[i] = popFit[nearestIndex[i][0]];
				bestIndex = nearestIndex[i][0];
			} else{
				iBestFit[i] = popFit[nearestIndex[i][1]];
				bestIndex = nearestIndex[i][1];
			}
			for(int j = 0; j < maxVar; j++){
				iBestVar[i][j] = popVar[bestIndex][j];
			}
		}
	}
	private int[][] searchForNeighbours(double[][] popVar, int popSize){
		int[][] bestIndex = new int[popVar.length][2];

		for(int i = 0; i < popSize; i++){
			boolean goOn = false;
			for(int j = 0; j < i; j++){
				if(bestIndex[j][0] == i || bestIndex[j][1] == i) {
					if(bestIndex[i][0] == 0) bestIndex[i][0] = j;
					else bestIndex[i][1] = j;
				}
				if(bestIndex[i][1] != 0) {
					goOn = true;
					break;
				}
			}
			if(goOn) continue;
			if(popSize - i - 1 == 0){
				bestIndex[i][1]= popSize - 1;
				break;
			}
			double[] distance = new double[popSize - i - 1];
			distance[0] = 0;
			for(int j = i + 1, k = 1; j < popSize - i - 1; j++, k++){
				distance[k] = distMeasure.calcDist(popVar[i], popVar[j]);
			}
			bestIndex[i] = head2Bests(distance, i);
		}

		return bestIndex;
	}

	private int[] head2Bests(double[] distance, int currentIndex){
		double first, second, temp;
		int[] head2 = new int[2];
		int firstIndex = 0;
		int secondIndex = 1;
		first = distance[0];
		second = distance[1];
		for(int i = 2; i < distance.length; i++){
			if(first > second){
				temp = first;
				first = second;
				second = temp;
				secondIndex = firstIndex;
				firstIndex = i - 1;
			}
			if(second > distance[i]){
				second = distance[i];
			}
		}
		head2[0] = firstIndex + currentIndex + 1;
		head2[1] = secondIndex + currentIndex + 1;
		return head2;
	}


}
