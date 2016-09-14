package psoFactory;

import BPSO.BPSOInitPop;
import BPSO.BPSOupPop;
import commonOperators.CommonInitVel;
import commonOperators.CommonUpGbest;
import commonOperators.CommonUpPbest;
import dataCollector.DataCollector;
import algorithms.*;

// In this case, only the initialization of population and update population are different from common version of PSO.
public class OriginalBPSOFactory implements PSOFactory{
	private DataCollector collector;


	public OriginalBPSOFactory(DataCollector collector){
		this.collector = collector;
	}

	@Override
	public InitPop getInitPopMethod() {
		return new BPSOInitPop();
	}

	@Override
	public InitVelocity getInitVelMethod() {
		return new CommonInitVel();
	}



	@Override
	public UpdatePbest getUpPbestMethod() {
		return new CommonUpPbest();
	}

	@Override
	public UpPop getUpPopMethod() {
		return new BPSOupPop();
	}

	@Override
	public UpdateGIbest getUpGIbestMethod() {
		// TODO Auto-generated method stub
		return new CommonUpGbest();
	}

	@Override
	public DataCollector getDataCollector() {
		return collector;
	}

}
