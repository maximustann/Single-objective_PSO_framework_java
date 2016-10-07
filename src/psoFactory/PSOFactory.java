package psoFactory;
import algorithms.*;
import dataCollector.DataCollector;

// PSO Factory provide an interface which allow the implementors to specifically define their methods.
public interface PSOFactory {
	public InitPop getInitPopMethod();
	public InitVelocity getInitVelMethod();
	public UpdateGLbest getUpGIbestMethod();
	public UpdatePbest getUpPbestMethod();
	public UpPop getUpPopMethod(double clampFactor);
	public DataCollector getDataCollector();
	public VelocityClamping getVelocityClamper(double clampFactor);
}
