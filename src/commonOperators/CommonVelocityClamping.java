package commonOperators;

import algorithms.VelocityClamping;

public class CommonVelocityClamping implements VelocityClamping{
	private double vMax;
	private double vMin;
	private double clampFactor;

	public CommonVelocityClamping(double clampFactor){
		this.clampFactor = clampFactor;
	}
	@Override
	public void clamping(double[][] velocity, double lbound, double ubound) {
		vMax = clampFactor * (ubound - lbound);
		vMin = clampFactor * (lbound - ubound);
		int popSize = velocity.length;
		int maxVar = velocity[0].length;
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				if(velocity[i][j] > vMax){
					velocity[i][j] = vMax;
				}
				if(velocity[i][j] < vMin){
					velocity[i][j] = vMin;
				}
			}
		}
	}

}
