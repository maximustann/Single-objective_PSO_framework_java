package commonRepresentation;

import algorithms.Particle;

public class IntParticle extends Particle{
	/** We just want to inherent the type. Don't even need to encapsulate. 
	 */
	public int [] individual;
	public int [][] matrixIndividual;
	public IntParticle(int size) {
		individual = new int[size];
	}
	@Override
	public int size() {
		return individual.length;
	}
	/**
	 * Print in one line
	 */
	@Override
	public void print() {
		for(int i = 0; i < size(); i++){
			System.out.print(individual[i] + " ");
		}	
	}
	
	/**
	 * Transit to matrix representation
	 */
	public void toMatrix(int row){
		int particleSize = size();
		int col = particleSize / row;
		matrixIndividual = new int[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				matrixIndividual[i][j] = individual[i * col + j];
			}
		}
	}
	
	/**
	 * Print matrix form
	 */
	public void printMatrix(){
		int rowNum = matrixIndividual.length;
		int colNum = matrixIndividual[0].length;
		for(int i = 0; i < rowNum; i++){
			for(int j = 0; j < colNum; j++){
				System.out.print(matrixIndividual[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public boolean equals(IntParticle particle) {
		int particleSize = size();
		for(int i = 0; i < particleSize; i++){
			if(individual[i] != particle.individual[i]){
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean equals(Particle particle) {
		return equals((IntParticle) particle);
	}

	@Override
	public Particle clone() {
		IntParticle copy = new IntParticle(size());
		for(int i = 0; i < size(); i++){
			copy.individual[i] = individual[i];
		}
		return copy;
	}
	
	@Override
	public void copyTo(Particle target){
		copyTo((IntParticle) target);
	}
	
	public void copyTo(IntParticle target) {
		for(int i = 0; i < size(); i++){
			target.individual[i] = individual[i];
		}
	}
}
