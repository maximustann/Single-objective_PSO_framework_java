package algorithms;

public interface UpPopLocal extends UpPop{
	public void update(double[][] popVar, double [] pBestFit, double[][] velocity,
						double[][] pBestVar, double[][] iBestVar, double w, double c1, double c2);
}
