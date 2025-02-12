interface Target
{
    public double getPriceinUSD();
    public void setPriceinUSD(double setPriceinUSD);
    public double getPriceinINR();
    public void setPriceinINR(double setPriceinINR);
}


class Adaptee
{
    double price;
    public Adaptee(){};

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price=price;
    }
}

class Adapter extends Adaptee implements Target
{
    public double getPriceinUSD()
    {
        return getPrice();
    }

    public void setPriceinUSD(double price)
    {
        setPrice(price);
    }

    public double getPriceinINR()
    {
        return USDtoINR(getPrice());
    }

    public void setPriceinINR(double setPriceinINR)
    {
        setPrice(INRtoUSD(setPriceinINR));
    }
    
    private double USDtoINR(double USD)
    {
        return USD*86.7;
    }

    private double INRtoUSD(double INR)
    {
        return INR/86.7;
    }


}

public class Adapter_Design_Pattern
{
    public static void main(String args[])
    {
        Target adapter = new Adapter();

        adapter.setPriceinUSD(100);
        System.out.println("Price in USD: " + adapter.getPriceinUSD());
        System.out.println("Price in INR: " + adapter.getPriceinINR());

        adapter.setPriceinINR(500);
        System.out.println("Price in USD: " + adapter.getPriceinUSD());
        System.out.println("Price in INR: " + adapter.getPriceinINR());
        
      

    }

}