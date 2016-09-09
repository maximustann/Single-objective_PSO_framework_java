package algorithms;

public interface UpdatePbest {
	public void update(double[][] pBestVar, double[] pBestFit, double[][] popVar, double[] popFit, int optimization, int generation);
}
