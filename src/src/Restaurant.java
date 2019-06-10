import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {
    private ArrayList<FoodItem> inventory;
    private ArrayList<Anomaly> anomalies = new ArrayList<>();
    private int lastAnomaly = 0;
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

    public void randomAnomaly() {
        Random r = new Random();
        int num;
        do {
            num = r.nextInt(anomalies.size());
        } while (num == lastAnomaly);
        applyAnomaly(num);
        System.out.println(num);
    }
}
