import java.util.ArrayList;

// Component
interface Hotel {

    void display();
    void Order();

    
    
}

//composite
class Gujarati implements Hotel
{
    private ArrayList<Hotel> items =new ArrayList<>();

    public void add(Hotel hotel)
    {
        items.add(hotel);
    }

    public void remove(Hotel hotel)
    {
        items.remove(hotel);
    }

    public void display()
    {
        System.out.println("Gujarati Food is prepared");
     
       for (Hotel hotel : items) {
        hotel.display();
       }
     
    }

    public void Order()
    {
        System.out.println("Gujarati order is placed");
        for (Hotel hotel : items) {
            hotel.Order();
        }
    }

}

class GujBreakfast implements Hotel
{
    public void display() {
        System.out.println("Dholka is being prepared.");
    }

    public void Order() {
        System.out.println("Dholka order is placed.");
    }
}

class GujDinner implements Hotel
{
    public void display() {
        System.out.println("Puran Poli is being prepared.");
    }

    public void Order() {
        System.out.println("Puran Poli order is placed.");
    }
}

class GujLunch implements Hotel
{
    public void display() {
        System.out.println("Gujarati Thali is being prepared.");
    }

    public void Order() {
        System.out.println("Gujarati Thali order is placed.");
    }
}
//leaf
class Punjabi implements Hotel
{
        public void display()
        {
            System.out.println("Punjabi Food is beign Prepared");
            System.out.println("Paratha, Dal Makhani");
            System.out.println("Lassi, Jalabi");

        }

        public void Order()
        {
            System.out.println("Punjabi food is ordered");
        }
        
}   



public class component_design_pattern {
    public static void main(String[] args) {
        Gujarati guj =new Gujarati();
        guj.add(new GujBreakfast());
        guj.add(new GujLunch());
        guj.add(new GujDinner());
        guj.display();
        guj.Order();

        System.out.println(" ");
        Punjabi pun=new Punjabi();
        pun.display();
        pun.Order();
    }
}


