package algorithms;

public interface UpdateIbest extends UpdateGIbest{
	public void update(double[][] pBestVar, double[] pBestFit, double[][] IBestVar,
							double[] IBestFit, int optimization, int generation);
}
