package psoFactory;

import commonOperators.CommonInitPop;
import commonOperators.CommonInitVel;
import commonOperators.CommonUpGbest;
import commonOperators.CommonUpLocalPop;
import commonOperators.CommonUpPbest;
import distanceMeasure.DistanceMeasure;
import topology.Ring;
import algorithms.*;

public class RingCPSOFactory implements PSOFactory{


	@Override
	public InitPop getInitPopMethod() {
		return new CommonInitPop();
	}

	@Override
	public InitVelocity getInitVelMethod() {
		return new CommonInitVel();
	}

	@Override
	public UpdateGbest getUpGbestMethod() {
		return new CommonUpGbest();
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
	public UpdateIbest getUpIbestMethod(DistanceMeasure measure) {
		// TODO Auto-generated method stub
		return new Ring(measure);
	}

}
