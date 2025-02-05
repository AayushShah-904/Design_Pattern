import java.util.ArrayList;
// Component
interface Hotel {

    void display();
    
}

class DineOut implements Hotel{
    private String order;
    private ArrayList<Hotel> orderList;

    public DineOut(String order)
    {
        this.order=order;
        this.orderList=new ArrayList<>();
    }

    public void setOrder(String order)
    {
        this.order=order;
    }
    
    public ArrayList<Hotel> getOrder()
    {
        return orderList;
    }
    
    public void addOrder(Hotel order) {
        orderList.add(order);
    }

    public void removeOrder(Hotel order) {
        orderList.remove(order);
    }
    public void display() {
        System.out.println("DineOut Order " +order);
        for(Hotel arr : orderList)
        {
            arr.display();
        }
    }
    
}

//leaf
class DineIn implements Hotel {
    private String order;

    public DineIn(String order)
    {
        this.order=order;
    }

    public void setOrder(String order)
    {
        this.order=order;
    }
    
    public String getOrder()
    {
        return order;
    }

    public void display() {
        System.out.println("DineIn Order " + order);
    }
}

public class component_design_pattern {
    public static void main(String[] args) {
        System.out.println("Welcome to restaturant");

        DineIn d1=new DineIn("Lassi");
        DineIn d2=new DineIn("GulabJamu");

        DineOut punj=new DineOut("Punjabi");
        punj.addOrder(d1);
        punj.addOrder(d2);

        punj.display();
    }
}


