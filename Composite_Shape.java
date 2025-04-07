import java.util.*;

class Image {
    private String shape;

    Image(String shape) {
        this.shape = shape;
    }

    public String toString() {
        return shape;
    }
}

abstract class Element {

    Element() {
    }

    void prepare() {
        // Prepare the element
        System.out.println("Preparing Element");
    }

    abstract void renderTo();
}

class Form extends Element {
    private ArrayList<Element> el = new ArrayList<>();

    public void add(Element e) {
        el.add(e);

    }

    public void renderTo() {
        for (Element e : el) {
            e.prepare();
            e.renderTo();
        }
    }

}

class Picture extends Element {
    private Image image;

    Picture(Image image) {
        this.image = image;
    }

    public void renderTo() {
        System.out.println("Picture is rendered " + image);
    }
}

class StaticTextElement extends Element {
    private String text;

    StaticTextElement(String text) {
        this.text = text;
    }

    public void renderTo() {
        System.out.println("Text is rendered " + text);

    }
}

public class Composite_Shape {
    public static void main(String[] args) {

        Form form = new Form();
        Image image = new Image("Rectangle");

        form.add(new Picture(image));
        form.add(new StaticTextElement("Good Morning"));

        form.renderTo();

    }
}
