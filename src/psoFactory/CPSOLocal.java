/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * CPSOLocal.java - A implementation of local continuous PSO
 */
package psoFactory;

import java.util.Arrays;

import ProblemDefine.ParameterSettings;
import ProblemDefine.ProblemParameterSettings;
import algorithms.UpdateLbest;
import psoProcedure.LocalPSO;

public class CPSOLocal extends LocalPSO{
	PSOFactory CPSOFactory;
	ParameterSettings pars;
	ProblemParameterSettings proSet;

	/**
	 * Constructor
	 * @param pars Parameter settings
	 * @param proSet Problem settings
	 * @param factory factory is used to assemble parts
	 */
	public CPSOLocal(ParameterSettings pars, ProblemParameterSettings proSet, PSOFactory factory){
		CPSOFactory = factory;
		this.pars = pars;
		this.proSet = proSet;
		prepare();
	}

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
		lBestVar = new double[popSize][maxVar];
		lBestFit = new double[popSize];

		initPop = CPSOFactory.getInitPopMethod();
		initVel = CPSOFactory.getInitVelMethod();
		upLbest = (UpdateLbest) CPSOFactory.getUpGIbestMethod();
		upPbest = CPSOFactory.getUpPbestMethod();
		upPop = CPSOFactory.getUpPopMethod(clampFactor);
		evaluate = proSet.getEvaluate();
		collector = CPSOFactory.getDataCollector();


		Arrays.fill(pBestFit, 1.0);
		Arrays.fill(lBestFit, 1.0);
	}

}
