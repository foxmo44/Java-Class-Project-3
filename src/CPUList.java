import java.util.ArrayList;
import java.util.stream.IntStream;

// Author: Michael Fox
// Session: Advanced Java
// Project: Project 3
// Current Date: 10/3/2016
// DateDue: 1799.01.01
public class CPUList
{
    ArrayList<CPU> theList = new ArrayList<>();

    /**
     * Default constructor for the CPU
     */
    public void CPUList()
    {

    }

    /**
     * @param strInputLine Input line to be used in creating the CPU object
     */
    public void AddCpu(String strInputLine)
    {
        theList.add(new CPU(strInputLine));
    }

    /**
     * @return the combined string showing the CPU list
     */
    public String toString()
    {
        String strString = "";

        for (CPU cpu : theList)
        {
            strString += cpu;
        }

        return(strString);
    }

    //Determine the following and return the string indicating the following
    //        average price of CPU's
    //        highest priced CPU
    //        lowest priced CPU
    //        best value CPU (performance / price )
    //TODO - Write this function using stream methods
    public String DetermineStatistics()
    {
        String strTemp = "todo";


        return strTemp;
    }
}
