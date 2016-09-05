package BPSOAllocationProblem;

import ProblemDefine.ProblemParameterSettings;
import algorithms.Evaluate;
import algorithms.InitPop;
import algorithms.InitVelocity;
import algorithms.UpPop;
import algorithms.UpdateGbest;
import algorithms.UpdatePbest;

public class AllocationParameterSettings extends ProblemParameterSettings{
	private double[] costMatrix;
	private double[] freqMatrix;
	private double[] latencyMatrix;

	public AllocationParameterSettings(InitPop initPop, InitVelocity initVel, UpdateGbest upGbest, UpdatePbest upPbest,
			Evaluate evaluate, UpPop upPop, double[] costMatrix, double[] freqMatrix, double[] latencyMatrix) {
		super(initPop, initVel, upGbest, upPbest, evaluate, upPop, costMatrix, freqMatrix, latencyMatrix);
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
