package cellularData;

import java.text.DecimalFormat;  //CLASS TO SET THE DECIMAL OUTPUT TO SPECIFIC DECIMAL PALCES

public class CellularData {
	private static DecimalFormat decimalPlaces = new DecimalFormat("##.###");  //THIS SETS THE NUMBER OF PLACES TO THE RIGHT OF THE DECIMAL POINT.
	int numRows;    
	int numColumns;
	int startingYear = 1984;
	int count = 1;
	
//	String[] anotherArray;	//IF I NEED THIS ARRAY FOR THE YEARS. THIS WILL BE AN ARRAY OF INTEGERS
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
		for (int i = 1; i < anArray[0].length - 1; i++)    {  //there is an oject -type problem here!!!!!ARRAYS ARE NOW STRINGS.
//      	int foo = Integer.parseInt("1234");
        	int b = Integer.parseInt(anArray[0][i]);          //string parsed to integer
//	       	System.out.println(i);
       		if (b == startYear)    {
            	System.out.println("The index of " + b + " is " + i);
            	break;
        	}
		
//        else System.out.println(startYear + " is not in the array!!!!");
		}
		System.out.println("This prints the country and it's total cellular stats! Need to figure out year period.");
		System.out.println("The country is " + country);
		System.out.println(country + ": " + decimalPlaces.format(temp) + "\n");
		
	}
				
//******************************************************************************************	 
//*****************************************************************************************		

	public void AddYear(String[][] a)	{
	
	//    int startingYear = 1983;
    	int endingYear = 1987;
//    	int yearGap = endingYear - startingYear;                                                                        //this works
    	for (int i = 1; i < a[0].length - 1; i++)    {  //there is an oject -type problem here!!!!!ARRAYS ARE NOW STRINGS.
//      	int foo = Integer.parseInt("1234");
        	int b = Integer.parseInt(a[0][i]);          //string parsed to integer
//        	System.out.println(i);
       		if (b == 1987)    {
            	System.out.println("The index of 1987 is " + i);
            	break;
        	}
//        else System.out.println(a + " is not in the array!!!!");
    }
	}

	public void addCountry(String country, double[] a)	{          //THE ARRAY WILL STORE DATA AS A STRING THEN CONVERT INT STRINGS TO INTEGERS.
	//BE SURE TO REINITIALIZE THE ARRAY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!USING "NEW ARRAY STRING[][]"	
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
	}

	
	}



