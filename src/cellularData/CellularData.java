package cellularData;

import java.text.DecimalFormat;  //CLASS TO SET THE DECIMAL OUTPUT TO SPECIFIC DECIMAL PALCES

public class CellularData {
	private static DecimalFormat decimalPlaces = new DecimalFormat("##.###");  //THIS SETS THE NUMBER OF PLACES TO THE RIGHT OF THE DECIMAL POINT.
	int numRows;    
	int numColumns;
	int startingYear;
	int count = 1;
	
//	String[] anotherArray;	//I NEED THIS ARRAY FOR THE YEARS. THIS WILL BE AN ARRAY OF INTEGERS
	String[][] anArray;   //CHANGED THE ARRAY FROM OBJECT TO STRING. CONVERT THE INTEGERS FROM STRING TO INT.
	
	
	public CellularData()	{    //constructor
	}
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //REMEMBER PARAMETERS NEED TYPE...CONSTRUCTOR
		
		
		this.numRows = numRows;
		this.numColumns = numColumns;  								  //THIS MAY BE LIMITING THE ARRAYS SIZE  NEED TO USE COUNTRY.LENGTH!??????????
		this.startingYear = startingYear;
		this.anArray = new String[numRows][numColumns + 1];  			  


			   				  
	}
//****************************************************************************************************
//TESTING	
	public void loadCountryYears()	{ 
		anArray[0][0] = "Year/Country";							       //THE 2-D ARRAY IS NOW STRING!!!!!!!! DON'T THINK I NEED THIS!!
			for (int i = 1; i <= numColumns ; i++)	{       		   //TESTING. 
				anArray[0][i] = Integer.toString(startingYear);
				startingYear++;		
			}
	} 
//*****************************************************************************************	
//*****************************************************************************************	
	public void getNumSubscriptionsInCountryForPeriod(String country, int startYear, int endYear)	{  		//INCOMPLETE METHOD
		double temp = 0.00;
		System.out.println("This finds the country and stats in the array!!!!!");
		for(int i = 1; i <= anArray.length - 1; i++)	{
			if (anArray[i][0].contains(country))	{									//REMEMBER <>.contains(<>) although not sure this is correct bit it works.
				System.out.print(country + "\t\t");										//THIS NOW FUCKING WORKS!!!!!!
				for(int j = 1; j <= anArray[i].length-1; j++)	{
					System.out.print(anArray[i][j] + "\t\t");
					temp = temp + (Double.parseDouble(anArray[i][j]));
				}
				System.out.println("\n");
			}
		}
		System.out.println("This prints the country and it's total cellular stats! Need to figure out year period.");
		System.out.println("The country is " + country);
		System.out.println(country + ": " + decimalPlaces.format(temp));
	}
				
//******************************************************************************************	 
//*****************************************************************************************		
	public void addCountry(String country, double[] a)	{
		
			anArray[count][0] = country + "\t";							   //THIS IS NOT WORKING PROPERLY. ARRAY STARTING IS WRONG
			for (int i = 1; i <= a.length ; i++)	{       		   //TESTING. 
				anArray[count][i] = decimalPlaces.format(a[i-1]);				   //THE LOADING ARRAY IS STARTING AT 1 INSTEAD OF 0. OK THIS WORKS BUT NOT CORRECTLY.
																	   //decimalPlaces SETS THE DECIMAL PLACES. USES DECIMALFORMAT CLASS 
			}
			count++;
	}
	
/*	@Override	
 	public boolean equals(String[][] a, String b)	{
 		
 		if (a.contains(b))
 			return true;
 		else return false;
	} 
 */
	
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



