// Author: Michael Fox
// Session: Advanced Java
// Project: Project 3
// Current Date: 9/25/2016
// DateDue: 2016.10.12

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Project03Fox
{
    /**
     * This the main function that runs at the start
     * @param args - input arguments from the command line
     */
    static public void main(String[] args)
    {
        CPUList cpuList = new CPUList();

        try
        {

            Files.lines(Paths.get("Project03Data.csv"))
                    .map(line -> line.split("\r\n")) // Stream<String[]>
                    .flatMap(Arrays::stream) // Stream<String>
                    .forEach(line -> cpuList.AddCpu(line));

            //The following will print out the list as loaded with a flag indicating if the line was valid or not
            //It will then do a clean operation on the list to remove the invalid lines.  It will then do the statistics

            System.out.println("---------------Input-----------------------");
            System.out.print(cpuList);
            System.out.println("--------------Cleaned----------------------");
            cpuList.CleanCpuList();
            System.out.print(cpuList);
            System.out.println("-------------Statistics--------------------");
            cpuList.PrintStatistics();
            System.out.println("-------------------------------------------");


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
