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
    private int hour;
    private int minute;

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

    public void customerDone(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == i) {
                customers.remove(i);
                break;
            }
        }
    }

    public void runDay() {
        hour = 0;
        minute = 0;
        for (int i = 0; i < 720; i++) {
            incrementTime();
        }
    }

    public void runWeek() {
        for (int i = 0; i < 7; i++) {
            runDay();
        }
    }

    public void incrementTime() {
        minute++;
        if (minute == 60) {
            minute = 0;
            hour++;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getCashAvailable() {
        return cashAvailable;
    }

    public int getCurrentCap() {
        return currentCap;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCashAvailable(int cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public void setCurrentCap(int currentCap) {
        this.currentCap = currentCap;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
