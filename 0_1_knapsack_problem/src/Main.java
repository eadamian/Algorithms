// java programs by Eric Adamian
// 0-1 Knapsack Problem approach
// implementation through brute force, branch and bound, and backtracking algorithms

import java.util.Scanner;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args){

        // initializing arraylist and scanner object
        ArrayList<item> itemList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        // user input for item to take in
        System.out.print("How many items are there to potentially take? ");
        int potentialItems = scan.nextInt();

        // user input for weight and profit based on items
        for(int i = 0; i < potentialItems; i++){

            // item object for weight and profit
            item item = new item();

            System.out.print("What is the weight of item " + (i + 1) + "? ");
            item.setWeight(scan.nextDouble());

            System.out.print("What is the profit of item " + (i + 1) + "? ");
            item.setProfit(scan.nextDouble());
            System.out.println();

            // adding our items to the arraylist
            itemList.add(item);
        }

        // user input for maximum weight of the bag
        System.out.print("What is the maximum weight the bag can hold? ");
        double W = scan.nextInt();
        System.out.println();

        // creating objects for each algorithm
        String[] include = new String[potentialItems];
        brute_force bf = new brute_force(W, itemList, potentialItems - 1);
        backtracking bt = new backtracking(W, itemList, potentialItems - 1);
        branch_and_bound bab = new branch_and_bound();

        // printing our final results
        System.out.println("Brute Force: ");
        bf.knapsack(-1, 0.0, 0.0, include);
        bf.print();

        System.out.println("Backtracking: ");
        bt.knapsack(-1, 0.0, 0.0, include);
        bt.print();

        System.out.println("Branch and Bound: ");
        bab.knapsack(potentialItems - 1, itemList, W);
        bab.print();
    }
}
