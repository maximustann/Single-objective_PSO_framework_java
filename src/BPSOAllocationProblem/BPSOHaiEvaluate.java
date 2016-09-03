package BPSOAllocationProblem;

import java.util.ArrayList;

import algorithms.Evaluate;
import algorithms.FitnessFunction;

public class BPSOHaiEvaluate implements Evaluate{
	private ArrayList<FitnessFunction> funcList;
	private double[] weights;
	public BPSOHaiEvaluate(double[] weights){
		this.weights = weights;
	}

	public BPSOHaiEvaluate(ArrayList<FitnessFunction> funcList){
		this.funcList = funcList;
	}

	public void setFuncList(ArrayList<FitnessFunction> funcList){
		this.funcList = funcList;
	}

	public void evaluate(double[][] popVar, double[] fitness){
		ArrayList<double []> fitList = new ArrayList<double []>();
		for(int i = 0; i < funcList.size(); i++){
			fitList.add(funcList.get(i).normalizedFit(popVar));
		}

		for(int i = 0; i < fitness.length; i++){
			for(int j = 0; j < funcList.size(); j++){
				fitness[i] += weights[j] * fitList.get(j)[i];
			}
		}
	}
}