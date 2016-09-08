package psoFactory;

import BPSO.BPSOInitPop;
import BPSO.BPSOInitVel;
import BPSO.BPSOupGbest;
import BPSO.BPSOupPbest;
import BPSO.BPSOupPop;
import algorithms.InitPop;
import algorithms.InitVelocity;
import algorithms.UpPop;
import algorithms.UpdateGbest;
import algorithms.*;

public class OriginalBPSOFactory implements PSOFactory{

	@Override
	public InitPop getInitPopMethod() {
		return new BPSOInitPop();
	}

	@Override
	public InitVelocity getInitVelMethod() {
		return new BPSOInitVel();
	}

	@Override
	public UpdateGbest getBPSOupGbestMethod() {
		return new BPSOupGbest();
	}

	@Override
	public UpdatePbest getBPSOupPbestMethod() {
		return new BPSOupPbest();
	}

	@Override
	public UpPop getBPSOupPopMethod() {
		return new BPSOupPop();
	}

}
