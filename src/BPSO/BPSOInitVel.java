package BPSO;

import algorithms.InitVelocity;

public class BPSOInitVel implements InitVelocity{

	@Override
	public void init(double[][] velocity) {
		int popSize = velocity.length;
		int maxVar = popSize * velocity[0].length;

		// TODO Auto-generated method stub
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				velocity[i][j] = 0.0;
			}
		}
	}

}
