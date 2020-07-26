// brute force class
import java.util.ArrayList;
import java.util.Arrays;

public class brute_force{

    // private variables for backtracking class
    private int n;
    private double W;
    private double maxProfit;
    private ArrayList<item> itemList;
    private int numBest;
    private String[] bestSet;
    private int counter = 0;

    // constructor (W = max weight)
    public brute_force(double W, ArrayList<item> itemList, int n){
        this.n = n;
        this.W = W;
        this.itemList = itemList;
    }

    // pseudocode implementation:

    // w[i+1] = itemList.get(i+1).getWeight();
    // p[i+1] = itemList.get(i+1).getProfit();
    // w[j] = itemList.get(j).getWeight();
    // p[j] = itemList.get(j).getProfit();

    public void knapsack(int i, double profit, double weight, String[] include){
        if((weight <= W) && (profit > maxProfit)){
            maxProfit = profit;
            numBest = i;
            bestSet = Arrays.copyOf(include, i + 1);
        }

        if(previous(i, n + 1)){
            include[i + 1] = "yes";
            knapsack(i + 1, profit + (itemList.get(i + 1).getProfit()), weight + (itemList.get(i + 1).getWeight()), include);
            include[i + 1] = "no";
            knapsack(i + 1, profit, weight, include);
        }
        counter++;
    }

    // condition for best set values in knapsack
    private boolean previous(int i, int n){
        if (i == n - 1){
            return false;
        } else{
            return true;
        }
    }

    // output values
    public void print(){
        System.out.println("Max profit: " + maxProfit);
        System.out.println("Nodes visited: " + counter);
        System.out.println("Best set: " + Arrays.toString(bestSet));
        System.out.println();
    }
}