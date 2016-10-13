/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * OriginalCPSOFactory.java - A factory to assemble different parts
 */
package psoFactory;

import commonOperators.CommonInitPop;
import commonOperators.CommonInitVel;
import commonOperators.CommonUpGbest;
import commonOperators.CommonUpPbest;
import commonOperators.CommonUpGlobalPop;
import commonOperators.CommonVelocityClamping;
import dataCollector.DataCollector;
import algorithms.*;
/**
 * OriginalCPSOFactory
 *
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class OriginalCPSOFactory implements PSOFactory{

	private DataCollector collector;
	/**
	 * Constructor
	 * @param collector is the data collector
	 */
	public OriginalCPSOFactory(DataCollector collector){
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
	public UpPop getUpPopMethod(double clampFactor) {
		return new CommonUpGlobalPop(getVelocityClamper(clampFactor));
	}

	@Override
	public UpdateGLbest getUpGIbestMethod() {
		return new CommonUpGbest();
	}

	@Override
	public DataCollector getDataCollector() {
		return collector;
	}

	public VelocityClamping getVelocityClamper(double clampFactor) {
		return new CommonVelocityClamping(clampFactor);
	}

}
