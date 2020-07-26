import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShortestJobFirst{
    public static void shortestJobFirst(LinkedHashMap<String, Integer> jobs, int time, float turnaround){

        // specific process used to sort linkedhashmap in ascending order (shortest first)
        LinkedHashMap<String, Integer> jobMap = jobs.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // displaying prompt for SJF
        System.out.println("Shortest-Job-First (SJF): \n");
        System.out.println("Job\t\tStart Time\tEnd Time\tJob Description\n");

        // displaying start times, calculating end times
        for (String job : jobMap.keySet()){
            System.out.print(job + "\t\t" + time + "\t\t");
            time += jobs.get(job);
            turnaround += time;
            System.out.println(time + "\t\t" + job + " completed at time " + time);
        }

        // displaying average turnaround time
        System.out.print("\nAverage turnaround time (SJF): ");
        System.out.printf("%.2f / %d = %.2f", turnaround, jobs.keySet().size(), (turnaround / jobs.keySet().size()));
        System.out.println("\n**********************************************************************");
   }

}