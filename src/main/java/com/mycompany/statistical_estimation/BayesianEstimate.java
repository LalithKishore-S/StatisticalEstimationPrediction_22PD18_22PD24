/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.statistical_estimation;

/**
 *
 * @author 91822
 */
import java.util.Random;

public class BayesianEstimate extends Estimation{

	private double PriorDis[];
	private double PriorDis_mean;
	private double PriorDis_variance;
	private double BayesianEstimation;
	private String PriorDisType;
	
	
	public BayesianEstimate(double[] Population,String type) {
		super(Population);
		Random rand=new Random();
		PriorDis=new double[1000];
		
		for(int j=0;j<Population.length/3+1;j++)
		{
			for(int k=0;k<10;k++)
			{
				PriorDis[j]+=Population[rand.nextInt(Population.length)];
			}
			PriorDis[j]/=10;		
		}
		for(int i=0;i<PriorDis.length;i++)
		{
			PriorDis_mean+=PriorDis[i];
		}
		PriorDis_mean/=PriorDis.length;
		for(int i=0;i<PriorDis.length;i++)
			PriorDis_variance+=Math.pow(PriorDis[i]-PriorDis_mean,2);
		PriorDis_variance/=PriorDis.length;
		
		PriorDisType=type;
		
		BayesianEstimation=0.0;
	}
	
	public double[] getPriorDis() {
		return PriorDis;
	}
	public void setPriorDis(double[] priorDis) {
		PriorDis = priorDis;
	}
	public double getPriorDis_mean() {
		return PriorDis_mean;
	}
	public void setPriorDis_mean(double priorDis_mean) {
		PriorDis_mean = priorDis_mean;
	}
	public double getPriorDis_variance() {
		return PriorDis_variance;
	}
	public void setPriorDis_variance(double priorDis_variance) {
		PriorDis_variance = priorDis_variance;
	}
	
	
	public double getBayesianEstimation() {
		return BayesianEstimation;
	}

	public void setBayesianEstimation(double bayesianEstimation) {
		BayesianEstimation = bayesianEstimation;
	}

	public String getPriorDisType() {
		return PriorDisType;
	}

	public void setPriorDisType(String priorDisType) {
		PriorDisType = priorDisType;
	}

	public void Estimate()
	{
		double sum=0.0;
		double sample []=this.getSample();
		for(double  i:sample)
			sum+=i;
		if(PriorDisType.equals("E") || PriorDisType.equals("e"))
		{
			double lambda=1/PriorDis_mean;
			BayesianEstimation=(sum-lambda*this.getPopulation_variance())/sample.length;
		}
		else
		{
			BayesianEstimation=(PriorDis_variance*sum+PriorDis_mean*this.getPopulation_variance())/(this.getPopulation_variance() + sample.length*PriorDis_variance);
		}
	}
}

