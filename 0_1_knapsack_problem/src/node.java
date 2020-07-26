// node class
public class node implements Comparable<node> {

    // private variables for node class
    private int level;
    private double bound;
    private double profit;
    private double weight;

    // constructor
    public node() {
        level = 0;
        bound = 0.0;
        profit = 0.0;
        weight = 0.0;
    }

    public node(int x) {
        level = -1;
        bound = 0.0;
        profit = 0.0;
        weight = 0.0;
    }

    // setters
    public void setLevel(int level) {
        this.level = level;
    }

    public void setBound(double bound) {
        this.bound = bound;
    }

    public void setProfit(double profit){
        this.profit = profit;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // getters
    public int getLevel(){
        return level;
    }

    public double getBound(){
        return bound;
    }

    public double getProfit(){
        return profit;
    }

    public double getWeight(){
        return weight;
    }

    // bound compareTo
    public int compareTo(node n){
        if(getBound() < n.getBound()){
            return 1;
        }else if (getBound() > n.getBound()){
            return -1;
        }
        return 0;
    }
}