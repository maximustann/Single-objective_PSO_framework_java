/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * DistanceMeasure.java - An Interface of distance measurement.
 */
package distanceMeasure;
/**
 * distance measurement
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public interface DistanceMeasure {
    /**
     * calculate distance
     * @param host an array of coordinates of a point
     * @param away an array of coordinates of another point
     */	
	double calcDist(double[] host, double[] away);
}
