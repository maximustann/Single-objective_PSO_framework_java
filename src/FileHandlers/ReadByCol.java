/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * ReadByCol.java - read columns of data and put them into an array.
 */
package FileHandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Read csv file by column
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since PSO framework 1.0
 */
public class ReadByCol implements ReadCsvFile{
	private String csvSplitBy;
	private String line;
    /**
     * Constructor
     * set separation string and an empty line
     */	
	public ReadByCol(){
		csvSplitBy = ",";
		line = "";
	}
    /**
     * read by column
     * @param fileName a string of filename
     * @param data pass in the data buffer you are going to store
     */	
	@Override
	public void read(String fileName, double[][] data) {
		File fd = new File(fileName);
		double[][] myData = readCsv(fd, data.length);
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[0].length; j++) data[i][j] = myData[i][j];
		}
	}
	
    /**
     * read csv file
     * @param fileName a file descriptor
     * @param colNum number of column
     * @return 2D-array of data
     */	
	private double[][] readCsv(File fileName, int colNum){
		BufferedReader br = null;
		double[][] content = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			ArrayList<Double> col = new ArrayList<Double>();
			while((line = br.readLine()) != null){
				String[] con = line.split(csvSplitBy);
				for(int j = 0; j < con.length; j++) col.add(Double.parseDouble(con[j]));
			}
			int rowNum = col.size() / colNum;
			content = new double[colNum][rowNum];
			for(int i = 0; i < rowNum; i++) {
				for(int j = 0; j < colNum; j++) {
					content[j][i] = col.get(j * colNum + i);
				}
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
