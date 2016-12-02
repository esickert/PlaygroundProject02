package cellularData;

import java.text.DecimalFormat;  //CLASS TO SET THE DECIMAL OUTPUT TO SPECIFIC DECIMAL PLACES

public class CellularData {   //THIS IS THE GENERAL CLASS. USE SUBCLASSES TO DEFINE SPECIALIZED CLASSES THAT ADD TO OR REVISE THE GENERAL CLASS.
	private static DecimalFormat decimalPlaces = new DecimalFormat("##.##");  //THIS SETS THE NUMBER OF PLACES TO THE RIGHT OF THE DECIMAL POINT.
	private int numRows;  //???????????????????????? IS THIS BEING USED??????? 
	
	private int numColumns;
	private int startingYear;
	private int count = 1; //???????????????? HOW IS THIS BEING USED????????
	private int firstYear;
	private int lastYear;
	private String[][] anArray;   //CHANGED THE ARRAY FROM OBJECT TO STRING. CONVERT THE STRINGS TO INTEGERS
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //REMEMBER PARAMETERS NEED TYPE...THIS IS A CONSTRUCTOR!!!!!!!!!!!!
		this.numRows = numRows;
		this.numColumns = numColumns;  								  
		this.startingYear = startingYear;							
		this.anArray = new String[numRows][numColumns + 1];  			  
	}
//****************************************************************************************************
	
	public void loadCountryYears()	{
		System.out.println("The number of rows is : " + numRows);  //PROBLEM HERE IN WHICH NUMROWS NOT USED EXCEPT HERE.
//		System.out.println("This is the start year " + startingYear);
		firstYear = startingYear;
		anArray[0][0] = "Year/Country";							       //THE ELEMENNTS OF THE ARRAY ARE STRINGS
			for (int i = 1; i <= numColumns ; i++)	{       		    
				anArray[0][i] = Integer.toString(startingYear);        //CONVERTING THE INTEGER YEARS TO STRINGS.
				startingYear++;		 								   //ARRAY SIZE IS BASED ON NUMBER OF COLUMNS.
			}
//		System.out.println("This is the end year " + (startingYear - 1)); //NEED TO DECREMENT BY 1 BECAUSE STARTINGYEAR
		lastYear =  (startingYear - 1);
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
	public double getNumSubscriptionsInCountryForPeriod(String country, int startYear, int endYear)	{ 
		 		//INCOMPLETE METHOD
		double temp = 0.00;
		int startYearIndex = 0;
		int endYearIndex = 0;
	
		for(int i = 0; i <= anArray.length - 1; i++)	{   //REMEMBER <>.contains(<>) although not sure this is correct but it works.
			if (anArray[i][0].contains(country)) {
				
				for (int j = 1; j < anArray[0].length; j++)    {                                     //FINDS THE INDEX OF A STARTYEAR
        				int b = Integer.parseInt(anArray[0][j]);          								 //OKAY THIS WORKS!!!!!
       					if (b == startYear)    
            				startYearIndex = j; 
            	} //end of for loop 
            	
           		for (int j = 1; j < anArray[0].length; j++)    {                                     //FINDS THE INDEX OF A YEAR
        				int c = Integer.parseInt(anArray[0][j]);          
       					if (c == endYear)    
            					endYearIndex = j;
            	} //end of for loop 
            	
//		System.out.println("\n\nThe index of " + startYear + " is " + startYearIndex);
//		System.out.println("The index of " + endYear + " is " + endYearIndex);

	//THIS IS NOT ERRORING OUT AS EXPECTED.			
				if ((startYearIndex == 0) && (endYearIndex == 0)) {
				    System.out.println("Invalid Arguments Request of start year " + startYear + " and end year " + endYear + " for " + country);
				    System.out.println("Valid range is " + firstYear + " to " + lastYear);
				    temp = -1;
//				    for (int k = firstYear; k <= endYearIndex; k++)    
//            		temp = temp + Double.parseDouble(anArray[i][k]);
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
	@Override   //using this as a safety check that i didn't misspell anything
	public String toString()	{ //this works to override java.lang.Object.toString
		String output = "\n";
		for(int i = 0; i <= anArray.length - 1; i++)	{
			for(int j = 0; j <= anArray[i].length - 1; j++)	{  //ROWS
				output += (anArray[i][j] + "\t\t");						//added another tab here
			}
		output += "\n";
		}                                       
		return output;
	} //end of toString
}



