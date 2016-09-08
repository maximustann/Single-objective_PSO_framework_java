package ProblemDefine;
import algorithms.*;

public abstract class ProblemParameterSettings {
	private Evaluate evaluate;

	public ProblemParameterSettings(Evaluate evaluate, double[] costMatrix,
									double[] freqMatrix, double[] latencyMatrix){
		this.evaluate = evaluate;
	}



	public Evaluate getEvaluate() {
		return evaluate;
	}

}
