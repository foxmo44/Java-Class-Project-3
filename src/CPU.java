// Author: Michael Fox
// Session: Advanced Java
// Project: Project 3
// Current Date: 10/3/2016
// DateDue: 1799.01.01

//Regular expression input
// ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)" will pick out the commas only

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Class to store the information about the CPU
public class CPU
{
    private String m_strCPULine;
    private String m_strCPUName;
    private double m_dPerformance;
    private double m_dPrice;
    private Pattern patternNumber = Pattern.compile("[0-9]{3,4}");   //TODO find the pattern needed to parse the line using http://rubular.com/

    /**
     * @param strCPULine is the CPU line from the file
     */
    public CPU(String strCPULine)
    {
        m_strCPULine = strCPULine;

        ParseCPULine(strCPULine);
    }

    /**
     * Parse the line into the CPU, Performance, and Price and populate the fields
     * @param m_strCPULine - the input file line to be parsed
     */
    private void ParseCPULine(String m_strCPULine)
    {
        boolean bRetValue = true;
        String  strTemp;

        //Use a regular expression to parse the line into the individual members

        String[] tokens = m_strCPULine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        m_strCPUName = tokens[0];


//TODO - Figure out why double parse is not working
        //Get the performance
        try
        {
            strTemp = tokens[1];
            strTemp.replaceAll("\\D","");  //Get rid of non digit characters
            m_dPerformance = Double.parseDouble(tokens[1]);
        }
        catch(NumberFormatException ex)
        {
            m_dPerformance = -1.0;
            bRetValue = false;
        }

        //Get the price
        try
        {
            strTemp = tokens[2];
            strTemp.replaceAll("\\D","");   //Get rid of non digit characters
            m_dPrice = Double.parseDouble(tokens[2]);
        }
        catch(NumberFormatException ex)
        {
            m_dPrice = -1.0;
            bRetValue = false;
        }

//        for(String strTemp : tokens)
//        {
//            System.out.printf("%s\t", strTemp);
//        }
//
//        System.out.printf("\n");

    }

    /**
     * @return  A string representing the CPU
     */
    public String toString()
    {
        return String.format("%s\t[%f]\t[%f]\n", m_strCPUName, m_dPerformance, m_dPrice);
        //return String.format("%s\n", m_strCPULine); //Just return the original line
    }
}
