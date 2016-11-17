package cellularData;

import java.text.DecimalFormat;  //CLASS TO SET THE DECIMAL OUTPUT TO SPECIFIC DECIMAL PLACES

public class CellularData {   //THIS IS THE GENERAL CLASS. USE SUBCLASSES TO DEFINE SPECIALIZED CLASSES THAT ADD TO OR REVISE THE GENERAL CLASS.
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

	public void addCountry(String country, double[] a)	{          //THE ARRAY WILL STORE DATA AS A STRING THEN CONVERT INT STRINGS TO INTEGERS.
	//BE SURE TO REINITIALIZE THE ARRAY FOR NEW DATASET!!!!!!!!!!!!!!!!!!!!!!USING "NEW ARRAY STRING[][]"	
			anArray[count][0] = country + "\t";							   
			for (int i = 1; i <= a.length; i++)	{       		    
				anArray[count][i] = decimalPlaces.format(a[i-1]);  //decimalPlaces SETS THE DECIMAL PLACES. USES DECIMALFORMAT CLASS 			   
			}
			count++;
	} 
	
//*****************************************************************************************	
	public double getNumSubscriptionsInCountryForPeriod(String country, int startYear, int endYear)	{  		//INCOMPLETE METHOD
		double temp = 0.00;
		int startYearIndex = 0;
		int endYearIndex = 0;

		for(int i = 0; i <= anArray.length - 1; i++)	{   //REMEMBER <>.contains(<>) although not sure this is correct but it works.
			if (anArray[i][0].contains(country)) {
				
			for (int j = 1; j < anArray[0].length - 1; j++)    {                                     //FINDS THE INDEX OF A YEAR
        			int b = Integer.parseInt(anArray[0][j]);          
       				if (b == startYear)    
            			startYearIndex = j;
            	}
            	
/*            	for (int j = 1; j < anArray[0].length - 1; j++)    {                                     //FINDS THE INDEX OF A YEAR
        			int c = Integer.parseInt(anArray[0][j]);          
       				if (c == endYear)    
            			endYearIndex = j;
            	} */
            	
            	System.out.println("\nThe index for " + startYear + " is " + startYearIndex);
//				System.out.println("\nThe index for " + endYear + " is " + endYearIndex); 
			    for (int k = startYearIndex; k <= 7; k++)    {  //adds up the data.
            		temp = temp + Double.parseDouble(anArray[i][k]);
			    } 
		}
	
		
        }
		  
		System.out.println("\n" + country + " for " + startYear + " to " + endYear + " subscriptions: " + temp );  //add lines between output
		return temp; 
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



