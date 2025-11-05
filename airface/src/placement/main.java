package placement;
import java.util.*;

// Interface
interface Airfare {
    double calculateAmount();
}

// AirIndia Class
class AirIndia implements Airfare {
    private int hours;
    private double costPerHour;

    public AirIndia() {}

    public AirIndia(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }

    public double getCostPerHour() { return costPerHour; }
    public void setCostPerHour(double costPerHour) { this.costPerHour = costPerHour; }

    @Override
    public double calculateAmount() {
        return hours * costPerHour;
    }
}

// KingFisher Class
class KingFisher implements Airfare {
    private int hours;
    private double costPerHour;

    public KingFisher() {}

    public KingFisher(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    @Override
    public double calculateAmount() {
        return hours * costPerHour * 4;
    }
}

// Indigo Class
class Indigo implements Airfare {
    private int hours;
    private double costPerHour;

    public Indigo() {}

    public Indigo(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    @Override
    public double calculateAmount() {
        return hours * costPerHour * 8;
    }
}

// Main Driver Class
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your choice (1-AirIndia, 2-KingFisher, 3-Indigo):");
        int choice = sc.nextInt();
        System.out.println("Enter hours of travel:");
        int hours = sc.nextInt();
        System.out.println("Enter cost per hour:");
        double costPerHour = sc.nextDouble();

        Airfare airfare = null;

        if (choice == 1)
            airfare = new AirIndia(hours, costPerHour);
        else if (choice == 2)
            airfare = new KingFisher(hours, costPerHour);
        else if (choice == 3)
            airfare = new Indigo(hours, costPerHour);
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        double amount = airfare.calculateAmount();
        System.out.printf("Total Amount: %.2f\n", amount);

        sc.close();
    }
}