package by.gsu.pms;

public class Purchase implements Comparable<Purchase>{

    public String name;
    public int cost;
    public int count;

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public Purchase(String name, int cost, int count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    @Override
    public String toString() {
        return name + ";" + cost + ";" + count;
    }

    @Override
    public int compareTo(Purchase p){
        return Integer.compare(this.getCost(), p.getCost());
    }

    public int getPrice(){
        return count * cost;
    }
}

