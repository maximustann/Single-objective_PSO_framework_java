package algorithms;

public class FitnessFunc implements FitnessFunction{
	public Normalize normalize;
	private double max;
	private double min;

	public FitnessFunc(Normalize normalize, double max, double min){
		this.normalize = normalize;
		this.max = max;
		this.min = min;
	}
	@Override
	public double[] normalizedFit(double[][] popVar) {
		// TODO Auto-generated method stub
		double [] fitness = unNormalizedFit(popVar);
		normalize.doNorm(fitness, max, min);
		return fitness;
	}

	@Override
	public double[] unNormalizedFit(double[][] popVar) {
		// TODO Auto-generated method stub
		return null;
	}

}
