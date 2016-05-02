package fr.languor.model;

public class ObjetReference {

    private int reference;
    private String color;
    private float price;
    private int size;

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ObjetReference{" +
                "reference=" + reference +
                ", color=" + color +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
