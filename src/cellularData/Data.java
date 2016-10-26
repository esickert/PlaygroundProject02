package cellularData;

public class Data {

//	String[][] anArray;
    int numRows = 3;
    int numColumns = 8;
    int startingYear = 1983;

	public void AddYear(String[][] a)	{
	
	//    int startingYear = 1983;
    int endingYear = 1987;
//    int yearGap = endingYear - startingYear;                                                                        //this works
    for (int i = 1; i < a[0].length - 1; i++)    {  //there is an oject -type problem here!!!!!ARRAYS ARE NOW STRINGS.
//      int foo = Integer.parseInt("1234");
        int b = Integer.parseInt(a[0][i]);          //string parsed to integer
        System.out.println(i);
        if (b == 1987)    {
            System.out.println("The index of 1987 is " + i);
            break;
        }
        else System.out.println(a + " is not in the array!!!!");
    }
	
	
	}

}
