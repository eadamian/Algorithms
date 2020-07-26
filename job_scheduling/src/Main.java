// java program by Eric Adamian
// job scheduling with FCFS, SJF, and RR
// calculates job completion and turnaround time

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException{

        // initalizing variables
        int time;
        float turnaround;

        // scanner
        Scanner scan = new Scanner(new File(args[0]));

        // linkedhashmap used to maintain order jobs are read    
        LinkedHashMap<String, Integer> jobs = new LinkedHashMap<String, Integer>();

        // reads each value, first the string (job title), then its value (time)
        while(scan.hasNextLine()){
            jobs.put(scan.nextLine(), Integer.parseInt(scan.nextLine()));
        }

        // checks for an empty file
        if(jobs.isEmpty()){
            System.out.println("ERROR: File is empty. Please try again.");
            System.exit(0);
        }

        // creating an object for each class
        FirstComeFirstServe fcfs = new FirstComeFirstServe();
        ShortestJobFirst sjf = new ShortestJobFirst();
        RoundRobin rr = new RoundRobin();

        // calling each class
        fcfs.firstComeFirstServe(jobs, 0, 0);
        sjf.shortestJobFirst(jobs, 0, 0);
        rr.roundRobin(jobs, 0, 0, 2);
        rr.roundRobin(jobs, 0, 0, 5);     
   }

}