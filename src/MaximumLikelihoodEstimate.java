
public class MaximumLikelihoodEstimate extends Estimation {
	
	private double MaximumLikelihoodEstimation;

	public MaximumLikelihoodEstimate(double[] Population) {
		super(Population);
		MaximumLikelihoodEstimation=0;
	}
	
	
	public double getMaximumLikelihoodEstimation() {
		return MaximumLikelihoodEstimation;
	}


	public void setMaximumLikelihoodEstimation(double maximumLikelihoodEstimation) {
		MaximumLikelihoodEstimation = maximumLikelihoodEstimation;
	}


	public void Estimate()
	{
		double Sample[]=this.getSample();
		for(int i=0;i<Sample.length;i++)
			   MaximumLikelihoodEstimation+=Sample[i];
			MaximumLikelihoodEstimation/=Sample.length;
	}
}
