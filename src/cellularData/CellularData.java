package cellularData;

public class CellularData {
	
	int numRows;    //these are not being initialized correctly. the array needs to be in a constructor.
	int numColumns;
	int startingYear;
	
	Object[][] anArray;
	
	
//	String[][] anArray = new String[numRows][numColumns];  //this is an array of Object class
//	String[][] anArray = new String[][];  //this is an array of Object class

	
	public CellularData()	{    //constructor
	}
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //REMEMBER PARAMETERS NEED TYPE...CONSTRUCTOR
		this.numRows = numRows;
		this.numColumns = 7;  //THIS MAYBE LIMITING THE ARRAYS SIZE
		this.startingYear = startingYear;
		anArray = new Object[numRows][numColumns];  //this is an array of Object class
	}
//****************************************************************************************************
//TESTING	
	public void addCountry(String country, double[] a)	{  //numRows is a global variable??
			System.out.println("Global variable numRows is " + (numRows));
			numRows = numRows -1;
			anArray[numRows][0] = country;
			for (int i = 1; i <= a.length-1; i++)	{       ///OKAY THIS IS WRONG HERE!!! IM TESTING.
					anArray[numRows][i] = a[i];
			}
			System.out.println("Global variable numRows is " + (numRows=numRows - 1)); //okay this is decreasing!!!!!!! I'M TESTING
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



