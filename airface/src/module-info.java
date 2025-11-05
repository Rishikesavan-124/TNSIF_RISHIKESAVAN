import java.util.Scanner;

// Interface
interface Airfare {
    double calculateAmount();
    void display();
}

// AirIndia class
class AirIndia implements Airfare {
    private int hours;
    private double costPerHour;

    public AirIndia() {}

    public AirIndia(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public double calculateAmount() {
        return hours * costPerHour;
    }

    @Override
    public void display() {
        System.out.printf("%.2f\n", calculateAmount());
    }
}

// KingFisher class
class KingFisher implements Airfare {
    private int hours;
    private double costPerHour;

    public KingFisher() {}

    public KingFisher(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public double calculateAmount() {
        return hours * costPerHour * 4;
    }

    @Override
    public void display() {
        System.out.printf("%.2f\n", calculateAmount());
    }
}

// Indigo class
class Indigo implements Airfare {
    private int hours;
    private double costPerHour;

    public Indigo() {}

    public Indigo(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public double calculateAmount() {
        return hours * costPerHour * 8;
    }

    @Override
    public void display() {
        System.out.printf("%.2f\n", calculateAmount());
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int hours = sc.nextInt();
        double costPerHour = sc.nextDouble();

        Airfare airfare;

        switch (choice) {
            case 1:
                airfare = new AirIndia(hours, costPerHour);
                break;
            case 2:
                airfare = new KingFisher(hours, costPerHour);
                break;
            case 3:
                airfare = new Indigo(hours, costPerHour);
                break;
            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }

        airfare.display();
        sc.close();
    }
}
