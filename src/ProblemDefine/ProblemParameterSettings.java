package ProblemDefine;
import algorithms.*;

public class ProblemParameterSettings {
	private Evaluate evaluate;
	private InitPop initPop;
	private InitVelocity initVel;
	private UpdateGbest upGbest;
	private UpdatePbest upPbest;
	private UpPop upPop;
	private double Tmax, Tmin;
	private double Cmax, Cmin;
	private int noService;
	private double[] costMatrix;
	private double[] freqMatrix;
	private double[] latencyMatrix;


	public ProblemParameterSettings(InitPop initPop, InitVelocity initVel,
									UpdateGbest upGbest, UpdatePbest upPbest, Evaluate evaluate, UpPop upPop,
									double Tmax, double Tmin, double Cmax, double Cmin, int noService,
									double[] costMatrix, double[] freqMatrix, double[] latencyMatrix){
		this.initPop = initPop;
		this.initVel = initVel;
		this.evaluate = evaluate;
		this.upGbest = upGbest;
		this.upPbest = upPbest;
		this.upPop = upPop;
		
		this.Tmax = Tmax;
		this.Tmin = Tmin;
		this.Cmax = Cmax;
		this.Cmin = Cmin;
		this.noService = noService;
		
		this.costMatrix = costMatrix;
		this.freqMatrix = freqMatrix;
		this.latencyMatrix = latencyMatrix;
	}

	public int getNoService() {
		return noService;
	}
	public double getTmax() {
		return Tmax;
	}

	public double getTmin() {
		return Tmin;
	}

	public double getCmax() {
		return Cmax;
	}

	public double getCmin() {
		return Cmin;
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

	public Evaluate getEvaluate() {
		return evaluate;
	}

	public InitPop getInitPop() {
		return initPop;
	}

	public InitVelocity getInitVel() {
		return initVel;
	}

	public UpdateGbest getUpGbest() {
		return upGbest;
	}

	public UpdatePbest getUpPbest() {
		return upPbest;
	}

	public UpPop getUpPop() {
		return upPop;
	}

}
