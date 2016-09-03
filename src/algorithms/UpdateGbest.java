package algorithms;

public interface UpdateGbest {
	public double update(double[][] pBestVar, double[] pBestFit, double[] gBestVar, double gBestFit, int optimization);
}
