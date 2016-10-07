package psoFactory;
import java.util.Arrays;

import ProblemDefine.ParameterSettings;
import ProblemDefine.ProblemParameterSettings;
import algorithms.UpdateGbest;
import psoProcedure.GlobalPSO;

public class BPSO extends GlobalPSO{
	PSOFactory BPSOFactory;
	ParameterSettings pars;
	ProblemParameterSettings proSet;
	public BPSO(ParameterSettings pars, ProblemParameterSettings proSet, PSOFactory factory){
		BPSOFactory = factory;
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
		gBestVar = new double[maxVar];
		
		initPop = BPSOFactory.getInitPopMethod();
		initVel = BPSOFactory.getInitVelMethod();
		upGbest = (UpdateGbest) BPSOFactory.getUpGIbestMethod();
		upPbest = BPSOFactory.getUpPbestMethod();
		upPop = BPSOFactory.getUpPopMethod(clampFactor);
		evaluate = proSet.getEvaluate();
		collector = BPSOFactory.getDataCollector();
		
		
		gBestFit = 1;
		Arrays.fill(pBestFit, 1.0);
	}

}
