import java.util.LinkedHashMap;

public class FirstComeFirstServe{
    public static void firstComeFirstServe(LinkedHashMap<String, Integer> jobs, int time, float turnaround){
        
        // displaying prompt for FCFS
        System.out.println("**********************************************************************");
        System.out.println("First-Come-First-Serve (FCFS): \n");
        System.out.println("Job\t\tStart Time\tEnd Time\tJob Description\n");

        // displaying start times, calculating end times
        for (String job : jobs.keySet()){
            System.out.print(job + "\t\t" + time + "\t\t");
            time += jobs.get(job);
            turnaround += time;
            System.out.println(time + "\t\t" + job + " completed at time " + time);
        }
        
        // displaying average turnaround time
        System.out.print("\nAverage turnaround time (FCFS): ");
        System.out.printf("%.2f / %d = %.2f", turnaround, jobs.keySet().size(), (turnaround / jobs.keySet().size()));
        System.out.println("\n**********************************************************************");
    }
}