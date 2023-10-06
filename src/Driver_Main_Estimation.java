
import java.io.*;
import java.util.*;

public class Driver_Main_Estimation {

	public static void main(String[] args) {
		
		
		   Scanner sc=new Scanner(System.in);
		   int choice;
		   char contin='y';
		   String line="",x="",y="";
		   System.out.println("Enter the file path:\n");
		   String path=sc.nextLine();
		   int i=0,countrow=0,countcol=0,column=0;
		   	   //for(int i=0;i<5;i++)
			 //  values[i]=new String[5];
		   
		   
		   try
		   {
			   FileInputStream f=new FileInputStream(path);
			   BufferedReader br=new BufferedReader(new InputStreamReader(f));
			   
			   
			   while((line=br.readLine())!=null)
			   {
				   String temp[]=line.split(",");
				   if(i==0)
				   {
				      countcol=temp.length;
				      i++;
				   }
				   countrow++;
			   }
			   
			   
			   String values[][]=new String[countrow][];
			   
			   
			   for(int j=0;j<countrow;j++)
			   {
				   values[j]=new String[countcol];
			   }
			   
			   
			   br.close();
			   f=new FileInputStream(path);
			   br=new BufferedReader(new InputStreamReader(f));
			   i=0;
			   
			   
			   while((line=br.readLine())!=null)
			   {
			      values[i++]=line.split(",");
			   }
			   br.close();
			   
			   
//	System.out.println(countrow+" "+countcol);
			   while(contin=='y')
			   {
			      System.out.println("Enter the operation you wish to perform:\n1.Estimate mean\n2.Predict next value\n");
			      choice=sc.nextInt();
			      System.out.println("\n");
			      switch(choice)
			      {
			      case 1:
			    	  
			    	  
			    	  System.out.println("Enter the column name for which the estimation is to be done:\n");
				      line=sc.nextLine();
				   
				   
				      for(int j=0;j<countcol;j++)
				      {
					      if(line.equals(values[0][j]))
					      {
						      column=j;
						      break;
					      }
				      }
				   
				   
				      double population[]=new double[countrow-2];
				      for(int j=0;j<countrow-2;j++)
				      {
					       population[j]=Double.parseDouble(values[j+1][column]);
				      }
				   
				   
				      Mean_estimation(population);
				      break;
				      
				      
			      case 2:
			    	  
			    	  
			    	  System.out.println("Enter the independent dataset column:\n");
			    	  x=sc.nextLine();
			    	  sc.nextLine();
			    	  System.out.println("Enter the dependent dataset columns:\n");
			    	  y=sc.nextLine();
			    	  
			    	  
			    	  for(int j=0;j<countcol;j++)
				      {
					      if(x.equals(values[0][j]))
					      {
						      column=j;
						      break;
					      }
				      }
				   
				   
				      double x_values[]=new double[countrow-1];
				      for(int j=0;j<countrow-1;j++)
				      {
					       x_values[j]=Double.parseDouble(values[j+1][column]);
				      }
				      
				      
				      for(int j=0;j<countcol;j++)
				      {
					      if(y.equals(values[0][j]))
					      {
						      column=j;
						      break;
					      }
				      }
//System.out.println(x_values.length);
//for(int j=0;i<x_values.length;j++)
//System.out.println(x_values[j]);
 //System.out.println("\n");
				   
				      double y_values[]=new double[countrow-1];
				      for(int j=0;j<countrow-1;j++)
				      {
					       y_values[j]=Double.parseDouble(values[j+1][column]);
				      }
// System.out.println(y_values.length);
 //for(int j=0;i<x_values.length;j++)
	//System.out.println(x_values[j]);
 //System.out.println("\n");				      
				      System.out.println("Enter the value of x for which the y value is to be predicted:\n");
				      double xvalue = sc.nextDouble();
				      
				      LinearRegression_predict(x_values,y_values,xvalue);
				      break;
				      
				   default :
					   System.out.println("Enter a valid option!!\n");
					   continue;
				    	  
				      
			      }
			      sc.nextLine();
			      System.out.println("Do you wish to continue (y/n):\n");
			      contin=sc.nextLine().charAt(0);
			      
			   }   
			      
			      sc.close();
	//  for(int j=0;j<countrow-2;j++)
		//   System.out.println(population[j]+"\n");
		   }
		   catch(IOException e)
		   {
			   System.out.println("io exception...");
			   e.printStackTrace();
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	}
	
	public static void  Mean_estimation(double [] population)
	{
		
		MaximumLikelihoodEstimate Mle=new MaximumLikelihoodEstimate(population);
		BayesianEstimate Bayesian_normal=new BayesianEstimate(population,"N");
		BayesianEstimate Bayesian_exp=new BayesianEstimate(population,"E");
		
		Bayesian_normal.setSample(Mle.getSample());
		Bayesian_exp.setSample(Mle.getSample());
		Mle.Estimate();
		Bayesian_normal.Estimate();
		Bayesian_exp.Estimate();
		
		System.out.println("\nMAXIMUM LIKELIHOOD ESTIMATION : "+Mle.getMaximumLikelihoodEstimation()+"\nBAYESIAN ESTIMATION (PRIOR NORMAL ) : "+Bayesian_normal.getBayesianEstimation()+"\nBAYESIAN ESTIMATION (PRIOR EXPONENTIAL) : "+Bayesian_exp.getBayesianEstimation()+"\nORIGINAL POPULATION MEAN : "+Mle.getPopulation_mean());
	}

	public static void LinearRegression_predict(double[] x_values,double [] y_values,double xvalue)
	{
		
		LinearRegression LR = new LinearRegression(x_values,y_values);
		
		LR.Predict(xvalue);
	}
}


