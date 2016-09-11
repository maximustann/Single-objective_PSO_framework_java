package algorithms;

public interface UpPopGlobal extends UpPop{
	public void update(double[][] popVar, double [] pBestFit, double[][] velocity,
						double[][] pBestVar, double[] gBestVar, double w, double c1, double c2);
}
