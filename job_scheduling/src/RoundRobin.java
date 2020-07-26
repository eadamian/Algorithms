import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RoundRobin{
    public static void roundRobin(LinkedHashMap<String, Integer> jobs, int time, float turnaround, int time_slice){

        // creating arraylist to queue jobs onto list
        ArrayList<String> list = new ArrayList<String>();

        // specific process used to sort linkedhashmap around time slice
        LinkedHashMap<String, Integer> jobMap = jobs.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        
        // displaying prompt for RR
        System.out.println("Round Robin with time slice = " + time_slice);
        System.out.println("Job\t\tStart Time\tEnd Time\tJob Description");

        // adding our jobs to our arraylist
        for (String job : jobs.keySet()){
            list.add(job);
        }

        // checking for jobs available inside the arraylist
        while (!list.isEmpty()) {

     		// printing start time
            String job = (String)list.remove(0);
            System.out.print(job + "\t\t" + time + "\t\t");

            // if: our job time is less than job slice, print completion
            // else: add the job to the arraylist and calculate time slice difference
            if ((Integer)jobMap.get(job) <= time_slice) {
                time += (Integer)jobMap.get(job);
                turnaround += time;
                System.out.println(time + "\t\t" + job + " completed at time " + time);
            }else{
                time += time_slice;
                jobMap.put(job, (Integer)jobMap.get(job) - time_slice);
                System.out.println(time);
                list.add(job);
           }
       }

        // displaying average turnaround time
        System.out.print("\nAverage turnaround time (RR): ");
        System.out.printf("%.2f / %d = %.2f", turnaround, jobs.keySet().size(), (turnaround / jobs.keySet().size()));
        System.out.println("\n**********************************************************************");
   }

}