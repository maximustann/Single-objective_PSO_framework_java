package algorithms;

public interface UpdateIbest{
	public void update(double[][] pBestVar, double[] pBestFit, double[][] IBestVar, 
							double[] IBestFit, int optimization, int generation);
}
