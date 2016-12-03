/* Nathan Mullaney
Date: Dec 3, 2016
Program Name: Line.java
Description: 
*/

import java.rmi.server.Operation;
import java.util.ArrayList;
public class Line

{
   private String Stringnum = "";
   private String equation;
   Double xvar;
   private String original;
   //private ArrayList<Points> points;
   private ArrayList<String> parts;
   private ArrayList<String> operator;
   private ArrayList<Double> numbers;

   public  Line( String n )
   {
      equation = "3x +1";
      original = "" + equation;
      //points = new ArrayList<Points>();
      parts = new ArrayList<String>();
      operator = new ArrayList<String>();
      numbers = new ArrayList<Double>();
      //this.createEq();
   }

   public void imafuckindoit()
   {
      //adds * symbol if it finds a number next to a variable
      for(int i = 0; i < (equation.length()-2); i++)
      {
           String check = equation.substring(i,i+2);
     
           if((check.charAt(0) >= 48 && check.charAt(0) <= 57) && (check.charAt(1) >= 97 && check.charAt(1) <=122));
           {
             String first = equation.substring(0,i+1);
             String second = equation.substring(i+1);
             equation = first + "*" + second;
           }
       }
      //divides the equation into different sections
      //operators are put into an operator arrayList
      //numbers and variables are put into parts arrayList
      for(int i = 0;i < equation.length();i++)
      {
         //ascii values of operators
         if(equation.charAt(i) == 42 || equation.charAt(i) == 43 || equation.charAt(i) == 45 || equation.charAt(i) == 47)
         {
            parts.add(equation.substring(0,i));
            operator.add(equation.substring(i,i+1));            
            equation = equation.substring(i+1);
         }
      }
   }
   
 
   public void convert()
   {
     this.imafuckindoit();
     //converts the positions of an ArrayList into Integers (not ints) and puts them into a number ArrayList
     for(int i = 0; i < parts.size(); i++)
     {
       String it = parts.get(i);
       //numbers
       if(it.charAt(0) >= 48 && it.charAt(0) <= 57)
       {
          Double num = Double.parseDouble(it);
          numbers.add(num);
       }
       //variables
       else if(it .equals("x"))
       {
          numbers.add(xvar);
       }
     }
   }
   
   public double createEq()
   {
      int nigga = 0;
      this.convert();
      //rusn through operator class, and for each String determines what it is and does the appropriate operations
      for(int i = 0; i < operator.size(); i++)
      {
         String test = operator.get(i);
         if(test.equals("*"))
         {
           nigga += this.multiply(numbers.get(i), numbers.get(i+1));
         }
         else if(test.equals("/"))
         {
            nigga +=this.divide(numbers.get(i), numbers.get(i+1));
         }
         else if(test.equals("+"))
         {
           nigga+= this.add(numbers.get(i), numbers.get(i+1));
         }
         else
         {
            nigga+=this.subtract(numbers.get(i), numbers.get(i+1));
         }
      }
      return nigga;
   }
   //self explanatory
   public double multiply(Double object, Double object2)
   {
      double combine = object.doubleValue() * object2.doubleValue();
      return combine;
   }
   public double divide(Double object,Double object2)
   {
      double combine = object.doubleValue()/object2.doubleValue();
      return combine;
   }
   public double add(Double object, Double object2)
   {
      double combine = object.doubleValue() * object2.doubleValue();
      return combine;
   }
   public double subtract(Double object, Double object2)
   {
      double combine = object.doubleValue() * object2.doubleValue();
      return combine;
   }
   //needs work, but should run from -10 to 10 and get y-values for each x-value
   public double Math()
   {
      double yvar = 0;
      this.createEq();
   }
   
   /*public void renderEachPoint()

   {

      for(int i = 0; i<points.size(); i++)

      {

         points.get(i).renderEachPoint();

      }

   }

   

   public int getY(int i)

   {

     return 

   }

   

   public int getMaxYint i)

   {

      int max;

      max = points.get(0).getPointY();

      //max = points.getPointY(0);

      

      for(int i = 0; i<points.size(); i++)

      {

         if(points.get(i) > max)

            max = points.get(i).getPointY();

      }

      return max;

      

   }

   

   public int getMinY()

   {

      int min;

      min = points.get(0).getXPoint;

      

   

      for(int i = 0; i<points.size(); i++)

      {

         if(points.get(i) < min)

            min = points.get(i).getPointY();

      } 

      return min;
      
      
*/
   

}
