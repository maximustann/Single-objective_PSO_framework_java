package ProblemDefine;
import algorithms.*;

public abstract class ProblemParameterSettings {
	private Evaluate evaluate;

	public ProblemParameterSettings(Evaluate evaluate){
		this.evaluate = evaluate;
	}



	public Evaluate getEvaluate() {
		return evaluate;
	}

}
