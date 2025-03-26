import java.util.ArrayList;
import java.util.List;

// Originator
class Document {
    private int bill;
    private int id=1;

    
    public void write(int bill) {
        this.bill = bill;
    }

    public int getOrderId() {

        return this.id++;

    }

    public int getContent() {
        return this.bill;
    }

    public DocumentMemento createMemento() {
        return new DocumentMemento(this.bill);
    }

    public void restoreFromMemento(DocumentMemento memento) {
        this.bill = memento.getSavedbill();
    }
}

// Memento
class DocumentMemento {
    private int bill;

    public DocumentMemento(int bill) {
        this.bill = bill;
    }

    public int getSavedbill() {
        return this.bill;
    }
}

// Caretaker
class History {
    private List<DocumentMemento> mementos;

    public History() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(DocumentMemento memento) {
        this.mementos.add(memento);
    }

    public DocumentMemento getMemento(int id) {
        return this.mementos.get(id);
    }
}

public class MementoDesignPattern {
    public static void main(String[] args) {
        Document document = new Document();
        History history = new History();

        // Write some content
        document.write(4567);
        history.addMemento(document.createMemento());
        
        // Write more content
        document.write(2314);
        history.addMemento(document.createMemento());

        // Restore to previous state
        document.restoreFromMemento(history.getMemento(0));

        // Print document content
        System.out.println("Order ID: " + document.getOrderId() + ", Bill Amount: " + document.getContent());

        // Restore to previous state
        document.restoreFromMemento(history.getMemento(1));
        
        // Print document content
        System.out.println("Order ID: " + document.getOrderId() + ", Bill Amount: " + document.getContent());

        
    }
}







/*import java.util.ArrayList;
import java.util.List;

// Originator
class Document {
    private int bill;
    private String foodType;
    private static int idCounter = 1; // Static counter for unique order IDs
    private int orderId;

    public Document(String foodType) {
        this.foodType = foodType;
        this.orderId = idCounter++; // Assign a unique order ID
    }

    public void write(int bill) {
        this.bill = bill;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public int getContent() {
        return this.bill;
    }

    public DocumentMemento createMemento() {
        return new DocumentMemento(this.bill);
    }

    public void restoreFromMemento(DocumentMemento memento) {
        this.bill = memento.getSavedBill();
    }
}

// Memento
class DocumentMemento {
    private int bill;

    public DocumentMemento(int bill) {
        this.bill = bill;
    }

    public int getSavedBill() {
        return this.bill;
    }
}

// Caretaker
class History {
    private List<DocumentMemento> mementos;

    public History() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(DocumentMemento memento) {
        this.mementos.add(memento);
    }

    public DocumentMemento getMemento(int index) {
        if (index < 0 || index >= mementos.size()) {
            throw new IndexOutOfBoundsException("Invalid memento index");
        }
        return this.mementos.get(index);
    }
}

public class MementoDesignPattern {
    public static void main(String[] args) {
        Document document = new Document("Punjabi");
        History history = new History();

        // Write some content
        document.write(4567);
        history.addMemento(document.createMemento());

        // Write more content
        document.write(2314);
        history.addMemento(document.createMemento());

        // Restore to previous state
        document.restoreFromMemento(history.getMemento(0));

        // Print document content
        System.out.println("Order ID: " + document.getOrderId() + ", Bill Amount: " + document.getContent());
    }
}
*/