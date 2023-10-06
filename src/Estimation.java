import java.util.Random;

public abstract class Estimation {
	
   private double Sample[];
   private double Population_variance;
   private double Population_mean;
   
   
   public Estimation(double Population[]) {
	   
	   Random rand=new Random();
	   
	   double sample[]=new double[1000];
	   for(int i=0;i<1000;i++)
		   sample[i]=Population[rand.nextInt(Population.length)];
	   Sample=sample;
		
	   for(int i=0;i<Population.length;i++)
			Population_mean+=Population[i];
		Population_mean=Population_mean/Population.length;
		
		for(int i=0;i<Population.length;i++)
			Population_variance+=Math.pow((Population[i]-Population_mean),2);
		Population_variance=Population_variance/Population.length;	
	   
   }

   public double[] getSample() {
  	   return Sample;
   }
  
   public void setSample(double[] sample) {
	   Sample = sample;
   }
  
   public double getPopulation_variance() {
	   return Population_variance;
   }
  
   public void setPopulation_variance(double population_variance) {
	   Population_variance = population_variance;
   }
   
   
   public double getPopulation_mean() {
	   return Population_mean;
   }

   public void setPopulation_mean(double population_mean) {
	   Population_mean = population_mean;
   }
   
   
   abstract public void Estimate();
}
