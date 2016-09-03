package algorithms;

public class FitnessFunc implements FitnessFunction{
	public Normalize normalize;

	public FitnessFunc(Normalize normalize){
		this.normalize = normalize;
	}
	@Override
	public double[] normalizedFit(double[][] popVar) {
		// TODO Auto-generated method stub
		double [] fitness = unNormalizedFit(popVar);
		normalize.doNorm(fitness);
		return fitness;
	}

	@Override
	public double[] unNormalizedFit(double[][] popVar) {
		// TODO Auto-generated method stub
		return null;
	}

}
