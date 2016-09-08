package psoFactory;
import ProblemDefine.ParameterSettings;
import ProblemDefine.ProblemParameterSettings;
import algorithms.*;

public class OriginalBPSO extends PSO{
	PSOFactory BPSOFactory;
	ParameterSettings pars;
	ProblemParameterSettings proSet;

	public OriginalBPSO(ParameterSettings pars, ProblemParameterSettings proSet){
		BPSOFactory = new OriginalBPSOFactory();
		this.pars = pars;
		this.proSet = proSet;
		prepare();
	}

	protected void prepare(){
		initPop = BPSOFactory.getInitPopMethod();
		initVel = BPSOFactory.getInitVelMethod();
		upGbest = BPSOFactory.getBPSOupGbestMethod();
		upPbest = BPSOFactory.getBPSOupPbestMethod();
		upPop = BPSOFactory.getBPSOupPopMethod();
		evaluate = proSet.getEvaluate();

		maxGen = pars.getMaxGen();
		maxVar = pars.getMaxVar();
		popSize = pars.getPopSize();
		w = pars.getW();
		c1 = pars.getC1();
		c2 = pars.getC2();
//		lbound = pars.getLbound();
//		ubound = pars.getUbound();
		optimization = pars.getOptimization();
		popFit = new double[popSize];
		pBestVar = new double[popSize][maxVar];
		pBestFit = new double[popSize];
		gBestVar = new double[maxVar];

	}
}
