/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * PSOFactory.java - An interface of pso factory
 */
package psoFactory;
import algorithms.*;
import dataCollector.DataCollector;

// PSO Factory provides an interface which allows the user to specifically define their methods.
/**
 * PSOFactory
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public interface PSOFactory {
	public InitPop getInitPopMethod();
	public InitVelocity getInitVelMethod();
	public UpdateGLbest getUpGIbestMethod();
	public UpdatePbest getUpPbestMethod();
	public UpPop getUpPopMethod(double clampFactor);
	public DataCollector getDataCollector();
	public VelocityClamping getVelocityClamper(double clampFactor);
	public DynamicW getDynamicW(double balance, int maxGen, double lboundW, double uboundW);
}
