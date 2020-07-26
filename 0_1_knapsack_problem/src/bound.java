// bound class (extension of branch and bound class)
import java.util.ArrayList;

public class bound{

    public double bound(node u, int n, ArrayList<item> itemList, double W){

        // variables
        int j, k;
        double totweight;
        double result;

        // pseudocode implementation:

        // w.weight = u.getWeight()
        // u.profit = u.getProfit()
        // u.weight = u.getWeight()
        // w[j] = itemList.get(j).getWeight()


        if(u.getWeight() >= W){
            return 0;
        }else{
            result = u.getProfit();
            j = u.getLevel() + 1;
            totweight = u.getWeight();
            while (j <= n && totweight + (itemList.get(j).getWeight()) <= W){
                totweight = totweight + (itemList.get(j).getWeight());
                result = result + (itemList.get(j).getProfit());
                j++;
            }
            k = j;
            if(k <= n){
                result = result + (W - totweight) * (itemList.get(k).getProfit() / itemList.get(k).getWeight());
            }
            return result;
        }
    }
}