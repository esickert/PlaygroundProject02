package cellularData;

import java.text.DecimalFormat;  //CLASS TO SET THE DECIMAL OUTPUT TO SPECIFIC DECIMAL PLACES
import org.junit.*;  //this is never used.

public class CellularData {   //THIS IS THE GENERAL CLASS. USE SUBCLASSES TO DEFINE SPECIALIZED CLASSES THAT ADD TO OR REVISE THE GENERAL CLASS.
	private static DecimalFormat decimalPlaces = new DecimalFormat("##.##");  //THIS SETS THE NUMBER OF PLACES TO THE RIGHT OF THE DECIMAL POINT.
	private int numRows;  //???????????????????????? IS THIS BEING USED??????? 
	
	private int numColumns;
	private int startingYear;
	private int countryIndex = 1; //???????????????? HOW IS THIS BEING USED? See method addCountry
	private int firstYear;
	private int lastYear;
	private String[][] anArray;   
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //THIS IS A CONSTRUCTOR!!!!!!!!!!!!
		this.numRows = numRows;
		this.numColumns = numColumns;  								  
		this.startingYear = startingYear;							
		this.anArray = new String[numRows][numColumns + 1];  			  
	}
//****************************************************************************************************
	
	public void loadCountryYears()	{
		System.out.println("The number of rows is : " + numRows);  //PROBLEM HERE IN WHICH NUMROWS NOT USED EXCEPT HERE.
		firstYear = startingYear;
		anArray[0][0] = "Year/Country";							       
			for (int i = 1; i <= numColumns ; i++)	{       		    
				anArray[0][i] = Integer.toString(startingYear);        
				startingYear++;		 								   //ARRAY SIZE IS BASED ON NUMBER OF COLUMNS.
			}
		lastYear =  (startingYear - 1);
	}
	
//*****************************************************************************************		

	public void addCountry(String country, double[] a)	{          
			anArray[countryIndex][0] = country + "\t";							   
			for (int i = 1; i <= a.length; i++)	{       		    
				anArray[countryIndex][i] = decimalPlaces.format(a[i-1]);  			   
			}
			countryIndex++;
	} 
	
//*****************************************************************************************	
	public double getNumSubscriptionsInCountryForPeriod(String country, int startYear, int endYear)	{ 
		double temp = 0.00;
		int startYearIndex = 0;
		int endYearIndex = 0;
	
		for(int i = 0; i <= anArray.length - 1; i++)	{   
			if (anArray[i][0].contains(country)) {
				
				for (int j = 1; j < anArray[0].length; j++)    {                                     
        				int b = Integer.parseInt(anArray[0][j]);          								
       					if (b == startYear)    
            				startYearIndex = j; 
            	} //end of for loop 
            	
           		for (int j = 1; j < anArray[0].length; j++)    {                                     //FINDS THE INDEX OF A YEAR
        				int c = Integer.parseInt(anArray[0][j]);          
       					if (c == endYear)    
            					endYearIndex = j;
            	} //end of for loop 
            	
				if ((startYearIndex == 0) && (endYearIndex == 0)) {
				    System.out.println("Invalid Arguments Request of start year " + startYear + " and end year " + endYear + " for " + country);
				    System.out.println("Valid range is " + firstYear + " to " + lastYear);
				    temp = -1;
				} //end of else statement
				else if ((startYearIndex == 0))	{
					System.out.println("Invalid Argument Request of start year for " + country + ": " + startYear);
					System.out.println("Valid request for start year is " + firstYear);
					temp = -1;
				} //end of if statement
				else if (endYearIndex == 0)	{
					System.out.println("Invalid Argument Request of end year for " + country + ": " + endYear);
					System.out.print ("Valid request for end year is " + lastYear);
					temp = -1;
				} //end of else statement
				else	{	
			   		for (int k = startYearIndex; k <= endYearIndex; k++)    
            		temp = temp + Double.parseDouble(anArray[i][k]);
            	} //end of else statement
			} // end of if statement	
		  
			}//end of for loop
		return temp;
	} //for loop
	
//*****************************************************************************************************	
	@Override   
	public String toString()	{ 
		String output = "\n";
		for(int i = 0; i <= anArray.length - 1; i++)	{
			for(int j = 0; j <= anArray[i].length - 1; j++)	{  
				output += (anArray[i][j] + "\t\t");						
			}
		output += "\n";
		}                                       
		return output;
	} //end of toString
}



