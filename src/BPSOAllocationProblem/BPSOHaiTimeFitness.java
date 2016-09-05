package BPSOAllocationProblem;
import algorithms.*;

public class BPSOHaiTimeFitness extends FitnessFunc {
	private double[] latencyMatrix;
	private int noService;
	private int noLocation;

	public BPSOHaiTimeFitness(Normalize normalize, double[] latencyMatrix, int noService){
		super(normalize);
		this.latencyMatrix = latencyMatrix;
		this.noService = noService;
	}

	@Override
	public double[] unNormalizedFit(double[][] popVar) {
		int popSize = popVar.length;
		noLocation = popSize / noService;
		double[] fitness = new double[popSize];
		for(int i = 0; i < popSize; i++){
			fitness[i] = fitnessIndividual(popVar[i], noService, noLocation);
		}
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
			}
		}

		for(int i = 0; i < noService; i++){
			response[i] = min(temp[i]);
		}
		for(int i = 0; i < noService; i++){
			fitness += response[i];
		}
		fitness = fitness * serviceEstablishCon(response);
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

	// Penalty function for response matrix
	// If there is a service without being deployed, return a big value
	private double serviceEstablishCon(double[] responseMatrix){
		for(int i = 0; i < responseMatrix.length; i++){
			if(responseMatrix[i] < 0.0001) return 10000.0;
		}
		return 1.0;
	}

}
