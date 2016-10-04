// Author: Michael Fox
// Session: Advanced Java
// Project: Project 3
// Current Date: 10/3/2016
// DateDue: 1799.01.01

//Class to store the information about the CPU
public class CPU
{
    private String m_strCPULine;
    private String m_strCPUName;
    private double m_dPerformance;
    private double m_dPrice;

    /**
     * @param strCPULine is the CPU line from the file
     */
    public CPU(String strCPULine)
    {
        m_strCPULine = strCPULine;
    }

    /**
     * @param m_strCPULine - the input file line to be parsed
     */
    private void ParseCPULine(String m_strCPULine)
    {
        //TODO - use a regular expression to parse the line into the individual members
    }

    /**
     * @return  A string representing the CPU
     */
    public String toString()
    {
        //return String.format("%s\t%f\t%f\n", m_strCPUName, m_dPerformance, m_dPrice);
        return String.format("%s\n", m_strCPULine); //Just return the original line
    }
}
