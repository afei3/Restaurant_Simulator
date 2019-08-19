public class Customer {
    private double cash;
    private int id;
    private static int idGenerator = 0;

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public static Customer generateCustomer() {
        return new Customer();
    }

    public Customer() {
        cash = 0;
        id = idGenerator;
        idGenerator++;
    }

    public int getId() {
        return id;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setIdGenerator(int idGenerator) {
        Customer.idGenerator = idGenerator;
    }
}
