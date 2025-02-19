/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dsa
 */

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

public class NewClass {
    public static void main(String[] args) {
        RestaurantFacade restaurantFacade = new RestaurantFacade();

        restaurantFacade.placeOrder(new Punjabi()); 
        restaurantFacade.placeOrder(new Gujarati()); 
        restaurantFacade.placeOrder(new Chinese()); 
        
        restaurantFacade.drinkOrder(new Punjabi()); 
        restaurantFacade.drinkOrder(new Gujarati()); 
        restaurantFacade.drinkOrder(new Chinese()); 
        
        restaurantFacade.dessertOrder(new Punjabi()); 
        restaurantFacade.dessertOrder(new Gujarati()); 
        restaurantFacade.dessertOrder(new Chinese()); 
    }
}