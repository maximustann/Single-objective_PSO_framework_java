/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * ProblemParameterSettings.java - An abstract class of problem related parameters
 */
package ProblemDefine;
import algorithms.*;
/**
 * Problem related Parameter settings
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public abstract class ProblemParameterSettings {
	private Evaluate evaluate;

	/**
	 * Constructor
	 * @param evaluate the evaluation method is needed
	 */
	public ProblemParameterSettings(Evaluate evaluate){
		this.evaluate = evaluate;
	}

	/**
	 * @return the evaluation method
	 */
	public Evaluate getEvaluate() {
		return evaluate;
	}

}
