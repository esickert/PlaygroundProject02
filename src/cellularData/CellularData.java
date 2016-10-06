package cellularData;

public class CellularData {
	
	int numRows;    
	int numColumns = 8;
	int startingYear;
	int count = 0;
	
	Object[][] anArray;
	
	public CellularData()	{    //constructor
	}
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //REMEMBER PARAMETERS NEED TYPE...CONSTRUCTOR
		this.numRows = numRows;
		this.numColumns = numColumns;  //THIS MAYBE LIMITING THE ARRAYS SIZE  NEED TO USE COUNTRY.LENGTH!!!!!!!!!!!!!!!!!!!
		this.startingYear = startingYear;
		anArray = new Object[numRows][numColumns];  //this is an array of Object class
	}
//****************************************************************************************************
//TESTING	
/*	public void addYear()	{                          				 //NOW I'M HACKING!!!!
		for(int i = 1983; i <= 1990 +	7; i++)
				System.out.print( i + "\t");	
	}  */
	
	
	public void addCountry(String country, double[] a)	{
		
			anArray[count][0] = country;							//THIS IS NOT WORKING PROPERLY. OVERWRITES FIRST ENTRY!!!!!
			for (int i = 1; i <= a.length-1; i++)	{       		//TESTING. 
				anArray[count][i] = a[i];
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
		}                                       // which all subclasses inherit from
		return output;
	}

	
	}



