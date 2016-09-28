/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * DataCollector.java - An Interface of Data collector.
 */
package dataCollector;
/**
 * data collector
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public interface DataCollector {
    /**
     * collect data
     * @param object data can be a 2D array or 1D array
     */	
	public void collect(Object data);
}
