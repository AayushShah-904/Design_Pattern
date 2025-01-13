import java.util.Scanner;

interface Hotel {
    public void order();
}

class punjabi implements Hotel {
    public void order() {
        System.out.println("Punjabi food is being cooked");
    }
}

class gujarati implements Hotel {
    public void order() {
        System.out.println("Gujarati food is being cooked");
    }
}

class chinese implements Hotel {
    public void order() {
        System.out.println("Chinese food is being cooked");
    }
}

interface FoodTaste {
     void tastes();

}

class Taste implements FoodTaste {
    public void tastes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your taste");
        String choice = sc.next();

        switch (choice) {
            case "spicy":
                Hotel punj = new punjabi();
                punj.order();
                break;

            case "sweet":
                Hotel guj = new gujarati();
                guj.order();
                break;

            case "other":
                Hotel chin = new chinese();
                chin.order();
                break;

            default:
                System.out.println("Invalid taste choice. Please enter spicy, sweet, or other.");
                break;
        }
        sc.close();

    }
}

class HotelFactory {
    public static void main(String args[]) {
        System.out.println("Welcome to resturant");
        Taste taste = new Taste();
        taste.tastes();
    }
}