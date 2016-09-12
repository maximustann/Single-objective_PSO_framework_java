package psoFactory;

import commonOperators.CommonInitPop;
import commonOperators.CommonInitVel;
import commonOperators.CommonUpLocalPop;
import commonOperators.CommonUpPbest;
import distanceMeasure.DistanceMeasure;
import topology.Ring;
import algorithms.*;

public class RingCPSOFactory implements PSOFactory{
	private DistanceMeasure measure;
	public RingCPSOFactory(DistanceMeasure measure){
		this.measure = measure;
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

}
