package psoFactory;

import commonOperators.CommonInitPop;
import commonOperators.CommonInitVel;
import commonOperators.CommonUpLocalPop;
import commonOperators.CommonUpPbest;
import commonOperators.CommonVelocityClamping;
import dataCollector.DataCollector;
import distanceMeasure.DistanceMeasure;
import topology.Ring;
import algorithms.*;

public class RingCPSOFactory implements PSOFactory{
	private DistanceMeasure measure;
	private DataCollector collector;
	public RingCPSOFactory(DistanceMeasure measure, DataCollector collector){
		this.measure = measure;
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
		return new CommonUpLocalPop();
	}

	@Override
	public UpdateGIbest getUpGIbestMethod() {
		return new Ring(measure);
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
