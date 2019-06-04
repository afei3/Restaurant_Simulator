import com.google.gson.Gson;

import java.util.ArrayList;

public class Restaurant {
    ArrayList<FoodItem> inventory;

    public static Restaurant startFromFile(String fileName) {
        Gson gson = new Gson();
        Restaurant ljs = gson.fromJson(Data.getFileContentsAsString(fileName), Restaurant.class);
        return ljs;
    }
}
