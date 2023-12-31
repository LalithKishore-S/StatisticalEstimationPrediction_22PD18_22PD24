/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.statistical_estimation;

/**
 *
 * @author 91822
 */
import javax.swing.*;
import java.text.DecimalFormat;
public class LinearRegression extends Regression{

	public LinearRegression(double[] x_values, double[] y_values) {
		super(x_values, y_values);
	}
	
	void Predict(double x)
	{
		//Yp=B0 + B1*X
		double []y_values=this.getY_values();
		double []x_values=this.getX_values();
		
		
		double sumx=0.0,sumy=0.0,sumx2=0.0,sumxy=0.0;
		for(int i=0;i<x_values.length;i++)
		{
			
			sumx+=x_values[i];
			sumy+=y_values[i];
			sumx2+=Math.pow(x_values[i], 2);
			sumxy+=x_values[i]*y_values[i];
			
		}
		//System.out.println(sumx+" "+sumy+" "+sumx2+" "+sumxy);
		
		double B0 = (sumy*sumx2-sumx*sumxy)/(x_values.length*sumx2 - Math.pow(sumx, 2));
		double B1 = (x_values.length*sumxy - sumx*sumy)/(x_values.length*sumx2 - Math.pow(sumx, 2));
		
		double Yp=B0 + B1*x;
		//System.out.println(B0+" "+B1);
		DecimalFormat formatter=new DecimalFormat("#0.000");
		JOptionPane.showMessageDialog(null,"The predicted y value for the given x value is "+formatter.format(Yp));
	}
	

}
