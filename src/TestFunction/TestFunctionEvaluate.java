package TestFunction;

import java.util.ArrayList;

import algorithms.Evaluate;
import algorithms.FitnessFunction;

public class TestFunctionEvaluate implements Evaluate{
	private ArrayList<FitnessFunction> funcList;

	public TestFunctionEvaluate(ArrayList<FitnessFunction> funcList){
		this.funcList = funcList;
	}

	public void setFuncList(ArrayList<FitnessFunction> funcList){
		this.funcList = funcList;
	}

	public void evaluate(double[][] popVar, double[] fitness){
		for(int i = 0; i < fitness.length; i++) {
			fitness[i] = funcList.get(0).normalizedFit(popVar)[i];
		}
	}
}
