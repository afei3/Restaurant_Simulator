import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {
    private ArrayList<FoodItem> inventory;
    private ArrayList<Anomaly> anomalies = new ArrayList<>();
    private int lastAnomaly = 0;
    private double restaurantQuality;
    private ArrayList<Employee> workers;
    public String[] foodTypes;
    private ArrayList<Customer> customers;
    private int currentCap;
    private int capacity;
    private int cashAvailable;

    public Restaurant() {
        inventory = new ArrayList<>();
        restaurantQuality = 0;
        workers = new ArrayList<>();
        foodTypes = new String[0];
        cashAvailable = 0;
        customers = new ArrayList<>();
        currentCap = 0;
        capacity = 0;
        cashAvailable = 0;
    }

    public static Restaurant startFromFile(String fileName) {
        Gson gson = new Gson();
        Restaurant ljs = gson.fromJson(Data.getFileContentsAsString(fileName), Restaurant.class);
        return ljs;
    }

    public ArrayList<Anomaly> getAnomalies() {
        return anomalies;
    }

    public ArrayList<Employee> getWorkers() {
        return workers;
    }

    public ArrayList<FoodItem> getInventory() {
        return inventory;
    }

    public double getRestaurantQuality() {
        return restaurantQuality;
    }

    public int getLastAnomaly() {
        return lastAnomaly;
    }

    public void setAnomalies(ArrayList<Anomaly> anomalies) {
        this.anomalies = anomalies;
    }

    public void setFoodTypes(String[] foodTypes) {
        this.foodTypes = foodTypes;
    }

    public void setInventory(ArrayList<FoodItem> inventory) {
        this.inventory = inventory;
    }

    public void setLastAnomaly(int lastAnomaly) {
        this.lastAnomaly = lastAnomaly;
    }

    public void setRestaurantQuality(double restaurantQuality) {
        this.restaurantQuality = restaurantQuality;
    }

    public void setWorkers(ArrayList<Employee> workers) {
        this.workers = workers;
    }

    public FoodItem getFoodItem(int num) {
        return inventory.get(num);
    }

    public String[] getFoodTypes() {
        return foodTypes;
    }

    public void applyAnomaly(int num) {
        lastAnomaly = num;
        String buffed = anomalies.get(num).getBuffedType();
        String nerfed = anomalies.get(num).getNerfedType();
        for (int i = 0; i < inventory.size(); ++i) {
            inventory.get(i).resetChanges();
            if (inventory.get(i).getFoodType().equals(buffed)) {
                inventory.get(i).setBuffed(true);
            } else if (inventory.get(i).getFoodType().equals(nerfed)) {
                inventory.get(i).setNerfed(true);
            }
        }
    }

    public void resetAnomaly() {
        lastAnomaly = -1;
        for (int i = 0; i < inventory.size(); ++i) {
            inventory.get(i).resetChanges();
        }
    }

    public void randomAnomaly() {
        Random r = new Random();
        int num;
        do {
            num = r.nextInt(anomalies.size());
        } while (num == lastAnomaly);
        applyAnomaly(num);
        System.out.println(num);
    }

    public void increaseQuality(double increase) {
        restaurantQuality += increase;
    }

    public void newCustomer() {
        if (capacity > currentCap) {
            customers.add(Customer.generateCustomer());
        }
    }
}
