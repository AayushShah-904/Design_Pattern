import java.util.*;

// Menu Item 
class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

//Iterator Interface 
interface MenuIterator {
    boolean hasNext();
    MenuItem next();
}

//Concrete Iterator 
class CategoryMenuIterator implements MenuIterator {
    private List<MenuItem> items;
    private int index = 0;

    //Keeps a list of MenuItems and a current index
    CategoryMenuIterator(List<MenuItem> items) {
        this.items = items;
    }

    //checks if there are more items left to traverse.
    public boolean hasNext() {
        return index < items.size();
    }

    //returns the current item and moves forward
    public MenuItem next() {
        return hasNext() ? items.get(index++) : null;
    }
}

//Collection Interface
interface Menu {
    void addItem(String name, double price);
    MenuIterator createIterator();
    String getCuisineName();
}

//Concrete Collections

class GujaratiMenu implements Menu {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(String name, double price) {
        items.add(new MenuItem(name, price));
    }

    public MenuIterator createIterator() {
        return new CategoryMenuIterator(items);
    }

    public String getCuisineName() {
        return "Gujarati Menu";
    }
}

class PunjabiMenu implements Menu {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(String name, double price) {
        items.add(new MenuItem(name, price));
    }

    public MenuIterator createIterator() {
        return new CategoryMenuIterator(items);
    }

    public String getCuisineName() {
        return "Punjabi Menu";
    }
}

class ChineseMenu implements Menu {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(String name, double price) {
        items.add(new MenuItem(name, price));
    }

    public MenuIterator createIterator() {
        return new CategoryMenuIterator(items);
    }

    public String getCuisineName() {
        return "Chinese Menu";
    }
}

// Client
public class iterator {
    public static void main(String[] args) {

        Menu gujaratiMenu = new GujaratiMenu();
        gujaratiMenu.addItem("Dhokla", 50);
        gujaratiMenu.addItem("Thepla", 30);

        Menu punjabiMenu = new PunjabiMenu();
        punjabiMenu.addItem("Paneer Tikka", 150);

        Menu chineseMenu = new ChineseMenu();
        chineseMenu.addItem("Fried Rice", 120);
        chineseMenu.addItem("Manchurian", 130);

        displayMenu(gujaratiMenu);
        displayMenu(punjabiMenu);
        displayMenu(chineseMenu);
    }

    public static void displayMenu(Menu menu) {
        System.out.println(" " + menu.getCuisineName());
        MenuIterator iterator = menu.createIterator();

        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(" - " + item.name + " : Rs " + item.price);
        }
    }
}

























//The iterator handles how we loop through the items in the menu, while the menu collection defines the 
//actual dishes and their prices. The client code (Main) just asks for the items without worrying about the internal structure.