/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * OriginalBPSOFactory.java - A factory to assemble different parts
 */
package psoFactory;

import commonOperators.CommonInitVel;
import commonOperators.CommonUpGbest;
import commonOperators.CommonUpPbest;
import commonOperators.CommonVelocityClamping;
import dataCollector.DataCollector;
import algorithms.*;
import bpso.BPSODynamicW;
import bpso.BPSOUpGlobalPop;
import bpso.InitBinaryParticle;
/**
 * OriginalBPSOFactory
 * In this case, only the initialization of population and update population are different from common version of PSO.
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class OriginalBPSOFactory implements PSOFactory{
	private DataCollector collector;

	/**
	 * Constructor
	 * @param collector is the data collector
	 */
	public OriginalBPSOFactory(DataCollector collector){
		this.collector = collector;
	}

	@Override
	public InitPop getInitPopMethod() {
		return new InitBinaryParticle();
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
		return new BPSOUpGlobalPop(getVelocityClamper(clampFactor));
	}

	@Override
	public UpdateGLbest getUpGIbestMethod() {
		return new CommonUpGbest();
	}

	@Override
	public DataCollector getDataCollector() {
		return collector;
	}

	@Override
	public VelocityClamping getVelocityClamper(double clampFactor) {
		return new CommonVelocityClamping(clampFactor);
	}

	@Override
	public DynamicW getDynamicW(double balance, int maxGen,double lboundW, double uboundW) {
		return new BPSODynamicW(balance, maxGen, lboundW, uboundW);
	}

}
