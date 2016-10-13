/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * CPSO.java - A implementation of continuous PSO
 */

package psoFactory;

import ProblemDefine.ParameterSettings;
import ProblemDefine.ProblemParameterSettings;
import algorithms.UpdateGbest;
import psoProcedure.GlobalPSO;
/**
 * A global CPSO
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class CPSO extends GlobalPSO{
	PSOFactory CPSOFactory;
	ParameterSettings pars;
	ProblemParameterSettings proSet;


	/**
	 * Constructor
	 * @param pars Parameter settings
	 * @param proSet Problem settings
	 * @param factory factory is used to assemble parts
	 */
	public CPSO(ParameterSettings pars, ProblemParameterSettings proSet, PSOFactory factory){
		CPSOFactory = factory;
		this.pars = pars;
		this.proSet = proSet;
		prepare();
	}

	/**
	 * All settings are prepared here
	 * This is the list of all settings, please read carefully
	 * maxGen: 		max number of generation
	 * maxVar: 		max number of variables in a particle
	 * popSize:		population Size
	 * w			inertia
	 * c1			cognitive factor
	 * c2			collective factor
	 * lbound		lower bound of a variable
	 * ubound		upper bond of a variable
	 * clampFactor	clamp factor
	 * optimization maximize (1) or minimize (0)
	 * popFit		population fitness
	 * pBestVar		personal best variables
	 * pBestFit		personal best fitness values
	 * gBestVar		global best variables
	 * initPop		a population initialization method
	 * initVel		a velocity initialization method
	 * upGbest		a global best update method, because the common interface of global best and local best,
	 * 				we need to manually cast it.
	 * upPbest		a personal best update method
	 * upPop		a population update method, a clampFactor is needed here. Because we need to do velocity clamping
	 * 				in particle position updating.
	 * evaluate		evaluation method
	 * collector	data collector
	 */
	protected void prepare(){
		maxGen = pars.getMaxGen();
		maxVar = pars.getMaxVar();
		popSize = pars.getPopSize();
		w = pars.getW();
		c1 = pars.getC1();
		c2 = pars.getC2();
		lbound = pars.getLbound();
		ubound = pars.getUbound();
		clampFactor = pars.getClampFactor();
		optimization = pars.getOptimization();
		popFit = new double[popSize];
		pBestVar = new double[popSize][maxVar];
		pBestFit = new double[popSize];
		gBestVar = new double[maxVar];

		initPop = CPSOFactory.getInitPopMethod();
		initVel = CPSOFactory.getInitVelMethod();
		upGbest = (UpdateGbest) CPSOFactory.getUpGIbestMethod();
		upPbest = CPSOFactory.getUpPbestMethod();
		upPop = CPSOFactory.getUpPopMethod(clampFactor);
		evaluate = proSet.getEvaluate();
		collector = CPSOFactory.getDataCollector();
	}

}
