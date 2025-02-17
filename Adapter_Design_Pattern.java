import java.util.Scanner;

interface Target {
    public double getPriceinUSD();
    public void setPriceinUSD(double setPriceinUSD);
    public double getPriceinINR();
    public void setPriceinINR(double setPriceinINR);
}

// USD
class Adaptee {
    double price;

    public Adaptee() {}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Convert USD to INR
class Adapter extends Adaptee implements Target {
    public double getPriceinUSD() {
        return getPrice();
    }

    public void setPriceinUSD(double price) {
        setPrice(price);
    }

    public double getPriceinINR() {
        return USDtoINR(getPrice());
    }

    public void setPriceinINR(double setPriceinINR) {
        setPrice(INRtoUSD(setPriceinINR));
    }

    private double USDtoINR(double USD) {
        return USD * 86.7; // Conversion rate
    }

    private double INRtoUSD(double INR) {
        return INR / 86.7; // Conversion rate
    }
}

public class Adapter_Design_Pattern {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Target adapter = new Adapter();

        // Input price in USD
        System.out.print("Enter price in USD: ");
        double priceInUSD = scanner.nextDouble();
        adapter.setPriceinUSD(priceInUSD);
        System.out.println("Price in USD: " + adapter.getPriceinUSD());
        System.out.println("Price in INR: " + adapter.getPriceinINR());

        // Input price in INR
        System.out.print("Enter price in INR: ");
        double priceInINR = scanner.nextDouble();
        adapter.setPriceinINR(priceInINR);
        System.out.println("Price in USD: " + adapter.getPriceinUSD());
        System.out.println("Price in INR: " + adapter.getPriceinINR());

        scanner.close();
    }
}
