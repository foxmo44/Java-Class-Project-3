// Author: Michael Fox
// Session: Advanced Java
// Project: Project 3
// Current Date: 10/3/2016
// DateDue: 1799.01.01

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Class to store the information about the CPU
public class CPU
{
    private String m_strCPULine;
    private String m_strCPUName;
    private double m_dPerformance;
    private double m_dPrice;
    private Pattern patternNumber;

    /**
     * @param strCPULine is the CPU line from the file
     */
    public CPU(String strCPULine)
    {
        m_strCPULine = strCPULine;
    }

    /**
     * Parse the line into the CPU, Performance, and Price and populate the fields
     * @param m_strCPULine - the input file line to be parsed
     */
    private void ParseCPULine(String m_strCPULine)
    {
        //Use a regular expression to parse the line into the individual members

        //Split the line into parts using a regular expression
        Matcher matchFields = patternNumber.matcher(m_strCPULine);

        if(matchFields.find())
        {
            m_strCPUName = matchFields.group();
        }
        else
        {
            m_strCPUName = "???";
        }

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
