interface HotelBuilder
{
    void Taste(String taste);
    void Dessert(String dessert);
    void Drink(String drink);
}

class PunjabiBuilder implements HotelBuilder
{
    String taste;
    String dessert;
    String drink;
   
    public PunjabiBuilder(){
        
    }
    public PunjabiBuilder(PunjabiBuilder pb) {
        this.taste = pb.taste;
        this.dessert=pb.dessert;
        this.drink=pb.drink;

    }

    @Override
    public void Taste(String taste)
    {
        this.taste=taste;
    }
    
    @Override
    public void Dessert(String dessert)
    {
        this.dessert=dessert;
    }


    @Override
    public void Drink(String drink)
    {
        this.drink=drink;
    }

    public PunjabiBuilder build()
    {
        return new PunjabiBuilder(this);
    }

    @Override
    public String toString() {
        return "Punjabi Taste: " + taste + ", Dessert: " + dessert + ", Drink: " + drink;
    }
}


class GujartiBuilder implements HotelBuilder
{
    String taste;
    String dessert;
    String drink;
   
    public GujartiBuilder(){
        
    }
    public GujartiBuilder(GujartiBuilder pb) {
        this.taste = pb.taste;
        this.dessert=pb.dessert;
        this.drink=pb.drink;

    }

    @Override
    public void Taste(String taste)
    {
        this.taste=taste;
    }
    
    @Override
    public void Dessert(String dessert)
    {
        this.dessert=dessert;
    }


    @Override
    public void Drink(String drink)
    {
        this.drink=drink;
    }

    public GujartiBuilder build()
    {
        return new GujartiBuilder(this);
    }

    @Override
    public String toString() {
        return "Gujarti Taste: " + taste + ", Dessert: " + dessert + ", Drink: " + drink;
    }
}

public class Main {
    public static void main(String args[])
    {
        PunjabiBuilder punjbuilder =new PunjabiBuilder();
        punjbuilder.Taste("Spicy");
        punjbuilder.Dessert("Yogurt");
        punjbuilder.Drink("Lassi");
        PunjabiBuilder pbuilder = punjbuilder.build();
        System.out.println(pbuilder);

        GujartiBuilder gujbuilder = new GujartiBuilder();
        gujbuilder.Taste("Sweet");
        gujbuilder.Dessert("Doodhpak");
        gujbuilder.Drink("Chai");
        GujartiBuilder gbuilder = gujbuilder.build();
        System.out.println(gbuilder);
    }
}

