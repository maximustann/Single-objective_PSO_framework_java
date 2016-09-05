package BPSOAllocationProblem;
import algorithms.*;

public class BPSOHaiTimeFitness extends FitnessFunc {
	private double[] latencyMatrix;
	private int noService;
	private int noLocation;
	private Constraint con;

	public BPSOHaiTimeFitness(Normalize normalize, Constraint con, double[] latencyMatrix, int noService){
		super(normalize);
		this.con = con;
		this.latencyMatrix = latencyMatrix;
		this.noService = noService;
	}

	@Override
	public double[] unNormalizedFit(double[][] popVar) {
		int popSize = popVar.length;
		noLocation = popVar[0].length / noService;
		double[] fitness = new double[popSize];

		for(int i = 0; i < popSize; i++){
			fitness[i] = fitnessIndividual(popVar[i], noService, noLocation);
		}
		return fitness;
	}

	public double[] normalizedFit(double[][] popVar){
		double[] fitness = unNormalizedFit(popVar);
		normalize.doNorm(fitness);

//		for(int count = 0; count < popVar.length; count++){
//			for(int i = 0; i < popVar[0].length; i++) System.out.print(popVar[count][i] + " ");
//			System.out.println();
//		}

		fitness = con.punish(popVar, fitness);
		return fitness;
	}

	private double fitnessIndividual(double[] particle, int noService, int noLocation){
		double fitness = 0.0;
		double[][] temp = new double[noService][noLocation];
		double[] response = new double[noService];
		double[] sumLatency = new double[noLocation];



		for(int i = 0; i < noLocation; i++){
			for(int j = 0; j < noService; j++){
				sumLatency[i] += latencyMatrix[j * noService + i];
			}
		}

		for(int i = 0; i < noService; i++){
			for(int j = 0; j < noLocation; j++){
				temp[i][j] = particle[i * noService + j] * sumLatency[j];
//				System.out.print(temp[i][j] + " ");
			}
//			System.out.println();
		}

		for(int i = 0; i < noService; i++){
			response[i] = min(temp[i]);
//			System.out.println(response[i]);
		}
		for(int i = 0; i < noService; i++){
			fitness += response[i];
		}
		return fitness;
	}

	// Looking for the minimum latency that not equals to  0
	private double min(double[] tempMatrix){
		double minimum = tempMatrix[0];
		for(int i = 1; i < tempMatrix.length; i++){
			if((minimum > tempMatrix[i] && tempMatrix[i] != 0) || (minimum == 0 && tempMatrix[i] != 0))
				minimum = tempMatrix[i];
		}
		return minimum;
	}



}
