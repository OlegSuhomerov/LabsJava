package by.gsu.by;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;
    public PriceDiscountPurchase() {
    }
    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }
    public PriceDiscountPurchase(Scanner sc) {
    	super(sc);
        this.discount = new Byn(sc.nextInt());
    }
    public Byn getDiscount() {
        return discount;
    }
    public void setDiscount(Byn discount) {
        this.discount = discount;
    }
    @Override
    public Byn getCost() {
    	Byn cost = new Byn(discount);
        return super.getCost().sub(cost.mul(getNumber()));
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}