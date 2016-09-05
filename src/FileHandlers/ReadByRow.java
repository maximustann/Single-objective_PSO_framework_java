package FileHandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadByRow implements ReadCsvFile{
	String csvSplitBy;
	String line;

	public ReadByRow(){
		csvSplitBy = ",";
		line = "";
	}

	@Override
	public void read(String fileName, double[][] data) {
		File fd = new File(fileName);
		ArrayList<double[]> dataBuffer = readCsv(fd);

		for(int i = 0; i < data.length; i++){
			data[i] = dataBuffer.get(i);
		}
	}

	private ArrayList<double []> readCsv(File fileName){
		BufferedReader br = null;
		ArrayList<double []> content = new ArrayList<double []>();

		try {
			br = new BufferedReader(new FileReader(fileName));
			while((line = br.readLine()) != null){
				String[] con = line.split(csvSplitBy);
				double[] temp = new double[con.length];
				for(int i = 0; i < con.length; i++){
					temp[i] = Double.parseDouble(con[i]);
				}
				content.add(temp);
			}
		} catch(FileNotFoundException e){
				e.printStackTrace();
		} catch(IOException e){
				e.printStackTrace();
		}
		return content;
	}

	@Override
	public void setSep(String sep) {
		csvSplitBy = sep;
	}

}
