import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class lru{

   public static int pageFrameFault(String referenceString, int pageFrameTotalSize) throws IOException{

      // linkedList of total page frames (3, 4, 5, or 6)
      LinkedList<String> pageFrames = new LinkedList<>();
      
      int totalFaults = 0;

      // file name and sample string
      PrintWriter pw = new PrintWriter("LRU_PageFrame_" + pageFrameTotalSize + ".txt");
      pw.print("Sample string (from ReferenceString.txt): " + referenceString + "\n\n");

      // looping through reference string length (30)
      for (int i = 0; i < referenceString.length(); i++){
         
         // if frame space is available
         if(pageFrameTotalSize > pageFrames.size()){

            // PAGE HIT: if current value is in page frame, print current linkedlist 
            if(pageFrames.contains(Character.toString(referenceString.charAt(i)))){
               pw.println(pageFrames.toString());

            // PAGE FAULT: add value to frame space, increment totalFaults   
            }else{
               pageFrames.addLast(Character.toString(referenceString.charAt(i)));
               pw.println(pageFrames.toString());
               totalFaults++;
            }
         }

         // if frame space is full, replace least recently used value (LRU)
         if(pageFrameTotalSize <= pageFrames.size()){
            
            // PAGE HIT: if current value is in page frame, put in last place for frame space
            if(pageFrames.contains(Character.toString(referenceString.charAt(i)))){
               pageFrames.remove(pageFrames.indexOf(Character.toString(referenceString.charAt(i))));
               pageFrames.addLast(Character.toString(referenceString.charAt(i)));
               pw.println(pageFrames.toString());

            // PAGE FAULT: if current value is not in string, remove first frame, then add last frame
            }else{ 
               pageFrames.removeFirst();
               pageFrames.addLast(Character.toString(referenceString.charAt(i)));
               pw.println(pageFrames.toString());
               totalFaults++;
            }
         }
      }

      // printing total page faults
      pw.print("\n\nTotal page faults: " + totalFaults);
      pw.close();

      return totalFaults;
   }
}