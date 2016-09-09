package commonOperators;

import algorithms.InitVelocity;

public class CommonInitVel implements InitVelocity{

	@Override
	public double[][] init(int popSize, int maxVar) {
		double[][] velocity = new double[popSize][maxVar];
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				velocity[i][j] = 0.0;
			}
		}
		return velocity;
	}

}
