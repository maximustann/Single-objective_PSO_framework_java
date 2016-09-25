package algorithms;

public interface UpdateLbest extends UpdateGLbest{
	public void update(double[][] pBestVar, double[] pBestFit, double[][] IBestVar,
							double[] IBestFit, int optimization, int generation);
}
