// branch and bound class
import java.util.ArrayList;
import java.util.PriorityQueue;

public class branch_and_bound {

    // variables
    private int counter = 0;
    private double maxProfit = 0;

    PriorityQueue<node> pq = new PriorityQueue<>();
    node u = new node();
    node v = new node(0);
    bound bound = new bound();

    // pseudocode implementation:

    // u.level = u.setLevel()
    // v.level = v.getLevel()
    // u.weight = u.setWeight()
    // v.weight = v.getWeight()
    // u.profit = u.setProfit()
    // v.profit = v.getProfit()
    // w[u.level] = itemList.get(u.getLevel()).getWeight()
    // p[u.level] = itemList.get(u.getLevel()).getProfit()

    // enqueue and increments nodes visited
    public void knapsack(int n, ArrayList<item> itemList, double W) {
        v.setBound(bound.bound(v, n, itemList,W));
        pq.add(v);
        counter++;

        // dequeue pq for v
        while(!pq.isEmpty()) {
            v = pq.remove();

            // when bound is greater than our max profit
            if(v.getBound() > maxProfit) {
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight() + itemList.get(u.getLevel()).getWeight());
                u.setProfit(v.getProfit() + itemList.get(u.getLevel()).getProfit());
                u.setBound(bound.bound(u, n, itemList, W));
                counter++;

                // finding our new max profit
                if(u.getWeight() <= W && u.getProfit() > maxProfit) {
                    maxProfit = u.getProfit();
                }

                // enqueue u to pq
                if(u.getBound() > maxProfit) {
                    pq.add(u);
                }

                // setting u as a new node
                u = new node();

                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight());
                u.setProfit(v.getProfit());
                u.setBound(bound.bound(u, n, itemList, W));
                counter++;

                // enqueue u to pq
                if(u.getBound() > maxProfit) {
                    pq.add(u);
                }

                // setting u as a new node
                u = new node();
            }
        }
    }

    // output values
    public void print(){
        System.out.println("Max profit: " + maxProfit);
        System.out.println("Nodes visited: " + counter);
    }
}
