public class FoodItem {
    private double cost;
    private double price;
    private String description;
    private String name;
    private double servings;
    private String foodType;
    private boolean nerfed = false;
    private boolean buffed = false;
    private double currentCost;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBuffed() {
        return buffed;
    }

    public boolean isNerfed() {
        return nerfed;
    }

    public void setBuffed(boolean buffed) {
        this.buffed = buffed;
    }

    public void setServings(double servings) {
        this.servings = servings;
    }

    public void setNerfed(boolean nerfed) {
        this.nerfed = nerfed;
    }

    public void resetChanges() {
        buffed = false;
        nerfed = false;
    }

    public double getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(double currentPrice) {
        this.currentCost = currentPrice;
    }

    public void calcCurrentCost() {
        currentCost = price;
        if (buffed) {
            currentCost *= .8;
        }

        if (nerfed) {
            currentCost *= 1.2;
        }
    }
}

