import java.util.Scanner;

public class main {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant longJon = Restaurant.startFromFile("inventory.json");
        for (int i = 0; i < 10; i++) {
            longJon.randomAnomaly();
        }
        GridLayoutDemo.runGui(longJon.getInventory());
    }
}
