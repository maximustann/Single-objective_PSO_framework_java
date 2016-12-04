package commonRepresentation;

import algorithms.Particle;

public class RealParticle extends Particle{
	/** We just want to inherent the type. Don't even need to encapsulate. 
	 */
	public double[] individual;
	public double [][] matrixIndividual;
	public RealParticle(int size) {
		individual = new double[size];
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
		matrixIndividual = new double[row][col];
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
	
	
	public boolean equals(RealParticle particle) {
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
		return equals((RealParticle) particle);
	}

	@Override
	public Particle clone() {
		RealParticle copy = new RealParticle(size());
		for(int i = 0; i < size(); i++){
			copy.individual[i] = individual[i];
		}
		return copy;
	}
	
	@Override
	public void copyTo(Particle target){
		copyTo((RealParticle) target);
	}
	
	public void copyTo(RealParticle target) {
		for(int i = 0; i < size(); i++){
			target.individual[i] = individual[i];
		}
	}
	
	@Override
	public Particle getInstance(int size) {
		individual = new double[size];
		return this;
	}
}
