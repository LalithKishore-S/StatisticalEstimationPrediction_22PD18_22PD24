/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.statistical_estimation;

/**
 *
 * @author 91822
 */
abstract public class Regression {
	
   private double[] x_values;
   private double[] y_values;
   
   public Regression(double[] x_values, double[] y_values) {
	  this.x_values = x_values;
	  this.y_values = y_values;
   }

   public double[] getX_values() {
	   return x_values;
   }

   public void setX_values(double[] x_values) {
	   this.x_values = x_values;
   }

   public double[] getY_values() {
	   return y_values;
   }

   public void setY_values(double[] y_values) {
	   this.y_values = y_values;
   } 
   
   abstract void Predict(double x);
   
   
}
