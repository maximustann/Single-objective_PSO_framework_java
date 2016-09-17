package BPSOAllocationProblem;

import java.util.ArrayList;

import dataCollector.DataCollector;

public class ResultCollector implements DataCollector {
	private ArrayList<Double> resultData;

	public ResultCollector(){
		resultData = new ArrayList<Double>();
	}
	@Override
	public void collect(Object data) {
		resultData.add((Double) data);
	}

	public ArrayList<Double> getResult(){
		return resultData;
	}

	public void printResult(){
		for(int i = 0; i < resultData.size(); i++){
			System.out.println(resultData.get(i));
		}
		System.out.println();
	}

}
