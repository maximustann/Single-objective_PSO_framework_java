package BPSOAllocationProblem;
import algorithms.*;

public class BPSOHaiTimeFitness extends FitnessFunc {
	private double[] latency;
	private double[] frequency;
	private int noService;
	private int noLocation;
	private int noUser;
	private Constraint con;

	public BPSOHaiTimeFitness(Normalize normalize, Constraint con, double[] latency, double[] frequency,
								int noService, int noLocation){
		super(normalize);
		this.con = con;
		this.latency = latency;
		this.frequency = frequency;
		this.noService = noService;
		this.noUser = latency.length / noLocation;
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
		fitness = con.punish(popVar, fitness);
		return fitness;
	}

	private double fitnessIndividual(double[] particle, int noService, int noLocation){
		double fitness = 0.0;
		double[][] particleMatrix = new double[noService][noLocation];
		double[][] latencyMatrix = new double[noUser][noLocation];
		double[][] temp = new double[noUser][noLocation];
		double[][] responseMatrix = new double[noUser][noService];
		double[] responseComp = new double[noService];

		for(int i = 0; i < noService; i++){
			for(int j = 0; j < noLocation; j++){
				particleMatrix[i][j] = particle[i * noService + j];
			}
		}

		for(int i = 0; i < noUser; i++){
			for(int j = 0; j < noLocation; j++){
				latencyMatrix[i][j] = latency[i * noUser + j];
			}
		}

		for(int count = 0; count < noService; count++){
			for(int i = 0; i < noUser; i++){
				for(int j = 0; j < noLocation; j++) temp[i][j] = particleMatrix[count][j] * latencyMatrix[i][j];
				responseMatrix[i][count] = min(temp[i]);
			}
		}

		for(int i = 0; i < noService; i++){
			for(int j = 0; j < noUser; j++) responseComp[i] += responseMatrix[j][i];
		}


		for(int i = 0; i < noService; i++){
			fitness += responseComp[i] * frequency[i];
		}
		return fitness;
	}

	private double min(double[] temp){
		double minimum = temp[0];
		for(int i = 0; i < temp.length; i++){
			if(minimum > temp[i]) minimum = temp[i];
		}
		return minimum;
	}



}
