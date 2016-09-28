/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * ReadCsvFile.java - An interface of read csv file
 */
package FileHandlers;
/**
 * Read csv file
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public interface ReadCsvFile {
    /**
     * read file
     * @param fileName a string of file name
     * @param data give a 2D array to store result. That does not
     * 			sound right.
     */	
	public void read(String fileName, double[][] data);
	
    /**
     * set separation string
     * @param sep separation string
     */	
	public void setSep(String sep);
}
