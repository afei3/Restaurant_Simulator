public class Customer {
    private double cash;

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public static Customer generateCustomer() {
        return new Customer();
    }
}
