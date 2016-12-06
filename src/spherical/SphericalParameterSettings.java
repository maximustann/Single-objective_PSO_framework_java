/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO framework
 * Description:  PSO framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * SphericalParameterSettings.java an implementation of ProblemParameterSettings, although it seems
 * unnecessary. But the ProblemParameterSettings abstraction could be extended in the future. 
 */
package spherical;

import ProblemDefine.ProblemParameterSettings;
import algorithms.Evaluate;
/**
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class SphericalParameterSettings extends ProblemParameterSettings{

	public SphericalParameterSettings(Evaluate evaluate) {
		super(evaluate);
	}

}
