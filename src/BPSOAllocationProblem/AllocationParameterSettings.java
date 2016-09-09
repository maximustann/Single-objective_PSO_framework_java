package BPSOAllocationProblem;

import ProblemDefine.ProblemParameterSettings;
import algorithms.Evaluate;

public class AllocationParameterSettings extends ProblemParameterSettings{
	private double[] costMatrix;
	private double[] freqMatrix;
	private double[] latencyMatrix;

	public AllocationParameterSettings(	Evaluate evaluate, double[] costMatrix,
								double[] freqMatrix, double[] latencyMatrix) {
		super(evaluate);
		this.costMatrix = costMatrix;
		this.freqMatrix = freqMatrix;
		this.latencyMatrix = latencyMatrix;
	}

	public double[] getCostMatrix() {
		return costMatrix;
	}

	public double[] getFreqMatrix() {
		return freqMatrix;
	}

	public double[] getLatencyMatrix() {
		return latencyMatrix;
	}

}
