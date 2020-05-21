package by.gsu.pms;

public class BusinessTrip {

    private static final int rate = 25000;
    private String account;
    private int priceTransport;
    private int numberDays;

    public BusinessTrip() {

    }

    public BusinessTrip(String account, int priceTransport, int numberDays){
        this.account = account;
        this.priceTransport = priceTransport;
        this.numberDays = numberDays;
    }

    public int getPriceTransport() {
        return priceTransport;
    }
    public void setPriceTransport(int priceTransport) {
        this.priceTransport = priceTransport;
    }
    public int getNumberDays() {
        return numberDays;
    }
    public void setNumberDays(int numberDays) {
        this.numberDays = numberDays;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    private int getTotal(){
        return (priceTransport + rate * numberDays);
    }

    public void show() {
        System.out.println("rate = " + rate);
        System.out.println("account = " + account);
        System.out.println("transport = " + priceTransport);
        System.out.println("days = " + numberDays);
        System.out.println("total = " + getTotal());
    }

    public String toString() {
        return account + ";" + priceTransport + ";" + numberDays + ";" + getTotal();
    }

}




