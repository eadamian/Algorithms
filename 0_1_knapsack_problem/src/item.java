// item class
public class item{

    // private variables for item class
    private double profit;
    private double weight;

    // constructor
    public item(){
        this.profit = 0;
        this.weight = 0;
    }

    // setters
    public void setProfit(double profit){
        this.profit = profit;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    // getters
    public double getRatio(){ 
        if (weight > 0){
        	return (int) (profit / weight);
        }else{
        	return 0;
        }
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
