package BPSOAllocationProblem;

import java.util.ArrayList;

import dataCollector.DataCollector;

public class ResultCollector implements DataCollector {
	private ArrayList<Object> resultData;

	public ResultCollector(){
		resultData = new ArrayList<Object>();
	}
	@Override
	public void collect(Object data) {
		resultData.add(data);
	}

	public ArrayList<Object> getResult(){
		return resultData;
	}

}
