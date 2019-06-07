import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {
    private ArrayList<FoodItem> inventory;
    private ArrayList<Anomaly> anomalies = new ArrayList<>();
    private int lastAnomaly;
    public String[] foodTypes;

    public static Restaurant startFromFile(String fileName) {
        Gson gson = new Gson();
        Restaurant ljs = gson.fromJson(Data.getFileContentsAsString(fileName), Restaurant.class);
        return ljs;
    }

    public FoodItem getFoodItem(int num) {
        return inventory.get(num);
    }

    public String[] getFoodTypes() {
        return foodTypes;
    }

    public void applyAnomaly(int num) {
        lastAnomaly = num;
    }

    public void randomAnomaly() {
        Random r = new Random();
        int num = r.nextInt(anomalies.size() + 1);
        System.out.println(num);
    }
}
