/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * IntParticle.java - a discrete representation of particle.
 */
package commonRepresentation;

import algorithms.Particle;

public class IntParticle extends Particle{
	public int [] 		individual;
	public int [][] 		matrixIndividual;
	
	/**
	 * 
	 * @param size the size of the particle
	 */
	public IntParticle(int size) {
		individual = new int[size];
	}
	@Override
	/**
	 * return the size of the particle
	 */
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
		System.out.println();
	}
	
	/**
	 * Transit to matrix representation
	 */
	public void toMatrix(int row){
		int particleSize 	= size();
		int col 				= particleSize / row;
		matrixIndividual 	= new int[row][col];
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
	
	/**
	 * compare the current particle with the target
	 * 
	 * @param target the target particle
	 * @return true if they are equal, else false
	 */
	public boolean equals(IntParticle target) {
		int particleSize = size();
		for(int i = 0; i < particleSize; i++){
			if(individual[i] != target.individual[i]){
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
	/**
	 * clone an exact copy of particle
	 */
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
	
	/**
	 * copy the current particle to the target
	 * @param target the destination
	 */
	public void copyTo(IntParticle target) {
		for(int i = 0; i < size(); i++){
			target.individual[i] = individual[i];
		}
	}
// End
}
