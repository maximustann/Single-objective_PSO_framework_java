/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO framework
 * Description:  PSO framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * RosenbrockParameterSettings.java an implementation of ProblemParameterSettings, although it seems
 * unnecessary. But the ProblemParameterSettings abstraction could be extended in the future. 
 */
package Rosenbrock;

import ProblemDefine.ProblemParameterSettings;
import algorithms.Evaluate;
/**
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class RosenbrockParameterSettings extends ProblemParameterSettings{

	public RosenbrockParameterSettings(Evaluate evaluate) {
		super(evaluate);
	}

}
