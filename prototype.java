import java.util.Scanner;

interface Hotel extends Cloneable {
    void order();
    Hotel clone(); 
}

class Punjabi implements Hotel {
    public void order() {
        System.out.println("Punjabi food is being cooked");
    }

    public Hotel clone() {
        return new Punjabi(); 
    }
}

class Gujarati implements Hotel {
    public void order() {
        System.out.println("Gujarati food is being cooked");
    }

    public Hotel clone() {
        return new Gujarati(); 
    }
}


class Chinese implements Hotel {
    public void order() {
        System.out.println("Chinese food is being cooked");
    }

    public Hotel clone() {
        return new Chinese(); 
    }
}


class HotelPrototype {
    private static final Punjabi punjPrototype = new Punjabi(); 
    private static final Gujarati gujPrototype = new Gujarati(); 
    private static final Chinese chinPrototype = new Chinese(); 

    public static Hotel getHotel(String taste) {
        switch (taste.toLowerCase()) {
            case "spicy":
                return punjPrototype.clone(); 
            case "sweet":
                return gujPrototype.clone(); 
            case "other":
                return chinPrototype.clone(); 
            default:
                throw new IllegalArgumentException("Invalid taste: " + taste);
        }
    }
}


public class prototype{
    public static void main(String[] args) {
        System.out.println("Welcome to the restaurant");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your taste (spicy, sweet, other):");
        String taste = sc.nextLine();

        try {
            Hotel hotel = HotelPrototype.getHotel(taste); 
            hotel.order(); 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close(); 
        }
    }
}
