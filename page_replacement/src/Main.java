// java program by Eric Adamian
// page replacement algorithms (calculates page faults)

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main{
   public static void main(String[] args) throws IOException {

      // filewriter for each file
      FileWriter fw_refString = new FileWriter("ReferenceString.txt");
      FileWriter fw_average = new FileWriter("Average.txt");
      FileWriter fw_faults = new FileWriter("Faults.txt");

      // titles for each file
      fw_refString.write("\t\t50 RANDOM STRINGS (OF SIZE 30 INTS):\n\n");
      fw_faults.write("\t\tNUMBER OF FAULTS (BY PAGE FRAME):");
      fw_average.write("\t\tAVERAGE PERFORMANCE RESULTS (BY PAGE FRAME):\n\n");

      // (3 algorithms) x (4 page frames)
      int[][] average = new int[3][4];

      // search through 50 strings with FIFO/LRU/Optimal
      for(int i = 0; i < 50; i++){         

         // 50 generated strings
         String currentString = generateRandomString();
         fw_refString.write("String " + (i + 1) + ": " + currentString + "\n\n");

         // calling each algorithm (storing in variable for average value)
         average[0][0] += fifo.pageFrameFault(currentString, 3);
         average[0][1] += fifo.pageFrameFault(currentString, 4);
         average[0][2] += fifo.pageFrameFault(currentString, 5);
         average[0][3] += fifo.pageFrameFault(currentString, 6);

         average[1][0] += lru.pageFrameFault(currentString, 3);
         average[1][1] += lru.pageFrameFault(currentString, 4);
         average[1][2] += lru.pageFrameFault(currentString, 5);
         average[1][3] += lru.pageFrameFault(currentString, 6);

         average[2][0] += optimal.pageFrameFault(currentString, 3);
         average[2][1] += optimal.pageFrameFault(currentString, 4);
         average[2][2] += optimal.pageFrameFault(currentString, 5);
         average[2][3] += optimal.pageFrameFault(currentString, 6);


         // number of faults file (while calling each algorithm)
         fw_faults.write("\n\nString " + (i +1) + ": "+ currentString);
         fw_faults.write("\n\nFaults for Page Frame 3: ");
         fw_faults.write("\n\tFIFO: " + fifo.pageFrameFault(currentString, 3));
         fw_faults.write("\n\tLRU: " + lru.pageFrameFault(currentString, 3));
         fw_faults.write("\n\tOptimal: " + optimal.pageFrameFault(currentString, 3));
        
         fw_faults.write("\n\nFaults for Page Frame 4: ");
         fw_faults.write("\n\tFIFO: " + fifo.pageFrameFault(currentString, 4));
         fw_faults.write("\n\tLRU: " + lru.pageFrameFault(currentString, 4));
         fw_faults.write("\n\tOptimal: " + optimal.pageFrameFault(currentString, 4));

         fw_faults.write("\n\nFaults for Page Frame 5: ");
         fw_faults.write("\n\tFIFO: " + fifo.pageFrameFault(currentString, 5));
         fw_faults.write("\n\tLRU: " + lru.pageFrameFault(currentString, 5));
         fw_faults.write("\n\tOptimal: " + optimal.pageFrameFault(currentString, 5));

         fw_faults.write("\n\nFaults for Page Frame 6: ");
         fw_faults.write("\n\tFIFO: " + fifo.pageFrameFault(currentString, 6));
         fw_faults.write("\n\tLRU: " + lru.pageFrameFault(currentString, 6));
         fw_faults.write("\n\tOptimal: " + optimal.pageFrameFault(currentString, 6));
         fw_faults.write("\n\n******************************************");
      }

      fw_refString.close();
      fw_faults.close();

      // average performance file
      fw_average.write("Page Frame Size 3:");
      fw_average.write("\n\tFIFO average performance: " + (average[0][0] / 50));
      fw_average.write("\n\tLRU average performance: " + (average[1][0] / 50));
      fw_average.write("\n\tOptimal average performance: " + (average[2][0] / 50));

      fw_average.write("\n\nPage Frame Size 4:");
      fw_average.write("\n\tFIFO average performance: " + (average[0][1] / 50));
      fw_average.write("\n\tLRU average performance: " + (average[1][1] / 50));
      fw_average.write("\n\tOptimal average performance: " + (average[2][1] / 50));

      fw_average.write("\n\nPage Frame Size 5:");
      fw_average.write("\n\tFIFO average performance: " + (average[0][2] / 50));
      fw_average.write("\n\tLRU average performance: " + (average[1][2] / 50));
      fw_average.write("\n\tOptimal average performance: " + (average[2][2] / 50));
      
      fw_average.write("\n\nPage Frame Size 6:");
      fw_average.write("\n\tFIFO average performance: " + (average[0][3] / 50));
      fw_average.write("\n\tLRU average performance: " + (average[1][3] / 50));
      fw_average.write("\n\tOptimal average performance: " + (average[2][3] / 50));
      fw_average.close();
}      

   // randomly generated string of ints(length 30) across 8 pages
   public static String generateRandomString() {

      StringBuilder stringbuilder = new StringBuilder();
      Random random = new Random();

      for(int i = 0;i < 30; i++){
          stringbuilder.append(random.nextInt(8));  
      }
      return stringbuilder.toString();
  }
}