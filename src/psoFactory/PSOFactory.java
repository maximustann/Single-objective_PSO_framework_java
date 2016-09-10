package psoFactory;
import algorithms.*;

// PSO Factory provide an interface which allow the implementors to specifically define their methods.
public interface PSOFactory {
	public InitPop getInitPopMethod();
	public InitVelocity getInitVelMethod();
	public UpdateGbest getUpGbestMethod();
	public UpdatePbest getUpPbestMethod();
	public UpPop getUpPopMethod();
}