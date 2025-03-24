//state
interface OrderState
{
    void orderhandle();
}


//concretestate order placed
class orderPlaced implements OrderState
{

    public void orderhandle()
    {
        System.out.println("Your Ordered is placed.");
    }

}

//concretestate order prepared
class orderPrepred implements OrderState
{
    public void orderhandle()
    {
        System.out.println("Your Ordered is being prepred. Chef is cooking your order");
    }
}

//concretestate order ready
class orderReady implements OrderState
{
    public void orderhandle()
    {
        System.out.println("Your Ordered is ready.");
    }
}

//concretestate order delivered
class orderDelivered implements OrderState
{
    public void orderhandle()
    {
        System.out.println("Your Ordered is delivered");
    }
}

//context 
class RestaurantContext
{
    private OrderState state;

    //transition to a new state
    public void setState(OrderState state)
    {
        this.state=state;
    }

    //execute the method of current state
    public void request() {
        state.orderhandle();  
    }
}

//client code 
public class StateDesignPattern {
    public static void main(String[] args) {

        RestaurantContext restaurant = new RestaurantContext();

        restaurant.setState(new orderPlaced()); 
        estaurant.request();

        restaurant.setState(new orderPrepred());
        restaurant.request();

        restaurant.setState(new orderReady());
        restaurant.request();

        restaurant.setState(new orderDelivered());
        restaurant.request();

    }
}




