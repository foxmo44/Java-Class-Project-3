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
    private boolean m_bValid;
    private String m_strCPULine;
    private String m_strCPUName;
    private int m_iPerformance;
    private double m_dPrice;

    /**
     * @param strCPULine is the CPU line from the file
     */
    public CPU(String strCPULine)
    {
        m_strCPULine = strCPULine;
        m_bValid = ParseCPULine(strCPULine);
    }

    /**
     * @param m_strCPULine - the input file line to be parsed
     */
    private boolean ParseCPULine(String m_strCPULine)
    {
        boolean bRetValue = true;
        String  strTemp;
        String strNumeric;

        //Use a regular expression to parse the line into the individual members

        //TODO - Figure out why regex not working for 1,509.00
        //messes up on the comma in the value
        String[] tokens = m_strCPULine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");  //http://rubular.com/ is helpful for regex

        m_strCPUName = tokens[0];


        //Get the performance
        try
        {
            strTemp = tokens[1];
            strNumeric = strTemp.replaceAll("[^0-9.]+", "");  //Get rid of non digit characters
            m_iPerformance = Integer.parseInt(strNumeric);
        }
        catch(NumberFormatException ex)
        {
            m_iPerformance = -1;
            bRetValue = false;
        }

        //Get the price
        try
        {
            strTemp = tokens[2];
            strNumeric = strTemp.replaceAll("[^0-9.]+", "");   //Get rid of non digit characters
            m_dPrice = Double.parseDouble(strNumeric);
        }
        catch(NumberFormatException ex)
        {
            m_dPrice = -1.0;
            bRetValue = false;
        }

//        for(String strTemp1 : tokens)
//        {
//            System.out.printf("%s\t", strTemp1);
//        }
//
//        System.out.printf("\n");

        return bRetValue;
    }

    /**
     * @return  A string representing the CPU
     */
    public String toString()
    {
        return String.format("[%b]\t%s\t\t[%d]\t[%5.2f]\n", m_bValid, m_strCPUName, m_iPerformance, m_dPrice);
        //return String.format("%s\n", m_strCPULine); //Just return the original line
    }
}
