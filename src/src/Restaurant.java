import com.google.gson.Gson;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<FoodItem> inventory;
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
}
