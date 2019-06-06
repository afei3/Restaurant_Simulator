import java.util.Scanner;

public class main {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant longJon = Restaurant.startFromFile("inventory.json");
        System.out.println(longJon.getFoodItem(0).getFoodType());
        System.out.println(longJon.getFoodTypes().length);
    }
}
