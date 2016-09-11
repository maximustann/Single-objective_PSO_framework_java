package psoFactory;

import commonOperators.CommonInitPop;
import commonOperators.CommonInitVel;
import commonOperators.CommonUpGbest;
import commonOperators.CommonUpPbest;
import commonOperators.CommonUpPop;
import distanceMeasure.DistanceMeasure;
import algorithms.*;

public class OriginalCPSOFactory implements PSOFactory{

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
		return new CommonUpPop();
	}

	@Override
	public UpdateIbest getUpIbestMethod(DistanceMeasure measure) {
		// TODO Auto-generated method stub
		return null;
	}

}
