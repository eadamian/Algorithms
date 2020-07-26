// item class
public class item{

    // private variables for item class
    private int ratio;
    private double profit;
    private double weight;

    // constructor
    public item(){
        this.ratio = (int) (profit / weight);
        this.profit = 0;
        this.weight = 0;
    }

    // setters
    public void setRatio() {
        this.ratio = (int) (profit / weight);
    }

    public void setProfit(double profit){
        this.profit = profit;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    // getters
    public double getRatio(){
        return ratio;
    }

    public double getProfit(){
        return profit;
    }

    public double getWeight(){
        return weight;
    }

    // bound compareTo
    public int compareTo(item i){
        if(getRatio() < i.getRatio()){
            return 1;
        } else if (getRatio() > i.getRatio()){
            return -1;
        }
        return 0;
    }
}