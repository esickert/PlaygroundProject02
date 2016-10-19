package cellularData;

import java.text.DecimalFormat;  //CLASS TO SET THE DECIMAL OUTPUT TO SPECIFIC DECIMAL PALCES

public class CellularData {
	private static DecimalFormat decimalPlaces = new DecimalFormat("##.###");  //THIS SETS THE NUMBER OF PLACES TO THE RIGHT OF THE DECIMAL POINT.
	int numRows;    
	int numColumns;
	int startingYear;
	int count = 1;
	
	Object[] anotherArray;	
	Object[][] anArray;
	
	
	public CellularData()	{    //constructor
	}
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //REMEMBER PARAMETERS NEED TYPE...CONSTRUCTOR
		
		
		this.numRows = numRows;
		this.numColumns = numColumns;  								  //THIS MAY BE LIMITING THE ARRAYS SIZE  NEED TO USE COUNTRY.LENGTH!??????????
		this.startingYear = startingYear;
		anArray = new Object[numRows][numColumns + 1];  			  //this is an array of Object class  NOTE THAT I ADD 1 HERE WHICH IS A HACK!!


			   				  //THIS IS AN ABSOLUTE HACK. HAVEN'T USED THIS YET.
	}
//****************************************************************************************************
//TESTING	
	public void loadCountryYears()	{ 
		anArray[0][0] = "Year/Country";							   //THIS USES THE FIRST ROW OF anARRAY TO STORE YEARS
			for (int i = 1; i <= numColumns ; i++)	{       		   //TESTING. 
				anArray[0][i] = startingYear;
				startingYear++;		
			}
	} 
	
	public void getNumSubscriptionsInCountryForPeriod(String country, int startYear, int endYear)	{  		//INCOMPLETE METHOD
	
		System.out.println(country);
		System.out.println(startYear);
	}
	 
	
	public void addCountry(String country, double[] a)	{
		
			anArray[count][0] = country + "\t";							   //THIS IS NOT WORKING PROPERLY. ARRAY STARTING IS WRONG
			for (int i = 1; i <= a.length ; i++)	{       		   //TESTING. 
				anArray[count][i] = decimalPlaces.format(a[i-1]);				   //THE LOADING ARRAY IS STARTING AT 1 INSTEAD OF 0. OK THIS WORKS BUT NOT CORRECTLY.
																	   //decimalPlaces SETS THE DECIMAL PLACES. USES DECIMALFORMAT CLASS 
			}
			count++;
	}
	
	
  
	
//*****************************************************************************************************	  
	@Override   //using this as a safety check that i didn't misspell anything
	public String toString()	{ //this works to override java.lang.Object.toString
		String output = "";
		for(int i = 0; i <= anArray.length - 1; i++)	{
			for(int j = 0; j <= anArray[i].length - 1; j++)	{  //ROWS
				output += (anArray[i][j] + "\t\t");						//added another tab here
			}
		output += "\n";
		}                                       
		return output;
	}

	
	}



