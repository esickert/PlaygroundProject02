package cellularData;

import java.text.DecimalFormat;  //CLASS TO SET THE DECIMAL OUTPUT TO SPECIFIC DECIMAL PLACES

public class CellularData {
	private static DecimalFormat decimalPlaces = new DecimalFormat("##.##");  //THIS SETS THE NUMBER OF PLACES TO THE RIGHT OF THE DECIMAL POINT.
	int numRows;    
	int numColumns;
	int startingYear;
	int count = 1;
	
	String[][] anArray;   //CHANGED THE ARRAY FROM OBJECT TO STRING. CONVERT THE INTEGERS FROM STRING TO INT.
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //REMEMBER PARAMETERS NEED TYPE...THIS IS A CONSTRUCTOR!!!!!!!!!!!!
		this.numRows = numRows;
		this.numColumns = numColumns;  								  
		this.startingYear = startingYear;							
		this.anArray = new String[numRows][numColumns + 1];  			  
	}
//****************************************************************************************************
	
	public void loadCountryYears()	{ 
		anArray[0][0] = "Country/Year";							       //THE ELEMENNTS OF THE ARRAY ARE STRINGS
			for (int i = 1; i <= numColumns ; i++)	{       		    
				anArray[0][i] = Integer.toString(startingYear);        //CONVERTING THE INTEGER YEARS TO STRINGS.
				startingYear++;		 								   //ARRAY SIZE IS BASED ON NUMBER OF COLUMNS.
			}
	} 
	
//*****************************************************************************************	
	public double getNumSubscriptionsInCountryForPeriod(String country, int startYear, int endYear)	{  		//INCOMPLETE METHOD
		double temp = 0.00;

		for(int i = 1; i <= anArray.length - 1; i++)	{
			if (anArray[i][0].contains(country))	{				//REMEMBER <>.contains(<>) although not sure this is correct but it works.
				for(int j = 1; j <= anArray[i].length-1; j++)	{
					temp = temp + (Double.parseDouble(anArray[i][j]));
				}
			}
		}
		
		for (int i = 1; i < anArray[0].length - 1; i++)    {  //finds the index of a year
        	int b = Integer.parseInt(anArray[0][i]);          
       		if (b == startYear)    {
            	System.out.println("\nThe index of " + b + " is " + i + "\n");
	       	}
		} 
		System.out.println();  //add lines between output
		return temp;
	}
				
//*****************************************************************************************		

	public void addCountry(String country, double[] a)	{          //THE ARRAY WILL STORE DATA AS A STRING THEN CONVERT INT STRINGS TO INTEGERS.
	//BE SURE TO REINITIALIZE THE ARRAY FOR NEW DATASET!!!!!!!!!!!!!!!!!!!!!!USING "NEW ARRAY STRING[][]"	
			anArray[count][0] = country + "\t";							   
			for (int i = 1; i <= a.length; i++)	{       		    
				anArray[count][i] = decimalPlaces.format(a[i-1]);  //decimalPlaces SETS THE DECIMAL PLACES. USES DECIMALFORMAT CLASS 			   
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
	} //end of toString

	
	}



