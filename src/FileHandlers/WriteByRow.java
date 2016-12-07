/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * WriteByRow.java - write csv file by row
 */
package FileHandlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteByRow implements WriteCsvFile {
	private String csvSplitBy;
	private int rowNum;
	
	
	/**
	 * 
	 * @param csvSplitBy separation symbol
	 * @param rowNum number of rows
	 */
	public WriteByRow( String csvSplitBy, int rowNum){
		this.csvSplitBy = csvSplitBy;
		this.rowNum = rowNum;
	}
	
	@Override
	public void write(String fileName, ArrayList<Double> data) throws IOException {
		File file = null;
		int dataSize = data.size();
		int enterNum = data.size() / rowNum;
		try {
			file = new File(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!file.exists()){
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
		@SuppressWarnings("resource")
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		
		for(int i = 0, j = 0; i < dataSize; i++, j++){
			if(j == enterNum){
				fw.write(data.get(i).toString() + csvSplitBy + "\n");
				j = 0;
			} else {
				fw.write(data.get(i).toString() + csvSplitBy);
			}
		}
		fw.close();
	}

}
