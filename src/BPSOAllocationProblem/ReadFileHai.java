package BPSOAllocationProblem;

import FileHandlers.ReadByCol;
import FileHandlers.ReadByRow;
import FileHandlers.ReadCsvFile;

public class ReadFileHai{
	private ReadCsvFile readByRow;
	private ReadCsvFile readByCol;
	private double[] costMatrix;
	private double[] latencyMatrix;
	private double[] freqMatrix;
	private double[][] costRangeData;
	private double[][] timeRangeData;
	private int noService;
	private int noLocation;
	private int noUser;

	public ReadFileHai(String config, String cost, String latency, String freq, String costRange, String timeRange){

		readByRow = new ReadByRow();
		readByCol = new ReadByCol();

		costRangeData = new double[1][2];
		timeRangeData = new double[1][2];
		double[][] configData = new double[1][3];
		readByRow.read(config, configData);
		noService = (int) configData[0][2];
		noLocation = (int) configData[0][1];
		noUser = (int) configData[0][0];


		double[][] tempCost = new double[noService][noLocation];
		double[][] tempLatency = new double[noUser][noLocation];
		double[][] tempFreq = new double[1][noService];
		costMatrix = new double[noService * noLocation];
		latencyMatrix = new double[noUser * noLocation];
		freqMatrix = new double[noService];

		readByCol.read(costRange, costRangeData);
		readByCol.read(timeRange, timeRangeData);
		readByRow.read(cost, tempCost);
		readByRow.read(latency, tempLatency);
		readByCol.read(freq, tempFreq);


		for(int i = 0; i < noService; i++){
			for(int j = 0; j < noLocation; j++){
				costMatrix[i * noService + j] = tempCost[i][j];
			}
		}

		for(int i = 0; i < noUser; i++){
			for(int j = 0; j < noLocation; j++){
				latencyMatrix[i * noUser + j] = tempLatency[i][j];
			}
		}

		freqMatrix = tempFreq[0];

	}
	public double getTmin() {
		return timeRangeData[0][0];
	}
	public double getTmax() {
		return timeRangeData[0][1];
	}

	public double getCmin() {
		return costRangeData[0][0];
	}

	public double getCmax() {
		return costRangeData[0][1];
	}

	public int getNoService() {
		return noService;
	}

	public int getNoLocation() {
		return noLocation;
	}

	public int getNoUser() {
		return noUser;
	}

	public double[] getCostMatrix() {
		return costMatrix;
	}

	public double[] getLatencyMatrix() {
		return latencyMatrix;
	}

	public double[] getFreqMatrix() {
		return freqMatrix;
	}



}