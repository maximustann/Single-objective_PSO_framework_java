package FileHandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadByCol implements ReadCsvFile{
	String csvSplitBy;
	String line;

	public ReadByCol(){
		csvSplitBy = ",";
		line = "";
	}

	@Override
	public void read(String fileName, double[][] data) {
		// TODO Auto-generated method stub
		File fd = new File(fileName);
		ArrayList<double[]> dataBuffer = readCsv(fd, data[0].length);

		for(int i = 0; i < data[0].length; i++){
			data[i] = dataBuffer.get(i);
		}
	}

	private ArrayList<double []> readCsv(File fileName, int colNum){
		BufferedReader br = null;
		ArrayList<double []> content = new ArrayList<double []>();

		try {
			br = new BufferedReader(new FileReader(fileName));

			for(int i = 0; i < colNum; i++){
				double[] col = new double[colNum];
				while((line = br.readLine()) != null){
					String[] con = line.split(csvSplitBy);
					col[i] = Double.parseDouble(con[i]);
				}
				content.add(col);
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
		// TODO Auto-generated method stub
		csvSplitBy = sep;
	}

}
