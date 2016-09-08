package psoFactory;
import algorithms.*;

public interface PSOFactory {
	public InitPop getInitPopMethod();
	public InitVelocity getInitVelMethod();
	public UpdateGbest getBPSOupGbestMethod();
	public UpdatePbest getBPSOupPbestMethod();
	public UpPop getBPSOupPopMethod();
}
