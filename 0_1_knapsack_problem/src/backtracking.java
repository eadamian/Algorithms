// backtracking class
import java.util.ArrayList;
import java.util.Arrays;

public class backtracking{

    // private variables for backtracking class
    private int n;
    private double W;
    private double maxProfit;
    private ArrayList<item> itemList;
    private int numBest;
    private String[] bestSet;
    private int counter = 0;

    // constructor (W = max weight)
    public backtracking(double W, ArrayList<item> itemList, int n){
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

        if(promising(i, weight, profit)){
            include[i + 1] = "yes";
            knapsack(i + 1, profit + (itemList.get(i + 1).getProfit()), weight + (itemList.get(i + 1).getWeight()), include);
            include[i + 1] = "no";
            knapsack(i + 1, profit, weight, include);
        }
        counter++;
    }

    private boolean promising(int i, double weight, double profit){
        double bound;

        if(weight >= W){
            return false;
        } else {
            int j = i + 1;
            bound = profit;
            double totweight = weight;

            while(j <= n && totweight + (itemList.get(j).getWeight()) <= W){
                totweight = totweight + itemList.get(j).getWeight();
                bound = bound + itemList.get(j).getProfit();
                j++;
            }
            int k = j;
            if(k <= n){
                bound = bound + (W - totweight) * (itemList.get(k).getProfit() / itemList.get(k).getWeight());
            }
        }
        return bound > maxProfit;
    }

    // output values
    public void print(){
        System.out.println("Max profit: " + maxProfit);
        System.out.println("Nodes visited: " + counter);
        System.out.println("Best set: " + Arrays.toString(bestSet));
        System.out.println();
    }
}