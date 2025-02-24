interface HotelKeeper {
    void order();
    void drink();
    void dessert();
 
}

class Punjabi implements HotelKeeper {
    public void order() {
        System.out.println("Punjabi order is placed.");
    }
    public void drink()
    {
        System.out.println("Lassi is prepared");
    }
    
    public void dessert()
    {
          System.out.println("Jalabi ordered");
    }
    
   
}

class Gujarati implements HotelKeeper {
    public void order() {
        System.out.println("Gujarati order is placed.");
    }
    
    public void drink()
    {
         System.out.println("Chass ordered");
    }
    
    public void dessert()
    {
          System.out.println("Doodhpak ordered");
    }
    
    
}

class Chinese implements HotelKeeper {
    public void order() {
        System.out.println("Chinese order is placed.");
    }
    
    public void drink()
    {
        System.out.println("Green tea ordered");
    }
    
    public void dessert()
    {
        System.out.println("Almond cookies ordered");
    }
    
    
}

class RestaurantFacade {
    public void placeOrder(HotelKeeper hotelKeeper) {
        hotelKeeper.order();
        
    }
    public void drinkOrder(HotelKeeper hotelKeeper) {
        hotelKeeper.drink();
        
    }
    
    public void dessertOrder(HotelKeeper hotelKeeper) {
        hotelKeeper.dessert();
        
    }
    
}

public class Facade {
    public static void main(String[] args) {
        RestaurantFacade restaurantFacade = new RestaurantFacade();
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.print("Enter cuisine (punjabi, gujarati, chinese) or 'exit' to quit: ");
            choice = sc.next().toLowerCase();

            switch (choice) {
                case "punjabi":
                    restaurantFacade.placeOrder(new Punjabi());
                    restaurantFacade.drinkOrder(new Punjabi());
                    restaurantFacade.dessertOrder(new Punjabi());
                    break;

                case "gujarati":
                    restaurantFacade.placeOrder(new Gujarati());
                    restaurantFacade.drinkOrder(new Gujarati());
                    restaurantFacade.dessertOrder(new Gujarati());
                    break;

                case "chinese":
                    restaurantFacade.placeOrder(new Chinese());
                    restaurantFacade.drinkOrder(new Chinese());
                    restaurantFacade.dessertOrder(new Chinese());
                    break;

                case "exit":
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!choice.equals("exit"));

        sc.close();
    }
}
