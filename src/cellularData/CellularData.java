package cellularData;

public class CellularData {
	
	int numRows;    //these are not being initialized correctly. the array needs to be in a constructor.
	int numColumns;
	int startingYear;
	
	int rows = numRows;
	int col = numColumns;
	Object[][] anArray;
	
	
//	String[][] anArray = new String[numRows][numColumns];  //this is an array of Object class
//	String[][] anArray = new String[][];  //this is an array of Object class

	
	public CellularData()	{    //constructor
	}
	
	public CellularData(int numRows, int numColumns, int startingYear)	{  //REMEMBER PARAMETERS NEED TYPE...CONSTRUCTOR
//		this.numRows = 3;
//		this.numColumns = 7;
//		this.startingYear = startingYear;
		anArray = new Object[numRows][numColumns];  //this is an array of Object class
	}
	
	public void addCountry(String country, double[] a)	{
		anArray[0][0] = country;
		for (int i = 1; i <= a.length - 1; i++)	{
				anArray[0][i] = a[i];
		}
	}  
//		
	
	
	
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



