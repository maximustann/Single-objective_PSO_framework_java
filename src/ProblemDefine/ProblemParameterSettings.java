package ProblemDefine;
import algorithms.*;

public abstract class ProblemParameterSettings {
	private Evaluate evaluate;
	private InitPop initPop;
	private InitVelocity initVel;
	private UpdateGbest upGbest;
	private UpdatePbest upPbest;
	private UpPop upPop;


	public ProblemParameterSettings(InitPop initPop, InitVelocity initVel,
									UpdateGbest upGbest, UpdatePbest upPbest, Evaluate evaluate, UpPop upPop,
									double[] costMatrix, double[] freqMatrix, double[] latencyMatrix){
		this.initPop = initPop;
		this.initVel = initVel;
		this.evaluate = evaluate;
		this.upGbest = upGbest;
		this.upPbest = upPbest;
		this.upPop = upPop;
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
