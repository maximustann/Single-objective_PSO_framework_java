/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * ReadByRow.java - read file by row
 */
package FileHandlers;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Read csv file by row
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class ReadByRow implements ReadCsvFile{
	String csvSplitBy;
	String line;
    /**
     * Constructor
     * set separation string and an empty line
     */	
	public ReadByRow(){
		csvSplitBy = ",";
		line = "";
	}
    /**
     * read by row
     * @param fileName a string of filename
     * @param data pass in the data buffer you are going to store
     */	
	@Override
	public void read(String fileName, double[][] data) {
		File fd = new File(fileName);
		double[][] temp = readCsv(fd, data.length, data[0].length);

		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[0].length; j++)
			data[i][j] = temp[i][j];
		}
	}
    /**
     * read csv file
     * @param fileName a file descriptor
     * @param rowNum number of row
     * @param colNum number of column
     * @return 2D-array of data
     */	
	private double [][] readCsv(File fileName, int rowNum, int colNum){
		BufferedReader br = null;

		double[][] content = new double[rowNum][colNum];
		try {
			br = new BufferedReader(new FileReader(fileName));
			int rowCount = 0;
			while((line = br.readLine()) != null){
				String[] con = line.split(csvSplitBy);
				for(int i = 0; i < con.length; i++){
					content[rowCount][i] = Double.parseDouble(con[i]);
				}
				rowCount++;
			}
		} catch(FileNotFoundException e){
				e.printStackTrace();
		} catch(IOException e){
				e.printStackTrace();
		}
		return content;
	}

    /**
     * set separation string
     * @param sep separation string    
     */
	@Override
	public void setSep(String sep) {
		csvSplitBy = sep;
	}

}
