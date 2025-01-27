import java.util.Scanner;;

class SingletonFactory
{
    private static SingletonFactory instance;

    private SingletonFactory()
    {
        System.out.println("I am singleton factory method");
    }
    public static SingletonFactory getsingleton()
    {
        if(instance==null)
        {
            instance =new SingletonFactory();
        }
        return instance;
    }
}
public class singleton {
    public static void main(String[] args) {
        SingletonFactory s1=SingletonFactory.getsingleton();
        SingletonFactory s2=SingletonFactory.getsingleton();

        System.out.println("Are both instances the same? " + (s1 == s2));
    }
}

// ls -ltrSiu