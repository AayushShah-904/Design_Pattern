interface Shape {
    Shape getclone(); 
    void draw();   
}

// Concrete prototype
class Circle implements Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    // This creates a copy of the circle.
    @Override
    public Shape getclone() {
        return new Circle(this.color);
       
    }

    // This is how a circle draws itself.
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}

// Client code
class ShapeClient {
    Shape s;
    public ShapeClient(Shape s)
    {
        this.s=s;

    }

    public void  ShapeMethod()
    {
        s.getclone();
    }

    public void ShapeDraw()
    {
        s.draw();
    }
}

// Main class
public class PrototypeExample {
    public static void main(String[] args) {
        Circle c1=new Circle("Red");
        

        ShapeClient s1=new ShapeClient(c1);
        s1.ShapeMethod();
        s1.ShapeDraw();
          
    }
}