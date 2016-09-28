/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * EuclideanDistance.java - An Euclidean Distnace method.
 */
package distanceMeasure;
/**
 * an euclidean distance method
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class EuclideanDistance implements DistanceMeasure{
    /**
     * calculate distance
     * @param host an array of coordinates of a point
     * @param away an array of coordinates of another point
     */	
	@Override
	public double calcDist(double[] host, double[] away) {
		double distance = 0;
		for(int i = 0; i < host.length; i++){
			distance += Math.pow((away[i] - host[i]), 2);
		}
		return Math.sqrt(distance);
	}

}
