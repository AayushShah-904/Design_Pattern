
import java.util.ArrayList;
import java.util.List;

// Originator (Document)
class Document {

    private int bill;

    public void write(int bill) {
        this.bill = bill;
    }

    public int getBillAmount() {
        return this.bill;
    }

    // storing the current bill amount.
    public DocumentMemento createMemento() {
        return new DocumentMemento(this.bill);
    }

    public void restoreFromMemento(DocumentMemento memento) {
        this.bill = memento.getSavedBill();
    }
}

// Memento (Captures state)
class DocumentMemento {

    private final int bill;

    //Saves a copy of the bill amount
    public DocumentMemento(int bill) {
        this.bill = bill;
    }

    public int getSavedBill() {
        return this.bill;
    }
}

// Caretaker (History)
class History {

    private final List<Snapshot> snapshots = new ArrayList<>();
    private int orderId = 1;  // Tracks unique order IDs

    //Stores Each Order ID with Memento
    public static class Snapshot {

        int orderId;
        DocumentMemento memento;

        Snapshot(int orderId, DocumentMemento memento) {
            this.orderId = orderId;
            this.memento = memento;
        }

        public int getOrderId() {
            return orderId;
        }

        public DocumentMemento getMemento() {
            return memento;
        }
    }   

    public void addMemento(DocumentMemento memento) {
        snapshots.add(new Snapshot(orderId++, memento)); //Stores Multiple Copies
    }

    public Snapshot getSnapshot(int index) {
        if (index < 0 || index >= snapshots.size()) {
            throw new IndexOutOfBoundsException("Invalid snapshot index: " + index);
        }
        return snapshots.get(index);
    }
}

public class MementoDesignPattern {

    public static void main(String[] args) {
        Document document = new Document();
        History history = new History();

        // Save first state
        document.write(4567);
        history.addMemento(document.createMemento());

        // Save second state
        document.write(2314);
        history.addMemento(document.createMemento());

        // restore first state
        History.Snapshot snapshot1 = history.getSnapshot(1);
        System.out.println("Order ID: " + snapshot1.getOrderId() + ", Bill Amount: " + document.getBillAmount());

        // Restore first saved state
        History.Snapshot snapshot2 = history.getSnapshot(0);
        document.restoreFromMemento(snapshot2.getMemento());
        System.out.println("Restored -> Order ID: " + snapshot2.getOrderId() + ", Bill Amount: " + document.getBillAmount());

        // Restore second saved state
        History.Snapshot snapshot3 = history.getSnapshot(1);
        document.restoreFromMemento(snapshot3.getMemento());
        System.out.println("Restored -> Order ID: " + snapshot3.getOrderId() + ", Bill Amount: " + document.getBillAmount());
    }
}
