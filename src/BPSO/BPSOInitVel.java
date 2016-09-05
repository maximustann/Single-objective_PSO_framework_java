package BPSO;

import algorithms.InitVelocity;

public class BPSOInitVel implements InitVelocity{

	@Override
	public double[][] init(int popSize, int maxVar) {
		double[][] velocity = new double[popSize][maxVar];
		// TODO Auto-generated method stub
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				velocity[i][j] = 0.0;
			}
		}
		return velocity;
	}

}
