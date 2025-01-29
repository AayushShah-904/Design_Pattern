import java.util.Scanner;;

class RestaurantFactory
{
    private static RestaurantFactory instance;

    private RestaurantFactory()
    {
        System.out.println("Welcome to Restaurant");
    }

    public static RestaurantFactory getsingleton()
    {
        if(instance==null)
        {
            instance =new RestaurantFactory();
        }
        return instance;
    }

    public static void punjabiOrder()
    {
        System.out.println("Punjabi food is been ordered");
    }

    public static void gujaratiOrder()
    {
        System.out.println("Gujarati food is been ordered");
    }

    public static void chineseOrder()
    {
        System.out.println("Chinese food is been ordered");
    }
}
public class singleton {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your taste (spicy, sweet, other):");
        String choice = sc.next();

        RestaurantFactory s1=RestaurantFactory.getsingleton();
        switch (choice) {
            case "spicy":
                s1.punjabiOrder();
                break;
            case "sweet":
                s1.gujaratiOrder();

            case "other":
                s1.chineseOrder();
            default:
                break;
        }
       
    }
}

