import java.util.ArrayList;
import java.util.List;

// Subject Interface
 interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

// Observer Interface
 interface Observer {
    void update(int x, int y);
}

// Concrete Subject: Point
class ConcreteSubjectPoint implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
        notifyObservers();
    }

    public void setY(int y) {
        this.y = y;
        notifyObservers();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(x, y);
        }
    }
}

// Concrete Subject: Line
class ConcreteSubjectLine implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
        notifyObservers();
    }

    public void setY(int y) {
        this.y = y;
        notifyObservers();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(x, y);
        }
    }
}

class PointObserver implements Observer {
    private String name;

    public PointObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int x, int y) {
        System.out.println(name + " observed update: x = " + x + ", y = " + y);
    }
}

public class Observer_DesignPattern {
    public static void main(String[] args) {
        ConcreteSubjectPoint point = new ConcreteSubjectPoint();
        ConcreteSubjectLine line = new ConcreteSubjectLine();

        Observer observer1 = new PointObserver("Observer1");
        Observer observer2 = new PointObserver("Observer2");

        point.addObserver(observer1);
        point.addObserver(observer2);

        line.addObserver(observer1);

        System.out.println("Updating Point:");
        point.setX(10);
        point.setY(20);

        System.out.println("\nUpdating Line:");
        line.setX(100);
        line.setY(200);
    }
}
