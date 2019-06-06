public class FoodItem {
    private double cost;
    private double price;
    private String description;
    private String name;
    private double servings;
    private String foodType;

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        return price;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getServings() {
        return servings;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }
}

