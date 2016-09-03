package algorithms;

public interface FitnessFunction {
	public double[] normalizedFit(double[][] popVar);
	public double[] unNormalizedFit(double[][] popVar);
}
