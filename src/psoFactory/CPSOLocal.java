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

import ProblemDefine.ParameterSettings;
import ProblemDefine.ProblemParameterSettings;
import algorithms.UpdateLbest;
import commonRepresentation.RealParticle;
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
	public CPSOLocal(
				ParameterSettings 			pars,
				ProblemParameterSettings 	proSet,
				PSOFactory 					factory
				){
		CPSOFactory 	= factory;
		this.pars 	= pars;
		this.proSet 	= proSet;
		prepare();
	}


	/**
	 * All settings are prepared here,
	 * This is the list of all settings, please read carefully
	 * <ul>
	 * <li>maxGen: 		max number of generation</li>
	 * <li>maxVar: 		max number of variables in a particle</li>
	 * <li>popSize:		population Size</li>
	 * <li>w				inertia</li>
	 * <li>balance		balance factor between exploration and exploitation</li>
	 * <li>c1			cognitive factor</li>
	 * <li>c2			collective factor</li>
	 * <li>lbound		lower bound of a variable</li>
	 * <li>ubound		upper bound of a variable</li>
	 * <li>lboundW		lower bound of inertia</li>
	 * <li>uboundW		upper bound of inertia</li>
	 * <li>clampFactor	clamp factor</li>
	 * <li>optimization maximize (1) or minimize (0)</li>
	 * <li>popFit		population fitness</li>
	 * <li>pBestVar		personal best variables</li>
	 * <li>pBestFit		personal best fitness values</li>
	 * <li>gBestVar		global best variables</li>
	 * <li>initPop		a population initialization method</li>
	 * <li>initVel		a velocity initialization method</li>
	 * <li>upGbest		a global best update method, because the common interface of global best and local best,
	 * 				we need to manually cast it.</li>
	 * <li>upPbest		a personal best update method</li>
	 * <li>upPop			a population update method, a clampFactor is needed here. Because we need to do velocity clamping
	 * 				in particle position updating.</li>
	 * <li>evaluate		evaluation method</li>
	 * <li>dynW			a dynamic inertia method</li>
	 * <li>collector	data collector</li>
	 * </ul>
	 */
	@Override
	protected void prepare(){
		maxGen 				= pars.getMaxGen();
		maxVar 				= pars.getMaxVar();
		popSize 				= pars.getPopSize();
		w 					= pars.getW();
		balance 				= pars.getBalance();
		c1 					= pars.getC1();
		c2 					= pars.getC2();
		lbound 				= pars.getLbound();
		ubound 				= pars.getUbound();
		lboundW 				= pars.getLboundW();
		uboundW 				= pars.getUboundW();
		clampFactor 			= pars.getClampFactor();
		optimization 		= pars.getOptimization();
		popFit 				= new double[popSize];
		pBestVar 			= new RealParticle[popSize];
		for(int i = 0; i < popSize; i++) {
		pBestVar[i] 					= new RealParticle(maxVar); }
		
		pBestFit 			= new double[popSize];
		lBestVar 			= new RealParticle[popSize];
		for(int i = 0; i < popSize; i++) {
		lBestVar[i] 					= new RealParticle(maxVar); }
		lBestFit 			= new double[popSize];

		initPop 				= CPSOFactory.getInitPopMethod();
		initVel 				= CPSOFactory.getInitVelMethod();
		upLbest 				= (UpdateLbest) CPSOFactory.getUpGIbestMethod();
		upPbest 				= CPSOFactory.getUpPbestMethod();
		upPop 				= CPSOFactory.getUpPopMethod(clampFactor);
		evaluate 			= proSet.getEvaluate();
		collector 			= CPSOFactory.getDataCollector();
		dynW 				= CPSOFactory.getDynamicW(balance, maxGen, lboundW, uboundW);
	}


}
