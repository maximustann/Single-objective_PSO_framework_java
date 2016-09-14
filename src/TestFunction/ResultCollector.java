package TestFunction;

import java.util.ArrayList;

import dataCollector.DataCollector;

public class ResultCollector implements DataCollector {
	private ArrayList<double[]> resultData;

	public ResultCollector(){
		resultData = new ArrayList<double[]>();
	}
	@Override
	public void collect(Object data) {
		resultData.add((double[]) data);
	}

	public ArrayList<double[]> getResult(){
		return resultData;
	}

	public void printResult(){
		for(int i = 0; i < resultData.size(); i++){
			for(int j = 0; j < ((double[]) resultData.get(0)).length; j++){
				System.out.print(((double[]) resultData.get(i))[j] + " ");
			}
			System.out.println();
		}
	}

}
