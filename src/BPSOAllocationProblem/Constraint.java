package BPSOAllocationProblem;

public class Constraint {
	private int noService;

	public Constraint(int noService){
		this.noService = noService;
	}

	public double[] punish(double[][] popVar, double[] fitness){
		int noLocation = popVar[0].length / noService;
		double[][] particle = new double[noService][noLocation];


		for(int count = 0; count < popVar.length; count++){
			for(int i = 0; i < noService; i++){
				for(int j = 0; j < noLocation; j++){
					particle[i][j] = popVar[count][i * noService + j];
				}
			}
			if(!checkService(particle)){
				fitness[count] = 1.0;
			}
		}
		return fitness;
	}

	private boolean checkService(double[][] particle){
		for(int i = 0; i < particle.length; i++){
			if(rowSum(particle[i]) < 0.0001) return false;
		}
		return true;
	}
	private double rowSum(double[] row){
		double sum = 0;
		for(int i = 0; i < row.length; i++) sum += row[i];
		return sum;
	}
}
