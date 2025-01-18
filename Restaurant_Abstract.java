import java.util.*;

interface Hotel {

    Food createFood();

    Drink createDrink(); 

    Dessert createDessert();
}

class PunjabiHotel implements Hotel {

    @Override
    public Food createFood() {
        return new PunjabiFood();
    }

    @Override
    public Drink createDrink() {
        return new PunjabiDrink();
    }

    @Override
    public Dessert createDessert() {
        return new PunjabiDessert();
    }
}

class GujaratiHotel implements Hotel {

    @Override
    public Food createFood() {
        return new GujaratiFood();
    }

    @Override
    public Drink createDrink() {
        return new GujaratiDrink();
    }

    @Override
    public Dessert createDessert() {
        return new GujaratiDessert();
    }
}

class ChineseHotel implements Hotel {

    @Override
    public Food createFood() {
        return new ChineseFood();
    }

    @Override
    public Drink createDrink() {
        return new ChineseDrink();
    }

    @Override
    public Dessert createDessert() {
        return new ChineseDessert();
    }
}

interface Food {

    public void foodOrder();
}

interface Drink {

    void drinkOrder();
}

interface Dessert {

    void dessertOrder();
}

class PunjabiFood implements Food {

    @Override
    public void foodOrder() {
        System.out.println("Punjabi food order");
    }
}

class GujaratiFood implements Food {

    @Override
    public void foodOrder() {
        System.out.println("Gujarati food order");
    }
}

class ChineseFood implements Food {

    @Override
    public void foodOrder() {
        System.out.println("Chinese food order");
    }
}

class PunjabiDrink implements Drink {

    @Override
    public void drinkOrder() {
        System.out.println("Lassi ordered");
    }
}

class GujaratiDrink implements Drink {

    @Override
    public void drinkOrder() {
        System.out.println("Chass ordered");
    }
}

class ChineseDrink implements Drink {

    @Override
    public void drinkOrder() {
        System.out.println("Green tea ordered");
    }
}

class PunjabiDessert implements Dessert {

    @Override
    public void dessertOrder() {
        System.out.println("Jalabi ordered");
    }
}

class GujaratiDessert implements Dessert {

    @Override
    public void dessertOrder() {
        System.out.println("Doodhpak ordered");

    }
}

class ChineseDessert implements Dessert {

    @Override
    public void dessertOrder() {
        System.out.println("Almond cookies ordered");
    }
}

// Client
class Restaurant_Abstract {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your taste (spicy, sweet, other):");
        String choice = sc.next();

        Hotel factory = getHotelFactory(choice);
        Food food = factory.createFood();
        Drink drink = factory.createDrink();
        Dessert dessert = factory.createDessert();

        food.foodOrder();
        drink.drinkOrder();
        dessert.dessertOrder();
        sc.close();
    }

    private static Hotel getHotelFactory(String taste) {
        switch (taste) {
            case "spicy":
                return new PunjabiHotel();
            case "sweet":
                return new GujaratiHotel();
            case "other":
                return new ChineseHotel();
            default:
                return null;
        }
    }
}
