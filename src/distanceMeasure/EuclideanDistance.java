package distanceMeasure;

public class EuclideanDistance implements DistanceMeasure{

	@Override
	public double calcDist(double[] host, double[] away) {
		double distance = 0;
		for(int i = 0; i < host.length; i++){
			distance += Math.pow((away[i] - host[i]), 2);
		}
		return Math.sqrt(distance);
	}

}
