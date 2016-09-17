package psoFactory;

import commonOperators.CommonInitPop;
import commonOperators.CommonInitVel;
import commonOperators.CommonUpGbest;
import commonOperators.CommonUpPbest;
import commonOperators.CommonUpPop;
import commonOperators.CommonVelocityClamping;
import dataCollector.DataCollector;
import algorithms.*;

public class OriginalCPSOFactory implements PSOFactory{

	private DataCollector collector;

	public OriginalCPSOFactory(DataCollector collector){
		this.collector = collector;
	}

	@Override
	public InitPop getInitPopMethod() {
		return new CommonInitPop();
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
		return new CommonUpPop();
	}

	@Override
	public UpdateGIbest getUpGIbestMethod() {
		return new CommonUpGbest();
	}

	@Override
	public DataCollector getDataCollector() {
		return collector;
	}

	@Override
	public VelocityClamping getVelocityClamper(double clampFactor) {
		return new CommonVelocityClamping(clampFactor);
	}

}
