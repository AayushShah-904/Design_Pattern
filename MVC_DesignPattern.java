import java.util.ArrayList;
import java.util.Scanner;
import java.util.scanner;

import org.omg.PortableInterceptor.HOLDING;

//Modal
public class MenuItem
{
    private String name;
    private int price;

    MenuItem(String name,int price)
    {
        this.name=name;
        this.price=price;
    }
    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }
}

public class MenuList
{
    private List<MenuItem> menu=new ArrayList<>();

    HotelController
    {
        menu.add(new MenuItem("Gujarti Thali",250));
        menu.add(new MenuItem("Panner Tikka",300));
        menu.add(new MenuItem("Noodles",150));
        menu.add(new MenuItem("Chass",30));
        menu.add(new MenuItem("Cold Drink",40));
    }

    public List<MenuItem> getMenu()
    {
        return menu;
    }

    public MenuItem getItemByName()
    {
        for (MenuItem item: menu) {
            return item;
            
        }
        return null;
    }
}


//view
public class HotelView
{
    Scanner sc =new Scanner(System.in);
    public void displayMenu(List<MenuItem> menu)
    {
        System.out.println("Restaurant Menu");
        for (MenuItem item: menu) {
            System.out.println("Item Name" + item.getName() + "Item Price " + item.getPrice());            
        }
    }

    public String itemOrdered()
    {
        System.out.println("Enter your order ");
        return sc.nextLine();
    }

    public void orderConformation(MenuItem item)
    {
        if(item!=null)
        {
            System.out.println("Your item is sucessfully ordered.  Item Name" + item.getName() + "Item Price " + item.getPrice());
        }
        else
        {
            System.out.println("Item not found");
        }
    }
}

//controller
public class HotelController
{
    private MenuList list;
    private HotelView view;

    public HotelController(MenuItem item,HotelView view)
    {
        this.item=item;
        this.view=view;
    }

    public void showMenu()
    {
        view.displayMenu(list.getMenu());
    }

    public void takeOrder()
    {
        String order=view.itemOrdered();
        MenuItem item=list.getItemByName(order);
        view.orderConformation(item);
    }
}   


public class MVC_DesignPattern {
    public static void main(String[] args) {
        MenuList m=new MenuList();
        HotelView v=new HotelView();
        HotelController c=new HotelController(m, v);
        
        c.showMenu();
        c.takeOrder();
    }
}
