package psoFactory;

import java.util.Arrays;

import ProblemDefine.ParameterSettings;
import ProblemDefine.ProblemParameterSettings;
import algorithms.UpdateIbest;
import psoProcedure.LocalPSO;

public class CPSOLocal extends LocalPSO{
	PSOFactory CPSOFactory;
	ParameterSettings pars;
	ProblemParameterSettings proSet;

	public CPSOLocal(ParameterSettings pars, ProblemParameterSettings proSet, PSOFactory factory){
		CPSOFactory = factory;
		this.pars = pars;
		this.proSet = proSet;
		prepare();
	}

	protected void prepare(){
		initPop = CPSOFactory.getInitPopMethod();
		initVel = CPSOFactory.getInitVelMethod();
		upIbest = (UpdateIbest) CPSOFactory.getUpGIbestMethod();
		upPbest = CPSOFactory.getUpPbestMethod();
		upPop = CPSOFactory.getUpPopMethod();
		evaluate = proSet.getEvaluate();

		maxGen = pars.getMaxGen();
		maxVar = pars.getMaxVar();
		popSize = pars.getPopSize();
		w = pars.getW();
		c1 = pars.getC1();
		c2 = pars.getC2();
		lbound = pars.getLbound();
		ubound = pars.getUbound();
		optimization = pars.getOptimization();
		popFit = new double[popSize];
		pBestVar = new double[popSize][maxVar];
		pBestFit = new double[popSize];
		iBestVar = new double[popSize][maxVar];
		iBestFit = new double[popSize];
		Arrays.fill(pBestFit, 1.0);
		Arrays.fill(iBestFit, 1.0);
	}
}
