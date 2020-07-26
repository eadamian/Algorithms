import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class optimal{

   public static int pageFrameFault(String referenceString, int pageFrameTotalSize) throws FileNotFoundException{

      // LinkedList of total page frames (3, 4, 5, or 6)
      LinkedList<String> pageFrames = new LinkedList<>();
      
      int totalFaults = 0;

      // file name and sample string
      PrintWriter pw = new PrintWriter("Optimal_PageFrame_" + pageFrameTotalSize + ".txt");
      pw.print("Sample string (from ReferenceString.txt): " + referenceString + "\n\n");

      // looping through reference string length (30)
      for(int i = 0; i < referenceString.length(); i++){

         // if frame space is available
         if(pageFrameTotalSize > pageFrames.size()){

            // PAGE HIT: if current value is in page frame, print current linkedlist 
            if(pageFrames.contains(Character.toString(referenceString.charAt(i)))){ 
               pw.println(pageFrames.toString());

            // PAGE FAULT: add value to frame space, increment totalFaults 
            }else{ 
               pageFrames.add(Character.toString(referenceString.charAt(i)));
               pw.println(pageFrames.toString() );
               totalFaults++;
            } 
         }

         // if frame space is full, replace least recently used value (LRU)
         if(pageFrameTotalSize <= pageFrames.size()){ 

            // PAGE HIT: if current value is in page frame, print current linkedlist 
            if(pageFrames.contains(Character.toString(referenceString.charAt(i)))){
               pw.println(pageFrames.toString());

            // PAGE FAULT: searching for optimal value to replace, increment totalFaults 
            }else{ 
               pageFrames.remove(farthestPage(pageFrames, referenceString));
               pageFrames.add(farthestPage(pageFrames, referenceString), Character.toString(referenceString.charAt(i)));
               pw.println(pageFrames.toString() );
               totalFaults++;
            }
         }
      }

      // printing total page faults
      pw.print("\n\nTotal page faults: " + totalFaults);
      pw.close();
         
      return totalFaults;
   }
      
   // calculates page replacement for optimal solution if linkedlist is full
    static int farthestPage(LinkedList<String> pageFrames, String referenceString){

      int farthest = 0;

      // looping through remaining string
      for(int i = 0; i < referenceString.length(); i++){

         // checks for current values in page frame
         // removes page frame, based on furthest in string(of size 30) versus int in linkedlist
         // adds/replaces last value for optimal solution
         if(farthest < pageFrames.size()){
            if(pageFrames.contains(Character.toString(referenceString.charAt(i)))){
               pageFrames.remove(pageFrames.indexOf(Character.toString(referenceString.charAt(i))));
               pageFrames.addLast(Character.toString(referenceString.charAt(i)));
            }
         }
      }
      return farthest;
   }
}