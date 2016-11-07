/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * WriteCsvFile.java - An interface of write csv file
 */
package FileHandlers;

import java.io.IOException;
import java.util.ArrayList;
/**
 * write csv file
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public interface WriteCsvFile {
	public void write(String fileName, ArrayList<Double> data) throws IOException;
}
