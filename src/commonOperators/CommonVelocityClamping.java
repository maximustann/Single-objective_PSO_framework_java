/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * CommonVelocityClamping.java - A method to clamp velocity.
 */
package commonOperators;

import algorithms.VelocityClamping;
/**
 * Clamping for Velocity
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class CommonVelocityClamping implements VelocityClamping{
	private double clampFactor;
    /**
     * @param clampFactor 
     * @see <a href="http://www.swarmintelligence.org/tutorials.php">http://www.swarmintelligence.org/tutorials.php</a>
     */	
	public CommonVelocityClamping(double clampFactor){
		this.clampFactor = clampFactor;
	}
	
    /**
     * @param velocity 2D-array of velocity
     * @param lbound the lower boundary of a variable of a particle
     * @param ubound the upper boundary of a variable of a particle
     */	
	@Override
	public void clamping(double[][] velocity, double lbound, double ubound) {
		double vMax = clampFactor * (ubound - lbound) / 2;
		double vMin = clampFactor * (lbound - ubound) / 2;
		int popSize = velocity.length;
		int maxVar = velocity[0].length;
		for(int i = 0; i < popSize; i++){
			for(int j = 0; j < maxVar; j++){
				if(velocity[i][j] > vMax){
					velocity[i][j] = vMax;
				}
				if(velocity[i][j] < vMin){
					velocity[i][j] = vMin;
				}
			}
		}
	}

}
