package psoFactory;
import algorithms.*;

public interface PSOFactory {
	public InitPop getInitPopMethod();
	public InitVelocity getInitVelMethod();
	public UpdateGbest getUpGbestMethod();
	public UpdatePbest getUpPbestMethod();
	public UpPop getUpPopMethod();
}
