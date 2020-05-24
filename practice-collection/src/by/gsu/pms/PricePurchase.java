package by.gsu.pms;

public class PricePurchase extends Purchase {

    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public PricePurchase(String name, int cost, int count, int discount) {
        super(name, cost, count);
        this.discount = discount;
    }

    public int getPrice(){
        return  getCount() * (getCost() - discount);
    }
}