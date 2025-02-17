import java.util.Scanner;
interface Hotel {

    public void order();
}
class Punjabi implements Hotel {

    @Override
    public void order() {
        System.out.println("Punjabi food is being cooked");
    }
}
class Gujarati implements Hotel {

    @Override
    public void order() {
        System.out.println("Gujarati food is being cooked");
    }
}
class Chinese implements Hotel {

    @Override
    public void order() {
        System.out.println("Chinese food is being cooked");
    }
}
class HotelFactory {

    public static Hotel getHotel(String taste) {
        switch (taste.toLowerCase()) {
            case "punjabi":
                return new Punjabi();

            case "gujarati":
                return new Gujarati();

            case "chinese":
                return new Chinese();

            default:
                System.out.println("Invalid taste choice. Please enter spicy, sweet, or other.");
                return null;
        }
    }
}

class Restaurant {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your taste (spicy,sweet,other)");
        System.out.println("Welcome to resturant");
        String choice = sc.next();
        Hotel hotel = HotelFactory.getHotel(choice);;
        if (hotel != null) {
            hotel.order();
        }
        sc.close();
    }
}
