package by.gsu.pms;

public class BuisnessTrip {

    private static final int DAILY_RATE = 25000;

    private String account;
    private int days_quantity;
    private int transport_cost;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getDays_quantity() {
        return days_quantity;
    }

    public void setDays_quantity(int days_quantity) {
        this.days_quantity = days_quantity;
    }

    public int getTransport_cost() {
        return transport_cost;
    }

    public void setTransport_cost(int transport_cost) {
        this.transport_cost = transport_cost;
    }


    public BuisnessTrip(String account, int transport_cost, int days_quantity) {
        this.account = account;
        this.transport_cost = transport_cost;
        this.days_quantity = days_quantity;
    }

    public float get_total(){
        if (days_quantity == 1){
            return transport_cost;
        } else {
            return DAILY_RATE * days_quantity + transport_cost;
        }
    }

    @Override
    public String toString() {
        return account  + ";" + days_quantity + ";" + transport_cost;
    }

    public void show(){
        System.out.println("\nФамилия:" + account);
        System.out.println("Дневная норма:" + DAILY_RATE);
        System.out.println("Кол-во дней:" + days_quantity);
        System.out.println("Оплата транспорта:" + transport_cost);
        System.out.println("Итоговая сумма:" + get_total());
    }
}