package cellularData;

public class CellularData {
	
	int numRows;    
	int numColumns = 8;
	int startingYear;
	int count = 0;
	
	Object[] anotherArray;	
	Object[][] anArray;
	
	
	public CellularData()	{    //constructor
	}
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //REMEMBER PARAMETERS NEED TYPE...CONSTRUCTOR
		this.numRows = numRows;
		this.numColumns = numColumns;  								  //THIS MAY BE LIMITING THE ARRAYS SIZE  NEED TO USE COUNTRY.LENGTH!??????????
		this.startingYear = startingYear;
		anArray = new Object[numRows][numColumns + 1];  //this is an array of Object class  NOTE THAT I ADD 1 HERE WHICH IS A HACK!!
		anotherArray = new Object[startingYear];	    //THIS IS AN ABSOLUTE HACK
	}
//****************************************************************************************************
//TESTING	
	public void addYears()	{ 
		System.out.print("Country Year\t");                         				 //THIS IS WAAAAY NOT RIGHT.
		for(int i = startingYear; i <= 1990; i++)
				System.out.print( i + "\t");
		System.out.println();	
	}  
	
	
	public void addCountry(String country, double[] a)	{
		
			anArray[count][0] = country;							//THIS IS NOT WORKING PROPERLY. ARRAY STARTING IS WRONG
			for (int i = 1; i <= a.length ; i++)	{       		//TESTING. 
				anArray[count][i] = a[i-1];							//THE LOADING ARRAY IS STARTING AT 1 INSTEAD OF 0. OK THIS WORKS BUT NOT CORRECTLY.
			
			}
			count++;
	}
	
	public double getNumSubscriptionsInCountryForPeriod()	{  		//INCOMPLETE METHOD
		double result = 0.0;
		return result;
	}  
	
//*****************************************************************************************************	  
	public String toString()	{ //this works to override java.lang.Object.toString
		String output = "";
		for(int i = 0; i <= anArray.length - 1; i++)	{
			for(int j = 0; j <= anArray[i].length - 1; j++)	{  //ROWS
				output += (anArray[i][j] + "\t");
			}
		output += "\n";
		}                                       
		return output;
	}

	
	}



