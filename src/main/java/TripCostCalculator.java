import java.util.Scanner;

public class TripCostCalculator {
    public static double calculateCost(int distance, double fuelEfficiency, double fuelPrice) {
        return distance / fuelEfficiency * fuelPrice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the distance in km:");
        int distance = scanner.nextInt();
        System.out.println("Enter the fuel efficiency in km/l:");
        double fuelEfficiency = scanner.nextDouble();
        System.out.println("Enter the fuel price per liter:");
        double fuelPrice = scanner.nextDouble();
        double cost = calculateCost(distance, fuelEfficiency, fuelPrice);
        System.out.printf("The cost of the trip is: %.2f euros", cost);
    }
}
