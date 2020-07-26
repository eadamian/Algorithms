import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class fifo{   
   
   public static int pageFrameFault (String referenceString, int pageFrameTotalSize) throws IOException{

      // arrayList of total page frames (3, 4, 5, or 6)
      ArrayList<String> pageFrames = new ArrayList<>();  

      int totalFaults = 0;
      int pointer = 0;
      
      // file name and sample string
      PrintWriter pw = new PrintWriter("FIFO_PageFrame_" + pageFrameTotalSize + ".txt");
      pw.print("Sample string (from ReferenceString.txt): " + referenceString + "\n\n");    

      // looping through reference string length (30)
      for(int i = 0; i < referenceString.length(); i++){

         // if frame space is available
         if(pageFrameTotalSize > pageFrames.size()){   

            // PAGE HIT: if current value is in page frame, print current arraylist 
            if(pageFrames.contains(Character.toString(referenceString.charAt(i)))){
               pw.println(pageFrames.toString());

            // PAGE FAULT: add value to frame space, increment totalFaults
            }else{
               pageFrames.add(Character.toString(referenceString.charAt(i)));
               pw.println(pageFrames.toString());
               totalFaults++;
            }
         }

         // if frame space is full, replace first value (FIFO)
         if(pageFrameTotalSize <= pageFrames.size()){   

            // PAGE HIT: if current value is in page frame, print current arraylist 
            if(pageFrames.contains(Character.toString(referenceString.charAt(i)))){
               pw.println(pageFrames.toString());

            // PAGE FAULT: set new value to frame space using pointer, increment point
            }else{
               pageFrames.set(pointer, Character.toString(referenceString.charAt(i)));
               pw.println(pageFrames.toString());
               pointer++;
               
               if(pointer == pageFrames.size()){
                  pointer = 0;
               }
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