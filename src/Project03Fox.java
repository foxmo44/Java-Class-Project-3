import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

// Author: Michael Fox
// Session: Advanced Java
// Project: Project 3
// Current Date: 9/25/2016
// DateDue: 1799.01.01
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
            //Wonder if a pattern should be used like in concordance.
            //Also another possibility is to feed line into a CPU object with a regular expression
            //to populate the member variables within the the object then use a comparator for the
            //objects.

            Files.lines(Paths.get("Project03Data.csv"))
                    .map(line -> line.split("\r\n")) // Stream<String[]>
                    .flatMap(Arrays::stream) // Stream<String>
                    .forEach(line -> cpuList.AddCpu(line));

            System.out.print(cpuList);
            System.out.print(cpuList.DetermineStatistics());


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
