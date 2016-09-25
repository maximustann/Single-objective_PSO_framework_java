package algorithms;

public interface UpdateGbest extends UpdateGLbest{
	public double update(double[][] pBestVar, double[] pBestFit, double[] gBestVar,
						double gBestFit, int optimization, int generation);
}
